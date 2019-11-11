package ast;

import org.immutables.value.Value;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;
import staticchecks.StaticState;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface CharacterLiteralIF extends Expression {
    // In future just parse the char right into here
    String getCharacter();

    @Override
    default ResolvedType typeCheck(StaticState s) {
        return PrimitiveType.character;
    }
}
