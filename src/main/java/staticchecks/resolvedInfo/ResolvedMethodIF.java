package staticchecks.resolvedInfo;

import ast.Modifier;
import astPojos.BlockStatement;
import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.List;
import java.util.Set;

@Value.Immutable
@ImmutableStyle
public interface ResolvedMethodIF {
    ResolvedType getReturnType();
    List<ResolvedParam> getArguments();
    Set<Modifier> getModifiers();
    BlockStatement getBody();
}
