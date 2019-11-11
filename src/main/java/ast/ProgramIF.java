package ast;

import org.immutables.value.Value;
import styles.ImmutableStyle;
import java.util.List;

@Value.Immutable
@ImmutableStyle
public interface ProgramIF extends ASTNode {
    List<ClassASTNode> getClasses();
}
