package ast;

import org.immutables.value.Value;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface UnaryOpIF extends Expression {
    Expression getExpression();
    String getOperator();
}
