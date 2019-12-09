package bytecode;

import ast.Modifier;
import ast.Program;
import astPojos.BlockStatement;
import com.google.common.collect.ImmutableSet;
import com.sun.org.apache.bcel.internal.Constants;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ArrayType;
import org.apache.bcel.generic.*;
import staticchecks.LocalVariableInfoTable;
import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.*;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.FileSystems;
import java.util.*;

import static org.apache.commons.lang3.CharEncoding.UTF_8;

public class BytecodeCreator {

    private static int modifierSetToAccessFlags(Set<Modifier> modifiers) {
        int accessFlag = 0;
        if (modifiers.contains(Modifier.PUBLIC)) {
            accessFlag = Constants.ACC_PUBLIC;
        } else if (modifiers.contains(Modifier.PRIVATE)) {
            accessFlag = Constants.ACC_PRIVATE;
        } else if (modifiers.contains(Modifier.PROTECTED)) {
            accessFlag = Constants.ACC_PROTECTED;
        }

        if (modifiers.contains(Modifier.STATIC)) {
            accessFlag |= Constants.ACC_STATIC;
        }
        return accessFlag;
    }

    public static Type resolvedTypeToBcelType(ResolvedType t) {
        if (t == PrimitiveType.VOID) {
            return Type.VOID;
        }
        if (t == PrimitiveType.INT) {
            return Type.INT;
        }
        if (t == PrimitiveType.BOOLEAN) {
            return Type.BOOLEAN;
        }
        if (t == PrimitiveType.CHAR) {
            return Type.CHAR;
        }
        if (t instanceof ClassType) {
            ClassType classType = (ClassType) t;
            if (classType.getClassName().equals("Object")) {
                return Type.OBJECT;
            }
            if (classType.getClassName().equals("String")) {
                return Type.STRING;
            }
            return new ObjectType(classType.getClassName());
        }
        assert (t instanceof staticchecks.resolvedInfo.ArrayType) : "Was not a class type or a primitive type";
        staticchecks.resolvedInfo.ArrayType arrayType = (staticchecks.resolvedInfo.ArrayType) t;
        return new ArrayType(resolvedTypeToBcelType(arrayType.getType()), arrayType.getDimension());
    }

