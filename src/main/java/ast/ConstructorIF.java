package ast;

import astPojos.BlockStatement;
import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.List;

@Value.Immutable
@ImmutableStyle
public interface ConstructorIF {
    List<Modifier> getModifiers();
    List<Param> getParams();
    BlockStatement getBody();
}
