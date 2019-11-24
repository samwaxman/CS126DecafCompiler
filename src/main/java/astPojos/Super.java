package astPojos;


import bytecode.ByteCodeState;
import org.apache.bcel.generic.ALOAD;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ClassType;
import staticchecks.resolvedInfo.ResolvedType;

public class Super extends Expression {
    @Override
    public void toBytecode(ByteCodeState state) {
        state.append(new ALOAD(0));
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        if (s.isMethodStatic()) {
            throw new RuntimeException("Cannot use 'super' in a static context.");
        }
        String superName = s.getClasses().get(s.getCurrentClass()).getSuperClassName();
        return ClassType.builder().setClassName(superName).build();
    }
}
