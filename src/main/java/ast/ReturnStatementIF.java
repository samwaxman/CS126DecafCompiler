package ast;

import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.Optional;

@Value.Immutable
@ImmutableStyle
public interface ReturnStatementIF extends Statement {
    Optional<Expression> getReturnExpression();
}
