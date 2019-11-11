package ast;

import org.immutables.value.Value;
import staticchecks.resolvedInfo.ClassType;
import staticchecks.resolvedInfo.ResolvedType;
import staticchecks.StaticState;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface StringLiteralIF extends Expression {
    String getString();

    @Override
    default ResolvedType typeCheck(StaticState s) {
        return ClassType.builder().setClassName("String").build();
    }
}
