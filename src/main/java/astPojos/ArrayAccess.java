package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.*;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ArrayType;
import staticchecks.resolvedInfo.ClassType;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

public class ArrayAccess extends Expression {
    private final Expression expr;
    private final Expression index;

    public ArrayAccess(Expression expr, Expression index) {
        this.expr = expr;
        this.index = index;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        ResolvedType arrayType = expr.typeCheck(s);
        ResolvedType indexType = index.typeCheck(s);
        if (indexType != PrimitiveType.INT) {
            throw new RuntimeException("Array index not a number.");
        }
        if (!(arrayType instanceof ArrayType)) {
            throw new RuntimeException("Attempted to perform an array access on a non-array.");
        }
        ResolvedType type;
        ArrayType arrT = (ArrayType) arrayType;
        if (arrT.getDimension() == 1) {
            return arrT.getType();
        } else {
            return arrT.withDimension(arrT.getDimension() - 1);
        }
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        expr.toBytecode(state);
        index.toBytecode(state);
        ResolvedType t = expr.getType();
        assert t instanceof ArrayType;
        ArrayType arrayType = (ArrayType) t;
        if (arrayType.getDimension() > 1 || arrayType.getType() instanceof ClassType) {
            state.append(new AALOAD());
            return;
        }

        ResolvedType baseType = arrayType.getType();
        if (baseType == PrimitiveType.BOOLEAN) {
            state.append(new BALOAD());
        } else if (baseType == PrimitiveType.CHAR) {
            state.append(new CALOAD());
        } else if (baseType == PrimitiveType.INT) {
            state.append(new IALOAD());
        } else {
            assert false : "Base type was not a non-void primitive or a class type.";
        }
    }

    public Expression getExpr() {
        return expr;
    }

    public Expression getIndex() {
        return index;
    }
}
