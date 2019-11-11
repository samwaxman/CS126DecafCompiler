package ast;

import org.immutables.value.Value;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;
import staticchecks.StaticState;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface IntegerLiteralIF extends Expression {
    int getInt();

    @Override
    default ResolvedType typeCheck(StaticState s) {
        return PrimitiveType.num;
    }
}
