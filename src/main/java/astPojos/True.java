package astPojos;

import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

public class True extends Expression {

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        return PrimitiveType.BOOLEAN;
    }
}
