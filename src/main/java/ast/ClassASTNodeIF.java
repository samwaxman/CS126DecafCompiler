package ast;

import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.List;
import java.util.Optional;

@Value.Immutable
@ImmutableStyle
public interface ClassASTNodeIF {
    String getClassName();
    List<Method> getMethods();
    List<Field> getFields();
    Optional<String> getSuper();
    Optional<Constructor> getConstructor();
}
