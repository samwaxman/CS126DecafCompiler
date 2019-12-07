package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.ALOAD;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ClassType;
import staticchecks.resolvedInfo.ResolvedType;

public class This extends Expression {

    public This(Integer line, Integer column) {
        super(line, column);
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        state.append(new ALOAD(0));
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        if (s.isMethodStatic()) {
            this.throwCompilerError("Cannot use 'this' in a static context.");
        }
        return ClassType.builder().setClassName(s.getCurrentClass()).build();
    }
}
