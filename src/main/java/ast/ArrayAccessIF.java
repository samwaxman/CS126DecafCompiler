package ast;

import org.immutables.value.Value;
import staticchecks.*;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface ArrayAccessIF extends Expression {
    Expression getExpr();
    Expression getIndex();

    @Override
    default ResolvedType typeCheck(StaticState s) {
        ResolvedType arrayType = getExpr().typeCheck(s);
        ResolvedType indexType = getIndex().typeCheck(s);
        if (indexType != PrimitiveType.num) {
            throw new RuntimeException("Array index not a number.");
        }
        if (!(arrayType instanceof ArrayType)) {
            throw new RuntimeException("Attempted to perform an array access on a non-array.");
        }
        ArrayType arrT = (ArrayType) arrayType;
        if (arrT.getDimension() == 1) {
            return arrT.getType();
        } else {
            return arrT.withDimension(arrT.getDimension() - 1);
        }
    }
}
