package ast;

import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.List;

@Value.Immutable
@ImmutableStyle
public interface FieldIF {
    Param getParam();
    List<Modifier> getModifiers();
}
