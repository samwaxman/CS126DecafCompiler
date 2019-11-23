package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.*;
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
        //TODO: Probably can't make a virtual function call from a static function.
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

    @Override
    public void toBytecode(ByteCodeState state) {
        assert fromClass != null : "should have typed checked by code generation time";
        Method method = null;
        for (Method m : state.getClassMap().get(fromClass).getMethods()) {
            if (m.getName().equals(methodName)) {
                method = m;
            }
        }
        assert method != null : "method should be found in the fromClass";
        if (!method.isStatic()) {
            state.append(new ALOAD(0));
        }
        for (Expression expression : arguments) {
            expression.toBytecode(state);
        }
        int poolLoc = state.getConstantPoolGen().addMethodref(fromClass,
                                                              method.getName(),
                                                              method.getSignature());
        if (method.isStatic()) {
            state.append(new INVOKESTATIC(poolLoc));
        } else {
            state.append(new INVOKEVIRTUAL(poolLoc));
        }
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

