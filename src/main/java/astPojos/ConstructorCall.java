package astPojos;

import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ClassInfo;
import staticchecks.resolvedInfo.ClassType;
import staticchecks.resolvedInfo.ResolvedParam;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.List;
import java.util.stream.Collectors;

public class ConstructorCall extends Expression {
    private final String className;
    private final List<Expression> arguments;

    public ConstructorCall(String className, List<Expression> arguments) {
        this.className = className;
        this.arguments = arguments;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        ClassInfo clazz = s.getClasses().get(className);
        if (clazz == null) {
            throw new RuntimeException("Cannot call constructor for " + className + ". Unknown class.");
        }
        List<ResolvedType> argumentTypes = arguments.stream()
                                                         .map(e -> e.typeCheck(s))
                                                         .collect(Collectors.toList());
        List<ResolvedType> expectedArgumentTypes = clazz.getConstructor().getArguments().stream()
                                                        .map(ResolvedParam::getType)
                                                        .collect(Collectors.toList());
        StaticChecksHelper.checkIfValidArguments(argumentTypes, expectedArgumentTypes, s);
        return ClassType.builder().setClassName(className).build();
    }

   // @Override
    //public InstructionHandle toBytecode(ByteCodeState state) {
      //  return null;
    //}

    public String getClassName() {
        return className;
    }

    public List<Expression> getArguments() {
        return arguments;
    }
}
