package astPojos;

import ast.Modifier;
import bytecode.ByteCodeState;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.INVOKESPECIAL;
import org.apache.bcel.generic.INVOKESTATIC;
import org.apache.bcel.generic.INVOKEVIRTUAL;
import org.apache.bcel.generic.POP;
import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MethodCall extends Expression implements MethodResolvable {
    private final Expression object;
    private final String methodName;
    private final List<Expression> arguments;

    private boolean isObjectClassname = false;
    private String fromClass;

    public MethodCall(Expression object,
                      String methodName,
                      List<Expression> arguments,
                      int line,
                      int column) {
        super(line, column);
        this.object = object;
        this.methodName = methodName;
        this.arguments = arguments;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        List<ResolvedType> argumentTypes = arguments.stream()
                                                    .map(a -> a.typeCheck(s))
                                                    .collect(Collectors.toList());
        if (object instanceof Identifier) {
            Identifier objectIdentifier = (Identifier) object;
            Optional<ResolvedType> objectType = objectIdentifier.typeCheckSoft(s);
            if (!objectType.isPresent()) {
                ClassInfo staticCallClass = s.getClasses().get(objectIdentifier.getIdentifier());
                if (staticCallClass != null) {
                    ResolvedMethod method = staticCallClass.getMethods().get(methodName);
                    if (method != null) {
                        if (method.getModifiers().contains(Modifier.STATIC)) {
                            fromClass = objectIdentifier.getIdentifier();
                            isObjectClassname = true;
                            List<ResolvedType> expectedTypes = method.getArguments().stream()
                                                                     .map(ResolvedParam::getType)
                                                                     .collect(Collectors.toList());
                            StaticChecksHelper.checkIfValidArguments(argumentTypes, expectedTypes, s);
                            StaticChecksHelper.checkPrivacy(method.getModifiers(),
                                                            s.getCurrentClass(),
                                                            fromClass,
                                                            methodName,
                                                            "method",
                                                            s,
                                                            this);
                            return method.getReturnType();
                        }
                        this.throwCompilerError("Cannot call non-static method " +
                                                        methodName +
                                                        " without a class instance.");
                    }
                    this.throwCompilerError("Could not find method " + methodName +
                                                    " in class " + objectIdentifier.getIdentifier());
                }
            }
        }
        ResolvedType objectType = object.typeCheck(s);
        if (!(objectType instanceof ClassType)) {
            this.throwCompilerError("Attempted to call a method on non-object type " + objectType);
        }
        ClassType classType = (ClassType) objectType;
        ResolvedMethod method = StaticChecksHelper.resolveMethod(this,
                                                                 classType.getClassName(),
                                                                 s);

        List<ResolvedType> expectedTypes = method.getArguments().stream()
                                                 .map(ResolvedParam::getType)
                                                 .collect(Collectors.toList());
        StaticChecksHelper.checkIfValidArguments(argumentTypes, expectedTypes, s);
        StaticChecksHelper.checkPrivacy(method.getModifiers(),
                                        s.getCurrentClass(),
                                        fromClass,
                                        methodName,
                                        "method",
                                        s,
                                        this);
        return method.getReturnType();

    }

    @Override
    public void toBytecode(ByteCodeState state) {
        assert fromClass != null : "should have typed checked by code generation time";
        if (!isObjectClassname) {
            object.toBytecode(state);
        }
        Method method = null;
        for (Method m : state.getClassMap().get(fromClass).getMethods()) {
            if (m.getName().equals(methodName)) {
                method = m;
            }
        }
        assert method != null : "method should be found in the fromClass";
        if (method.isStatic() && !isObjectClassname) {
            // It's static but was called with an unneeded object instance.
            // Pop the unneeded instance off the stack.
            state.append(new POP());
        }
        for (Expression expression : arguments) {
            expression.toBytecode(state);
        }

        int poolLoc = state.getConstantPoolGen().addMethodref(fromClass, method.getName(), method.getSignature());
        if (method.isStatic()) {
            state.append(new INVOKESTATIC(poolLoc));
        } else if (object instanceof Super) {
            state.append(new INVOKESPECIAL(poolLoc));
        } else {
            state.append(new INVOKEVIRTUAL(poolLoc));
        }
    }

    public Expression getObject() {
        return object;
    }

    public String getMethodName() {
        return methodName;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public String getFromClass() {
        return fromClass;
    }

    public boolean isObjectClassname() {
        return isObjectClassname;
    }

    @Override
    public void setFromClass(String fromClass) {
        this.fromClass = fromClass;
    }
}
