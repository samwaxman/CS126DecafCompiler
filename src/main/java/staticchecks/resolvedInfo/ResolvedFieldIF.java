package staticchecks.resolvedInfo;

import ast.Modifier;
import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.Set;

@Value.Immutable
@ImmutableStyle
public interface ResolvedFieldIF {
    ResolvedType getType();
    Set<Modifier> getModifiers();
}
