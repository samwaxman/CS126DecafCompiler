package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.ALOAD;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ClassType;
import staticchecks.resolvedInfo.ResolvedType;

public class This extends Expression {
    @Override
    public void toBytecode(ByteCodeState state) {
        state.append(new ALOAD(0));
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        if (s.isMethodStatic()) {
            throw new RuntimeException("Cannot use 'this' in a static context.");
        }
        return ClassType.builder().setClassName(s.getCurrentClass()).build();
    }
}
