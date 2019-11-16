package astPojos;

import org.apache.bcel.generic.*;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.Map;

public class IntegerLiteral extends LiteralExpression {
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

    @Override
    public InstructionHandle toBytecode(Map<String, ClassGen> javaClassMap, InstructionList il, ConstantPoolGen cp) {
        return il.append(new LDC(cp.addInteger(integer)));
    }
}
