package ast;

import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.Optional;

@Value.Immutable
@ImmutableStyle
public interface IfStatementIF extends Statement {
    Expression getCondition();
    Statement getConsequence();
    Optional<Statement> getAltern();
}
