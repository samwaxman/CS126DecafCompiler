package astPojos;

import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

public class CharacterLiteral extends Expression {

    private final char character;

    public CharacterLiteral(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        return PrimitiveType.CHAR;
    }
}
