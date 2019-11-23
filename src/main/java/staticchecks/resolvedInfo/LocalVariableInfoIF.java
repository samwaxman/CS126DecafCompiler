package staticchecks.resolvedInfo;

import org.immutables.value.Value;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface LocalVariableInfoIF {
    ResolvedType getType();
    int getIndex();
}
