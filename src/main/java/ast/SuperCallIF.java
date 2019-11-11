package ast;

import java.util.List;
import org.immutables.value.Value;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface SuperCallIF extends Statement {
    List<Expression> getArgs();
}
