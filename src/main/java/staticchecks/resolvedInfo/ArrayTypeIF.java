package staticchecks.resolvedInfo;

import org.immutables.value.Value;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface ArrayTypeIF extends ResolvedType {
    int getDimension();
    ResolvedType getType();
}
