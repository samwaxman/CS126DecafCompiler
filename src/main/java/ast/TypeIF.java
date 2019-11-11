package ast;

import org.immutables.value.Value;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface TypeIF {
    String getTypeIdentifier();

    @Value.Default
    default int getArrayLevel() {
        return 0;
    }
}
