package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.*;
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

    @Override
    public void toBytecode(ByteCodeState state) {
        //TODO: Probably okay to do a bipush
        state.append(new LDC(state.getConstantPoolGen().addInteger(character)));
    }
}
