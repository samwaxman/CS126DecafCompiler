package ast;

import org.immutables.value.Value;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;
import staticchecks.StaticState;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface FalseIF extends Expression {

    @Override
    default ResolvedType typeCheck(StaticState s) {
        return PrimitiveType.bool;
    }
}
