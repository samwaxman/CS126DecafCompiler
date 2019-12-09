package staticchecks;

import ast.*;
import astPojos.ASTNode;
import astPojos.BlockStatement;
import astPojos.FieldResolvable;
import astPojos.MethodResolvable;
import com.google.common.collect.Lists;
import staticchecks.resolvedInfo.*;

import java.util.*;
import java.util.stream.Collectors;

public class StaticChecksHelper {

    public static boolean isSubclass(ResolvedType sub, ResolvedType parent, StaticState s) {
        if (sub.equals(parent)) {
            return true;
        }
        if ((sub == PrimitiveType.CHAR && parent == PrimitiveType.INT) ||
                (sub == PrimitiveType.INT && parent == PrimitiveType.CHAR)) {
            return true;
        }
        if (!sub.isRef()) {
            return false;
        }
        if (sub instanceof NullType || parent instanceof NullType) {
            return true;
        }
        if (sub instanceof ArrayType) {
            if (parent instanceof ArrayType) {
                ArrayType subType = (ArrayType) sub;
                ArrayType parType = (ArrayType) parent;
                return subType.getDimension() == parType.getDimension() &&
                        isSubclass(subType.getType(), parType.getType(), s);
            }
            return false;
        }

        assert sub instanceof ClassType;
        if (!(parent instanceof ClassType)) {
            return false;
        }
        ClassType subType = (ClassType) sub;
        ClassType parType = (ClassType) parent;
        String superName = subType.getClassName();
        //An ugly side effect of marking that as non-null. Maybe go revise
        while (!superName.equals("")) {
            superName = s.getClasses().get(superName).getSuperClassName();
            if (superName.equals(parType.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public static void checkIfValidArguments(List<ResolvedType> argumentTypes,
                                             List<ResolvedType> expectedArgumentTypes,
                                             StaticState s) {
        if (argumentTypes.size() != expectedArgumentTypes.size()) {
            throw new RuntimeException("Expected " + expectedArgumentTypes.size() +
                                               " arguments but received " + argumentTypes.size() + ".");
        }
        for (int i = 0; i < argumentTypes.size(); i++) {
            if (!isSubclass(argumentTypes.get(i), expectedArgumentTypes.get(i), s)) {
                throw new RuntimeException("Invalid type for argument " + i +
                                                   ". Expected " + expectedArgumentTypes.get(i) +
                                                   " but got " + argumentTypes.get(i) + ".");
            }
        }
    }

    public static ResolvedType resolveType(Type t, StaticState s) {
        ResolvedType baseType = null;
        switch (t.getTypeIdentifier()) {
            case "boolean":
                baseType = PrimitiveType.BOOLEAN;
                break;
            case "int":
                baseType = PrimitiveType.INT;
                break;
            case "void":
                baseType = PrimitiveType.VOID;
                break;
            case "char":
                baseType = PrimitiveType.CHAR;
                break;
            default:
        }
        if (baseType == null) {
            if (s.getClasses().get(t.getTypeIdentifier()) == null) {
                throw new RuntimeException("Unknown type: " + t.getTypeIdentifier());
            }
            baseType = ClassType.builder().setClassName(t.getTypeIdentifier()).build();
        }
        if (t.getArrayLevel() != 0) {
            if (baseType == PrimitiveType.VOID) {
                throw new RuntimeException("Arrays cannot have an element type of void.");
            }
            return ArrayType.builder().setType(baseType).setDimension(t.getArrayLevel()).build();
        }
        return baseType;
    }

    public static ResolvedMethod resolveMethod(MethodResolvable methodResolvable,
                                               String className,
                                               StaticState s) {
        String methodName = methodResolvable.getMethodName();
        //TODO: Object should be a constant string somewhere (not for performance,
        //it'll get interned anyway -- just for clean revision and centrality)
        if (className.equals("Object")) {
            throw new RuntimeException("Could not find method " + methodName);
        }
        ClassInfo classInfo = s.getClasses().get(className);
        //Probably impossible due to checks prior to this
        if (classInfo == null) {
            throw new RuntimeException("Could not find class " + className + ".");
        }
        //So it doesn't return the class constructor. We don't throw an error because
        //the superclass might have a method with the name of the subclass (Maybe? That's probably
        //actually overloading, so nvm, but no harm in doing this.)
        ResolvedMethod resolvedMethod = classInfo.getMethods().get(methodName);
        if (resolvedMethod != null) {
            methodResolvable.setFromClass(className);
            return resolvedMethod;
        }
        return resolveMethod(methodResolvable, classInfo.getSuperClassName(), s);

    }

    public static ResolvedField resolveField(FieldResolvable fieldResolvable, String className, StaticState s) {
        Optional<ResolvedField> field = optionallyResolveField(fieldResolvable, className, s);
        if (field.isPresent()) {
            return field.get();
        }
        throw new RuntimeException("Could not find field " + fieldResolvable.getFieldName());
    }

    public static Optional<ResolvedField> optionallyResolveField(FieldResolvable fieldResolvable,
                                                                 String className,
                                                                 StaticState s) {
        String fieldName = fieldResolvable.getFieldName();
        if (className.equals("Object")) {
            return Optional.empty();
        }
        ClassInfo classInfo = s.getClasses().get(className);
        //Probably impossible due to checks prior to this
        if (classInfo == null) {
            throw new RuntimeException("Could not find class " + className + ".");
        }

        ResolvedField resolvedField = classInfo.getFields().get(fieldName);
        if (resolvedField != null) {
            fieldResolvable.setFromClass(className);
            return Optional.of(resolvedField);
        }
        return optionallyResolveField(fieldResolvable, classInfo.getSuperClassName(), s);
    }

    private static void checkOverrideValid(ClassInfo sub, Map<String, ClassInfo> classInfoMap) {
        for (Map.Entry<String, ResolvedMethod> methodEntry : sub.getMethods().entrySet()) {
            String methodName = methodEntry.getKey();
            ResolvedMethod method = methodEntry.getValue();
            ClassInfo parent = classInfoMap.get(sub.getSuperClassName());
            String currentClassname = sub.getSuperClassName();
            while (parent != null) {
                ResolvedMethod overriding = parent.getMethods().get(methodName);
                parent = classInfoMap.get(parent.getSuperClassName());
                if (overriding == null) {
                    currentClassname = parent.getSuperClassName();
                    continue;
                }

                if (overriding.getArguments().size() != method.getArguments().size()) {
                    throw new RuntimeException("Method " + methodName + " has different number " +
                                                       " of arguments as its overridden method in class " + currentClassname);
                }

                for (int i = 0; i < overriding.getArguments().size(); i++) {
                    if (overriding.getArguments().get(i) != method.getArguments().get(i)) {
                        throw new RuntimeException("Argument " + i + " in method " + methodName +
                                                           " differs in type from its overridden method in class " + currentClassname);
                    }
                }

                if (overriding.getReturnType() != method.getReturnType()) {
                    throw new RuntimeException("Return type of method " + methodName + " differs from " +
                                                       " the return type of its overriding method in class " + currentClassname);
                }

                boolean isMethodStatic = method.getModifiers().contains(Modifier.STATIC);
                boolean isOverriddenStatic = overriding.getModifiers().contains(Modifier.STATIC);
                if (isMethodStatic != isOverriddenStatic) {
                    throw new RuntimeException("Method " + methodName + "is " +
                                                       (isMethodStatic ? "" : "not ") +
                                                       "static but its overridden method in class " +
                                                       currentClassname + " is " +
                                                       (isOverriddenStatic ? "." : "not."));
                }
                currentClassname = parent.getSuperClassName();
            }
        }
    }

    //An ugly method. You can do better. Either pull things out and make them more reusable
    //or do an overhaul whereby you don't need separate classes for the resolution. Possibly
    //an interface on the types and then make them mutable. Make typecheck mutate them to be resolved.
    public static Map<String, ClassInfo> buildClassInfo(Program p) {
        List<ClassASTNode> classes = p.getClasses();
        Map<String, ClassInfo> classInfoMap = new HashMap<>();
        ClassInfo objectInfo = ClassInfo.builder().setSuperClassName("")
                                        .setConstructor(ResolvedConstructorIF.defaultConstructor())
                                        .build();
        classInfoMap.put("Object", objectInfo);
        ClassInfo stringInfo = ClassInfo.builder()
                                        .setSuperClassName("Object")
                                        .setConstructor(ResolvedConstructorIF.defaultConstructor())
                                        .build();
        classInfoMap.put("String", stringInfo);
        ResolvedMethod putString = ResolvedMethod.builder()
                                                 .setReturnType(PrimitiveType.VOID)
                                                 .setArguments(Lists.newArrayList(
                                                         ResolvedParam.builder()
                                                                      .setName("x")
                                                                      .setType(ClassType.builder()
                                                                                        .setClassName("String")
                                                                                        .build())
                                                                      .build()))
                                                 .setBody(new BlockStatement(Collections.emptyList(), null, null))
                                                 .setModifiers(new HashSet<>(Arrays.asList(Modifier.STATIC, Modifier.PUBLIC)))
                                                 .build();
        ResolvedMethod putChar = putString.withArguments(putString.getArguments().get(0)
                                                                  .withType(PrimitiveType.CHAR));

        ResolvedMethod putInt = putString.withArguments(putString.getArguments().get(0)
                                                                 .withType(PrimitiveType.INT));
        ResolvedMethod getChar = putInt.withArguments(Collections.emptyList())
                                       .withReturnType(PrimitiveType.INT);
        ResolvedMethod getInt = getChar;
        ResolvedMethod peek = getChar;
        ResolvedMethod getLine = getChar.withReturnType(ClassType.builder().setClassName("String").build());

        ClassInfo ioInfo = ClassInfo.builder()
                                    .setSuperClassName("Object")
                                    .putMethods("putString", putString)
                                    .putMethods("putChar", putChar)
                                    .putMethods("putInt", putInt)
                                    .putMethods("getInt", getInt)
                                    .putMethods("peek", peek)
                                    .putMethods("getLine", getLine)
                                    .putMethods("getChar", getChar)
                                    .setConstructor(ResolvedConstructorIF.defaultConstructor()
                                                            .withModifiers(new HashSet<>(Collections.singleton(Modifier.PRIVATE))))
                                    .build();
        classInfoMap.put("IO", ioInfo);
        for (ClassASTNode classNode : classes) {
            String superName = classNode.getSuper().isPresent() ? classNode.getSuper().get() : "Object";
            if (classInfoMap.get(superName) == null) {
                throw new RuntimeException("Class " + superName + " has not been declared. Note, to extend " +
                                                   "a class, the class must have already been declared above and cannot come later.");
            }
            classInfoMap.put(classNode.getClassName(), ClassInfo.builder().setSuperClassName(superName).build());
        }
        StaticState state = StaticState.builder().setClasses(classInfoMap).build();
        Set<Modifier> accessModifiers = new HashSet<>();
        accessModifiers.add(Modifier.PRIVATE);
        accessModifiers.add(Modifier.PUBLIC);
        accessModifiers.add(Modifier.PROTECTED);
        //So we're not modifying a map as we walk across it
        Map<String, ClassInfo> toReturn = new HashMap<>();
        for (ClassASTNode classNode : classes) {
            ClassInfo classInfo = classInfoMap.get(classNode.getClassName());
            HashMap<String, ResolvedMethod> methods = new HashMap<>();
            for (Method m : classNode.getMethods()) {
                ResolvedType returnType = resolveType(m.getReturnType(), state);
                List<ResolvedParam> resolvedParams = m.getParams().stream()
                                                      .map(param -> ResolvedParam.builder()
                                                                                 .setName(param.getName())
                                                                                 .setType(resolveType(param.getType(), state))
                                                                                 .build())
                                                      .collect(Collectors.toList());
                if (classInfo.getMethods().get(m.getMethodName()) != null) {
                    throw new RuntimeException("Duplicate method name " + m.getMethodName() +
                                                       " in class " + classNode.getClassName() +
                                                       ". Decaf does not allow method overloading.");
                }
                Set<Modifier> modifierSet = new HashSet<>();
                for (Modifier modifier : m.getModifiers()) {
                    if (accessModifiers.contains(modifier)) {
                        for (Modifier accessModifier : accessModifiers) {
                            if (modifierSet.contains(accessModifier)) {
                                throw new RuntimeException("Only one access modifier may be used on a method." +
                                                                   "Found " + accessModifier + " and " + modifier + " on " + m.getMethodName());
                            }
                        }
                    }
                    modifierSet.add(modifier);
                }
                if (!accessModifiers.stream().map(modifierSet::contains)
                                    .reduce(false, (b1, b2) -> b1 || b2)) {
                    modifierSet.add(Modifier.PUBLIC);
                }
                ResolvedMethod resolvedMethod = ResolvedMethod.builder()
                                                              .setBody(m.getBody())
                                                              .setReturnType(returnType)
                                                              .setArguments(resolvedParams)
                                                              .setModifiers(modifierSet)
                                                              .build();
                methods.put(m.getMethodName(), resolvedMethod);
            }

            Map<String, ResolvedField> fields = new HashMap<>();
            for (Field f : classNode.getFields()) {
                if (classInfo.getFields().get(f.getParam().getName()) != null) {
                    throw new RuntimeException("Duplicate field " + f.getParam().getName()
                                                       + " in class " + classNode.getClassName() + ".");
                }
                Set<Modifier> modifierSet = new HashSet<>();
                for (Modifier modifier : f.getModifiers()) {
                    if (modifier == Modifier.STATIC) {
                        throw new RuntimeException("Field " + f.getParam().getName()
                                                           + ": Fields cannot be marked as static.");
                    }
                    for (Modifier accessModifier : accessModifiers) {
                        if (modifierSet.contains(accessModifier)) {
                            throw new RuntimeException("Only one access modifier may be used on a field." +
                                                               "Found " + accessModifier + " and " + modifier + " on " + f.getParam().getName());
                        }
                    }
                    modifierSet.add(modifier);
                }
                if (modifierSet.isEmpty()) {
                    modifierSet.add(Modifier.PUBLIC);
                }
                ResolvedField resolvedField = ResolvedField.builder()
                                                           .setType(resolveType(f.getParam().getType(), state))
                                                           .setModifiers(modifierSet)
                                                           .build();

                fields.put(f.getParam().getName(), resolvedField);
            }
            Optional<Constructor> constructor = classNode.getConstructor();
            ResolvedConstructor resolvedConstructor;
            if (constructor.isPresent()) {
                List<ResolvedParam> resolvedParams =
                        constructor.get().getParams().stream()
                                   .map(param -> ResolvedParam.builder()
                                                              .setType(resolveType(param.getType(), state))
                                                              .setName(param.getName())
                                                              .build())
                                   .collect(Collectors.toList());
                Set<Modifier> modifierSet = new HashSet<>();
                for (Modifier modifier : constructor.get().getModifiers()) {
                    if (accessModifiers.contains(modifier)) {
                        for (Modifier accessModifier : accessModifiers) {
                            if (modifierSet.contains(accessModifier)) {
                                throw new RuntimeException("Only one access modifier may be used on a method." +
                                                                   "Found " + accessModifier + " and " + modifier + " on class constructor.");
                            }
                        }
                    }
                    modifierSet.add(modifier);
                }
                if (!accessModifiers.stream().map(modifierSet::contains)
                                    .reduce(false, (b1, b2) -> b1 || b2)) {
                    modifierSet.add(Modifier.PUBLIC);
                }
                resolvedConstructor = ResolvedConstructor.builder()
                                                         .setBody(constructor.get().getBody())
                                                         .setArguments(resolvedParams)
                                                         .setModifiers(modifierSet)
                                                         .build();
            } else {
                resolvedConstructor = ResolvedConstructorIF.defaultConstructor();
            }
            String superName = classInfoMap.get(classNode.getClassName()).getSuperClassName();
            ClassInfo info = ClassInfo.builder()
                                      .setFields(fields)
                                      .setMethods(methods)
                                      .setConstructor(resolvedConstructor)
                                      .setSuperClassName(superName)
                                      .build();
            toReturn.put(classNode.getClassName(), info);
        }
        toReturn.put("String", stringInfo);
        toReturn.put("Object", objectInfo);
        toReturn.put("IO", ioInfo);
        return toReturn;
    }

    public static void checkPrivacy(Set<Modifier> modifiers,
                                    String subName,
                                    String parentName,
                                    String fieldOrMethodName,
                                    String toCheck,
                                    StaticState s,
                                    ASTNode node) {

        if (modifiers.contains(Modifier.PRIVATE) && !s.getCurrentClass().equals(parentName)) {
            node.throwCompilerError("Cannot access private " + toCheck +  " " + fieldOrMethodName + " of class " + parentName
                                            + " from class " + subName);
        }
        ResolvedType currentType = ClassType.builder().setClassName(subName).build();
        ResolvedType parentType = ClassType.builder().setClassName(parentName).build();
        if (modifiers.contains(Modifier.PROTECTED) &&
                !StaticChecksHelper.isSubclass(currentType, parentType, s)) {
            node.throwCompilerError("Cannot access protected " + toCheck + " " + fieldOrMethodName + " of class " + parentName +
                                            ". Class " + subName + " does not extend " + parentName + ".");
        }
    }
}
