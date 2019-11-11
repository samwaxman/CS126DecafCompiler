package ast;

import org.immutables.value.Value;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface WhileStatementIF extends Statement{
    Expression getTestExpression();
    Statement getBody();
}
