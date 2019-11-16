package astPojos;

import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

public class IntegerLiteral extends Expression {
    private final int integer;

    public IntegerLiteral(int integer) {
        this.integer = integer;
    }

    public int getInteger() {
        return integer;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        return PrimitiveType.INT;
    }
}
