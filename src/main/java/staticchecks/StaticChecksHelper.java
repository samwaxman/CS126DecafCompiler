package staticchecks;

import ast.*;
import staticchecks.resolvedInfo.*;

import java.util.*;
import java.util.stream.Collectors;

public class StaticChecksHelper {

    public static boolean isSubclass(ResolvedType sub, ResolvedType parent, StaticState s) {
        return false;
    }

    public static boolean isLValue(Expression e) {
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
                baseType = PrimitiveType.bool;
                break;
            case "int":
                baseType = PrimitiveType.num;
                break;
            case "void":
                baseType = PrimitiveType.voidT;
                break;
            case "char":
                baseType = PrimitiveType.character;
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
            if (baseType == PrimitiveType.voidT) {
                throw new RuntimeException("Arrays cannot have an element type of void.");
            }
            return ArrayType.builder().setType(baseType).setDimension(t.getArrayLevel()).build();
        }
        return baseType;
    }

    public static ResolvedMethod resolveMethod(String methodName, String className, StaticState s) {
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
            return resolvedMethod;
        }
        if (classInfo.getSuperClassName().isPresent()) {
            return resolveMethod(methodName, classInfo.getSuperClassName().get(), s);
        }
        throw new RuntimeException("Could not find method " + methodName);
    }

    public static ResolvedField resolveField(String fieldName, String className, StaticState s) {
        Optional<ResolvedField> field = optionallyResolveField(fieldName, className, s);
        if (field.isPresent()) {
            return field.get();
        }
        throw new RuntimeException("Could not find field " + fieldName);
    }

    public static Optional<ResolvedField> optionallyResolveField(String fieldName, String className, StaticState s) {
        ClassInfo classInfo = s.getClasses().get(className);
        //Probably impossible due to checks prior to this
        if (classInfo == null) {
            throw new RuntimeException("Could not find class " + className + ".");
        }
        //So it doesn't return the class constructor. We don't throw an error because
        //the superclass might have a method with the name of the subclass (Maybe? That's probably
        //actually overloading, so nvm, but no harm in doing this.)
        ResolvedField resolvedField = classInfo.getFields().get(fieldName);
        if (resolvedField != null) {
            return Optional.of(resolvedField);
        }
        if (classInfo.getSuperClassName().isPresent()) {
            return optionallyResolveField(fieldName, classInfo.getSuperClassName().get(), s);
        }
        return Optional.empty();
    }

    //An ugly method. You can do better. Either pull things out and make them more reusable
    //or do an overhaul whereby you don't need separate classes for the resolution. Possibly
    //an interface on the types and then make them mutable. Make typecheck mutate them to be resolved.
    public static Map<String, ClassInfo> buildClassInfo(Program p) {
        List<ClassASTNode> classes = p.getClasses();
        Map<String, ClassInfo> classInfoMap = new HashMap<>();
        classInfoMap.put("Object", ClassInfo.builder().build());
        for (ClassASTNode classNode : classes) {
            String superName = classNode.getSuper().isPresent() ? classNode.getSuper().get() : "Object";
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
                classInfo.getMethods().put(m.getMethodName(), resolvedMethod);
            }

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
                classInfo.getFields().put(f.getParam().getName(), resolvedField);
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
                resolvedConstructor = ResolvedConstructor.defaultConstructor;
            }
            toReturn.put(classNode.getClassName(), classInfo.withConstructor(resolvedConstructor));
        }
        return toReturn;
    }

}
