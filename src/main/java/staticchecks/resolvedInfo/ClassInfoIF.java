package staticchecks.resolvedInfo;

import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.Map;

@Value.Immutable
@ImmutableStyle
public interface ClassInfoIF {
    Map<String, ResolvedField> getFields();
    Map<String, ResolvedMethod> getMethods();
    String getSuperClassName();
    ResolvedConstructor getConstructor();
}
