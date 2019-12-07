package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.*;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

public class True extends Expression {

    public True(Integer line, Integer column) {
        super(line, column);
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        return PrimitiveType.BOOLEAN;
    }

    @Override
    public void toBytecode(ByteCodeState state) { state.append(new ICONST(1)); }
}
