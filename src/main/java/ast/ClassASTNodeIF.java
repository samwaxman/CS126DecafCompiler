package ast;

import java.util.List;
import java.util.Optional;

import org.immutables.value.Value;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface ClassASTNodeIF extends ASTNode {
    String getClassName();
    List<Method> getMethods();
    List<Field> getFields();
    Optional<String> getSuper();
    Optional<Constructor> getConstructor();
}
