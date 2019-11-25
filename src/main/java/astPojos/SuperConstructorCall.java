package astPojos;

import bytecode.ByteCodeState;
import bytecode.BytecodeCreator;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ALOAD;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.INVOKESPECIAL;
import org.apache.bcel.generic.Type;
import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ClassInfo;
import staticchecks.resolvedInfo.ResolvedParam;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.List;
import java.util.stream.Collectors;

public class SuperConstructorCall extends Statement {
    private final List<Expression> arguments;
    private String superClassName = null;

    public SuperConstructorCall(List<Expression> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void typeCheck(StaticState s) {
        assert superClassName == null;
        if (!s.isFirstStatementInConstructorCall()) {
            throw new RuntimeException("Super constructor calls are only allowed " +
                                               "as the first statement in a constructor.");
        }
        List<ResolvedType> argumentTypes = arguments.stream()
                                                    .map(a -> a.typeCheck(s))
                                                    .collect(Collectors.toList());
        ClassInfo info = s.getClasses().get(s.getCurrentClass());
        assert info != null : "Current class should be registered.";
        ClassInfo superInfo = s.getClasses().get(info.getSuperClassName());
        superClassName = info.getSuperClassName();
        assert superInfo != null : "Super should be registered.";
        List<ResolvedType> expectedTypes = superInfo.getConstructor().getArguments().stream()
                 .map(ResolvedParam::getType)
                 .collect(Collectors.toList());

        StaticChecksHelper.checkIfValidArguments(argumentTypes, expectedTypes, s);

    }

    @Override
    public void toBytecode(ByteCodeState state) {
        ClassGen classGen = state.getClassMap().get(superClassName);
        String methodSignature = null;
        //Unlike in real java, there's only one init
        for (Method m : classGen.getMethods()) {
            if (m.getName().equals("<init>")) {
                methodSignature = Type.getMethodSignature(m.getReturnType(), m.getArgumentTypes());
                break;
            }
        }
        assert methodSignature != null;
        Integer initIndex = state.getConstantPoolGen().addMethodref(BytecodeCreator.classNameToBcelName(superClassName),
                                                                       "<init>",
                                                                       methodSignature);
        state.append(new ALOAD(0));
        for (Expression a : arguments) {
            a.toBytecode(state);
        }
        state.append(new INVOKESPECIAL(initIndex));
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public String getSuperClassName() {
        return superClassName;
    }
}
