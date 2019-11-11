package staticchecks.resolvedInfo;

import ast.Constructor;
import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.Map;
import java.util.Optional;

@Value.Immutable
@ImmutableStyle
public interface ClassInfoIF {
    Map<String, ResolvedField> getFields();
    Map<String, ResolvedMethod> getMethods();
    Optional<String> getSuperClassName();
    ResolvedConstructor getConstructor();
}
