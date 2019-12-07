package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.*;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

public class IntegerLiteral extends Expression {
    private final int integer;

    public IntegerLiteral(int integer, int line, int column) {
        super(line, column);
        this.integer = integer;
    }

    public int getInteger() {
        return integer;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        return PrimitiveType.INT;
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        state.append(new LDC(state.getConstantPoolGen().addInteger(integer)));
    }
}
