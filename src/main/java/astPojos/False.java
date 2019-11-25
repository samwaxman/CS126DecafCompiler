package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.*;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

public class False extends Expression {

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        return PrimitiveType.BOOLEAN;
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        state.append(new ICONST(0));
    }
}

