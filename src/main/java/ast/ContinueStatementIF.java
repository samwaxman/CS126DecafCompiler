package ast;

import org.immutables.value.Value;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;
import staticchecks.StaticState;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface ContinueStatementIF extends Statement {
    @Override
    default ResolvedType typeCheck(StaticState s) {
        if (!s.isInsideBreakableStatement()) {
            throw new RuntimeException("Continue used outside of while loop.");
        }
        return PrimitiveType.voidT;
    }
}
