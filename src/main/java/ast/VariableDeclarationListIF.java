package ast;

import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.List;

@Value.Immutable
@ImmutableStyle
//Can't throw em in a block because that'd limit scope
//and need them grouped together as a Statement so we can return
//from visiting a variable declaration list with multiple bindings
public interface VariableDeclarationListIF extends Statement {
    List<VariableDeclarationStatement> getDeclarations();
}
