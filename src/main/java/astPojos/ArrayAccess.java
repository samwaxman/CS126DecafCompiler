package astPojos;

import staticchecks.StaticState;
import staticchecks.resolvedInfo.ArrayType;
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

    public Expression getExpr() {
        return expr;
    }

    public Expression getIndex() {
        return index;
    }
}
