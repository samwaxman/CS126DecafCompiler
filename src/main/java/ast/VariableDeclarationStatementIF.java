package ast;

import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.Optional;

@Value.Immutable
@ImmutableStyle
public interface VariableDeclarationStatementIF extends Statement {
    Param getVar();
    Optional<Expression> getInitialVal();
}
