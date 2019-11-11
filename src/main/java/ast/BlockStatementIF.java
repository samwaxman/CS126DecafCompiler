package ast;

import java.util.List;

import org.immutables.value.Value;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;
import staticchecks.StaticState;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface BlockStatementIF extends Statement {
    List<Statement> getStatements();

    @Override
    default ResolvedType typeCheck(StaticState s) {
        for (Statement statement : getStatements()) {
            statement.typeCheck(s);
        }
        return PrimitiveType.voidT;
    }
}
