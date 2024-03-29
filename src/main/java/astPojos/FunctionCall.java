package astPojos;

import ast.Modifier;
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


    public FunctionCall(List<Expression> arguments, String methodName, Integer line, Integer column) {
        super(line, column);
        this.arguments = arguments;
        this.methodName = methodName;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        ResolvedMethod m = StaticChecksHelper.resolveMethod(this, s.getCurrentClass(), s);
        if (s.isMethodStatic() && !m.getModifiers().contains(Modifier.STATIC)) {
            this.throwCompilerError("Cannot reference virtual method " + methodName + " from static context.");
        }
        List<ResolvedType> argumentTypes = arguments.stream()
                                                    .map(e -> e.typeCheck(s))
                                                    .collect(Collectors.toList());
        List<ResolvedType> expectedArgumentTypes = m.getArguments().stream()
                                                    .map(ResolvedParam::getType)
                                                    .collect(Collectors.toList());
        StaticChecksHelper.checkPrivacy(m.getModifiers(),
                                        s.getCurrentClass(),
                                        fromClass,
                                        methodName,
                                        "method",
                                        s,
                                        this);
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
            new This(this.getLine(), this.getColumn()).toBytecode(state);
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

