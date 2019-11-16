package astPojos;

import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ResolvedMethod;
import staticchecks.resolvedInfo.ResolvedParam;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionCall extends Expression implements MethodResolvable {
    private final List<Expression> arguments;
    private final String methodName;

    private String fromClass;


    public FunctionCall(List<Expression> arguments, String methodName) {
        this.arguments = arguments;
        this.methodName = methodName;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        ResolvedMethod m = StaticChecksHelper.resolveMethod(this, s.getCurrentClass(), s);
        List<ResolvedType> argumentTypes = arguments.stream()
                                                    .map(e -> e.typeCheck(s))
                                                    .collect(Collectors.toList());
        List<ResolvedType> expectedArgumentTypes = m.getArguments().stream()
                                                    .map(ResolvedParam::getType)
                                                    .collect(Collectors.toList());

        StaticChecksHelper.checkIfValidArguments(argumentTypes, expectedArgumentTypes, s);
        return m.getReturnType();
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getFromClass() {
        return fromClass;
    }

    public void setFromClass(String fromClass) {
        this.fromClass = fromClass;
    }
}

