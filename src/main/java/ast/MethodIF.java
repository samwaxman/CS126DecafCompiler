package ast;

import astPojos.BlockStatement;
import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.List;

@Value.Immutable
@ImmutableStyle
public interface MethodIF extends ASTNode {
    String getMethodName();
    List<Modifier> getModifiers();
    List<Param> getParams();
    BlockStatement getBody();
    Type getReturnType();
}