    public static void toBytecode(Program p, String filepath) throws IOException {
        Map<String, ClassInfo> classInfoMap = StaticChecksHelper.buildClassInfo(p);

        //Step 1: Type check
        for (Map.Entry<String, ClassInfo> classInfoEntry : classInfoMap.entrySet()) {
            if (ImmutableSet.of("Object", "String", "IO").contains(classInfoEntry.getKey())) {
                continue;
            }
            for (ResolvedMethod resolvedMethod : classInfoEntry.getValue().getMethods().values()) {
                boolean isVirtual = !resolvedMethod.getModifiers().contains(Modifier.STATIC);
                LocalVariableInfoTable variableTable = new LocalVariableInfoTable(isVirtual,
                                                                                  resolvedMethod.getArguments());
                StaticState s = StaticState.builder()
                                           .setClasses(classInfoMap)
                                           .setReturnType(resolvedMethod.getReturnType())
                                           .setCurrentClass(classInfoEntry.getKey())
                                           .setLocalVariableTable(variableTable)
                                           .build();
                resolvedMethod.getBody().typeCheck(s);
            }
            ResolvedConstructor constructor = classInfoEntry.getValue().getConstructor();
            boolean isVirtual = !constructor.getModifiers().contains(Modifier.STATIC);
            LocalVariableInfoTable variableTable = new LocalVariableInfoTable(isVirtual,
                                                                              constructor.getArguments());
            StaticState s = StaticState.builder()
                                       .setClasses(classInfoMap)
                                       .setReturnType(PrimitiveType.VOID)
                                       .setCurrentClass(classInfoEntry.getKey())
                                       .setLocalVariableTable(variableTable)
                                       .setFirstStatementInConstructorCall(true)
                                       .build();
            constructor.getBody().typeCheck(s);
        }

        //Step 2: Build info for bytecode pass
        Map<String, ClassGen> javaClassMap = new HashMap<>();
        for (Map.Entry<String, ClassInfo> classEntry : classInfoMap.entrySet()) {
            String superName = classNameToBcelName(classEntry.getValue().getSuperClassName());
            ClassGen classGen = new ClassGen(classEntry.getKey(), superName, null, Constants.ACC_PUBLIC, null);

            for (Map.Entry<String, ResolvedField> field : classEntry.getValue().getFields().entrySet()) {
                int accessFlag = modifierSetToAccessFlags(field.getValue().getModifiers());
                Type fieldType = resolvedTypeToBcelType(field.getValue().getType());
                FieldGen fieldGen = new FieldGen(accessFlag, fieldType, field.getKey(), classGen.getConstantPool());
                classGen.addField(fieldGen.getField());
            }

            for (Map.Entry<String, ResolvedMethod> methodEntry : classEntry.getValue().getMethods().entrySet()) {
                ResolvedMethod method = methodEntry.getValue();
                int accessFlags = modifierSetToAccessFlags(method.getModifiers());
                Type returnType = resolvedTypeToBcelType(method.getReturnType());
                Type[] argTypes = method.getArguments().stream()
                                        .map(rp -> resolvedTypeToBcelType(rp.getType()))
                                        .toArray(Type[]::new);
                String[] argNames = method.getArguments().stream()
                                          .map(ResolvedParam::getName)
                                          .toArray(String[]::new);
                MethodGen methodGen = new MethodGen(accessFlags,
                                                    returnType,
                                                    argTypes,
                                                    argNames,
                                                    methodEntry.getKey(),
                                                    classEntry.getKey(),
                                                    new InstructionList(),
                                                    classGen.getConstantPool());
                methodGen.setMaxLocals();
                methodGen.setMaxStack();
                classGen.addMethod(methodGen.getMethod());
            }
            {
                ResolvedConstructor constructor = classInfoMap.get(classEntry.getKey()).getConstructor();
                int constructorAccessFlags = modifierSetToAccessFlags(constructor.getModifiers());
                Type[] argTypes = constructor.getArguments().stream()
                                             .map(rp -> resolvedTypeToBcelType(rp.getType()))
                                             .toArray(Type[]::new);
                String[] argNames = constructor.getArguments().stream()
                                               .map(ResolvedParam::getName)
                                               .toArray(String[]::new);
                MethodGen constructorGen = new MethodGen(constructorAccessFlags,
                                                         Type.VOID,
                                                         argTypes,
                                                         argNames,
                                                         "<init>",
                                                         classEntry.getKey(),
                                                         new InstructionList(),
                                                         classGen.getConstantPool());
                constructorGen.setMaxLocals();
                constructorGen.setMaxStack();
                classGen.addMethod(constructorGen.getMethod());
            }
            javaClassMap.put(classEntry.getKey(), classGen);
        }
        List<JavaClass> classes = new ArrayList<>();
        for (Map.Entry<String, ClassGen> entry : javaClassMap.entrySet()) {
            String className = entry.getKey();
            if (className.equals("IO") || className.equals("Object") || className.equals("String")) {
                continue;
            }
            ClassGen classGen = entry.getValue();
            List<Method> methods = new ArrayList<>();
            ConstantPoolGen constantPool = classGen.getConstantPool();
            for (Method method : classGen.getMethods()) {
                if (method.getName().equals("<init>")) {
                    continue;
                }
                BlockStatement body = classInfoMap.get(className).getMethods().get(method.getName()).getBody();
                MethodGen methodGen = new MethodGen(method, className, constantPool);
                InstructionList instructionList = new InstructionList();
                ByteCodeState state = ByteCodeState.builder()
                                                   .setConstantPoolGen(classGen.getConstantPool())
                                                   .setClassMap(javaClassMap)
                                                   .setInstructionList(instructionList)
                                                   .build();
                body.toBytecode(state);
                methodGen.setInstructionList(instructionList);
                methodGen.setMaxLocals();
                methodGen.setMaxStack();
                methods.add(methodGen.getMethod());
            }
            {
                ResolvedConstructor constructor = classInfoMap.get(className).getConstructor();
                int constructorAccessFlags = modifierSetToAccessFlags(constructor.getModifiers());
                Type[] argTypes = constructor.getArguments().stream()
                                             .map(rp -> resolvedTypeToBcelType(rp.getType()))
                                             .toArray(Type[]::new);
                String[] argNames = constructor.getArguments().stream()
                                               .map(ResolvedParam::getName)
                                               .toArray(String[]::new);
                InstructionList body = new InstructionList();
                ByteCodeState state = ByteCodeState.builder()
                                                   .setConstantPoolGen(classGen.getConstantPool())
                                                   .setClassMap(javaClassMap)
                                                   .setInstructionList(body)
                                                   .build();
                constructor.getBody().toBytecode(state);

                MethodGen constructorGen = new MethodGen(constructorAccessFlags,
                                                         Type.VOID,
                                                         argTypes,
                                                         argNames,
                                                         "<init>",
                                                         className,
                                                         body,
                                                         classGen.getConstantPool());
                constructorGen.setMaxLocals();
                constructorGen.setMaxStack();
                methods.add(constructorGen.getMethod());
            }
            classGen.setMethods(methods.toArray(new Method[methods.size()]));
            classes.add(classGen.getJavaClass());
        }

        String basePath = FileSystems.getDefault().getPath(filepath).getParent().toAbsolutePath().toString();
        System.out.println("Successfully compiled:");
        for (JavaClass jClass : classes) {
            File f = new File(basePath, URLEncoder.encode(jClass.getClassName(), UTF_8) +
                                      ".class");
            System.out.println(URLEncoder.encode(jClass.getClassName(), UTF_8) + ".class");

            jClass.dump(f);
        }
    }

    public static String classNameToBcelName(String className) {
        if (className.equals("Object")) {
            return "java.lang.Object";
        }
        if (className.equals("String")) {
            return "java.lang.String";
        }
        return className;
    }
}
