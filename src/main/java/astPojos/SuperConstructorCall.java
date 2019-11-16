package astPojos;

import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ClassInfo;
import staticchecks.resolvedInfo.ResolvedParam;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.List;
import java.util.stream.Collectors;

public class SuperConstructorCall extends Statement {
    private final List<Expression> arguments;
    private String superClassName;

    public SuperConstructorCall(List<Expression> arguments) {
        this.arguments = arguments;
    }

    @Override
    public void typeCheck(StaticState s) {
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

    public List<Expression> getArguments() {
        return arguments;
    }

    public String getSuperClassName() {
        return superClassName;
    }
}
