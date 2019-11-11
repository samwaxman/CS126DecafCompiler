package ast;

import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.List;

@Value.Immutable
@ImmutableStyle
public interface MethodCallIF extends Expression {
    Expression getObject();
    String getMethodName();
    List<Expression> getArguments();
}
