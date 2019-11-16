package astPojos;

import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ClassType;
import staticchecks.resolvedInfo.ResolvedMethod;
import staticchecks.resolvedInfo.ResolvedParam;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.List;
import java.util.stream.Collectors;

public class MethodCall extends Expression implements MethodResolvable {
    private final Expression object;
    private final String methodName;
    private final List<Expression> arguments;

    private String fromClass;

    public MethodCall(Expression object, String methodName, List<Expression> arguments) {
        this.object = object;
        this.methodName = methodName;
        this.arguments = arguments;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        //TODO: Does this include supers and statics? If so,
        //just check if object is an instance of a raw identifier,
        //then check it against "super" or the class names.
        ResolvedType objectType = object.typeCheckCore(s);
        if (!(objectType instanceof ClassType)) {
            throw new RuntimeException("Attempted to call a method on non-object type " + objectType);
        }
        ClassType classType = (ClassType) objectType;
        //TODO WARNING: Recall that when making the bytecode, you don't use this class name.
        //Method calls are determined at runtime.
        ResolvedMethod method = StaticChecksHelper.resolveMethod(this,
                                                                 classType.getClassName(),
                                                                 s);

        List<ResolvedType> argumentTypes = arguments.stream()
                                                    .map(a -> a.typeCheck(s))
                                                    .collect(Collectors.toList());
        List<ResolvedType> expectedTypes = method.getArguments().stream()
                                                 .map(ResolvedParam::getType)
                                                 .collect(Collectors.toList());
        StaticChecksHelper.checkIfValidArguments(argumentTypes, expectedTypes, s);
        return method.getReturnType();

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

    @Override
    public void setFromClass(String fromClass) {
        this.fromClass = fromClass;
    }
}
