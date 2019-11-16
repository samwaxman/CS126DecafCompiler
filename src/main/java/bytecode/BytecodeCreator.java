package bytecode;

import ast.Modifier;
import ast.Program;
import com.sun.org.apache.bcel.internal.Constants;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.generic.ArrayType;
import org.apache.bcel.generic.*;
import staticchecks.StaticChecksHelper;
import staticchecks.resolvedInfo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        if (t == PrimitiveType.voidT) {
            return Type.VOID;
        }
        if (t == PrimitiveType.num) {
            return Type.INT;
        }
        if (t == PrimitiveType.bool) {
            return Type.BOOLEAN;
        }
        if (t == PrimitiveType.character) {
            return Type.CHAR;
        }
        if (t instanceof ClassType) {
            ClassType classType = (ClassType) t;
            if (classType.getClassName().equals("Object")) {
                return Type.OBJECT;
            }
            return new ObjectType(classType.getClassName());
        }
        assert (t instanceof staticchecks.resolvedInfo.ArrayType) : "Was not a class type or a primitive type";
        staticchecks.resolvedInfo.ArrayType arrayType = (staticchecks.resolvedInfo.ArrayType) t;
        return new ArrayType(resolvedTypeToBcelType(arrayType.getType()), arrayType.getDimension());
    }

    public static void toBytecode(Program p) {
        Map<String, ClassInfo> classInfoMap = StaticChecksHelper.buildClassInfo(p);
        List<JavaClass> classes = new ArrayList<>();
        for (Map.Entry<String, ClassInfo> classEntry : classInfoMap.entrySet()) {
            // We'll use Java's Object
            if (classEntry.getKey().equals("Object")) {
                continue;
            }
            String superName = classEntry.getValue().getSuperClassName().get();
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
                classGen.addMethod(methodGen.getMethod());
            }

            ResolvedConstructor constructor = classEntry.getValue().getConstructor();
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
            classGen.addMethod(constructorGen.getMethod());
            classes.add(classGen.getJavaClass());
        }
        //classes.get(0);
    }
}
