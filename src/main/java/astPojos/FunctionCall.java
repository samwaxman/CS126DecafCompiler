package astPojos;

import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.*;
import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ResolvedMethod;
import staticchecks.resolvedInfo.ResolvedParam;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.List;
import java.util.Map;
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

    @Override
    public InstructionHandle toBytecode(Map<String, ClassGen> javaClassMap,
                                        InstructionList il,
                                        ConstantPoolGen cp) {
        int oldLength = il.getLength();
        assert fromClass != null : "should have typed checked by code generation time";
        Method method = null;
        for (Method m : javaClassMap.get(fromClass).getMethods()) {
            if (m.getName().equals(methodName)) {
                method = m;
            }
        }
        assert method != null : "method should be found in the fromClass";
        if (!method.isStatic()) {
            il.append(new ALOAD(0));
        }
        for (Expression expression : arguments) {
            expression.toBytecode(javaClassMap, il, cp);
        }
        int poolLoc = cp.addMethodref(fromClass, method.getName(), method.getSignature());
        if (method.isStatic()) {
            il.append(new INVOKESTATIC(poolLoc));
        } else {
            il.append(new INVOKEVIRTUAL(poolLoc));
        }
        return il.getInstructionHandles()[oldLength];
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

