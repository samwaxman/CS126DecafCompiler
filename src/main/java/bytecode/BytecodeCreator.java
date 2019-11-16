package bytecode;

import ast.Modifier;
import ast.Program;
import astPojos.BlockStatement;
import com.sun.org.apache.bcel.internal.Constants;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ArrayType;
import org.apache.bcel.generic.*;
import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.*;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
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

    private static Type resolvedTypeToBcelType(ResolvedType t) {
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

    public static void toBytecode(Program p) throws IOException {
        Map<String, ClassInfo> classInfoMap = StaticChecksHelper.buildClassInfo(p);
        for (Map.Entry<String, ClassInfo> classInfoEntry : classInfoMap.entrySet()) {
            for (ResolvedMethod resolvedMethod : classInfoEntry.getValue().getMethods().values()) {
                StaticState s = StaticState.builder()
                                           .setClasses(classInfoMap)
                                           .setReturnType(resolvedMethod.getReturnType())
                                           .setCurrentClass(classInfoEntry.getKey())
                                           .build();
                resolvedMethod.getBody().typeCheck(s);
            }
        }
        Map<String, ClassGen> javaClassMap = new HashMap<>();
        for (Map.Entry<String, ClassInfo> classEntry : classInfoMap.entrySet()) {
            // We'll use Java's Object
            if (classEntry.getKey().equals("Object") | classEntry.getKey().equals("String")) {
                continue;
            }
            String superName = classEntry.getValue().getSuperClassName();
            if (superName.equals("Object")) {
                superName = "java.lang.Object";
            }
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
                ResolvedConstructor constructor = classEntry.getValue().getConstructor();
                int constructorAccessFlags = modifierSetToAccessFlags(constructor.getModifiers());
                Type[] argTypes = constructor.getArguments().stream()
                                             .map(rp -> resolvedTypeToBcelType(rp.getType()))
                                             .toArray(Type[]::new);
                String[] argNames = constructor.getArguments().stream()
                                               .map(ResolvedParam::getName)
                                               .toArray(String[]::new);
                InstructionList body = new InstructionList();
                body.append(new RETURN());
                MethodGen constructorGen = new MethodGen(constructorAccessFlags,
                                                         Type.VOID,
                                                         argTypes,
                                                         argNames,
                                                         "<init>",
                                                         classEntry.getKey(),
                                                         body,
                                                         classGen.getConstantPool());
                // classGen.addMethod(constructorGen.getMethod());
            }
            javaClassMap.put(classEntry.getKey(), classGen);
        }
        List<JavaClass> classes = new ArrayList<>();
            for (Map.Entry<String, ClassGen> entry : javaClassMap.entrySet()) {
                if (entry.getKey().equals("IO")) {
                    continue;
                }
                String className = entry.getKey();
                ClassGen classGen = entry.getValue();
                List<Method> methods = new ArrayList<>();
                ConstantPoolGen constantPool = classGen.getConstantPool();
                for (Method method : classGen.getMethods()) {
                    BlockStatement body = classInfoMap.get(className).getMethods().get(method.getName()).getBody();
                    MethodGen methodGen = new MethodGen(method, className, constantPool);
                    InstructionList instructionList = new InstructionList();
                    body.toBytecode(javaClassMap, instructionList, constantPool);
                    methodGen.setInstructionList(instructionList);
                    methodGen.setMaxLocals();
                    methodGen.setMaxStack();
                    methods.add(methodGen.getMethod());
                }
                classGen.setMethods(methods.toArray(new Method[methods.size()]));
                classes.add(classGen.getJavaClass());
            }
            classes.add(IO().getJavaClass());
       // OutputStream o = new BufferedOutputStream(new FileOutputStream(f));
        for (JavaClass jClass : classes) {
            File f = new File("C:/Users/Sam/Documents/BrownCS/" +
                                      URLEncoder.encode(jClass.getClassName(), UTF_8) +
                                      ".class");

            jClass.dump(f);
            System.out.println(jClass);
        }
      //  o.flush();
        //o.close();
    }

    private static ClassGen IO() {
        ClassGen classGen = new ClassGen("IO", "java.lang.Object", null, Constants.ACC_PUBLIC, null);
        InstructionList body = new InstructionList();
        ConstantPoolGen constantPoolGen = classGen.getConstantPool();
        body.append(new GETSTATIC(constantPoolGen.addFieldref("java.lang.System", "out", "Ljava/io/PrintStream;")));
        body.append(new ALOAD(0));
        body.append(new INVOKEVIRTUAL(constantPoolGen.addMethodref("java.io.PrintStream", "print", "(Ljava/lang/String;)V")));
        body.append(new RETURN());

        MethodGen putStringGen = new MethodGen(Constants.ACC_PUBLIC | Constants.ACC_STATIC,
                                               Type.VOID,
                                               new Type[]{Type.STRING},
                                               new String[]{"x"},
                                               "putString",
                                               "IO",
                                               body,
                                               constantPoolGen);
        putStringGen.setMaxLocals();
        putStringGen.setMaxStack();
        classGen.addMethod(putStringGen.getMethod());
        classGen.addEmptyConstructor(Constants.ACC_PRIVATE);
        return classGen;
    }

}
