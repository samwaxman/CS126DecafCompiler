package astPojos;

import org.apache.bcel.generic.*;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.Map;

public class CharacterLiteral extends LiteralExpression {

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
    public InstructionHandle toBytecode(Map<String, ClassGen> javaClassMap, InstructionList il, ConstantPoolGen cp) {
        //TODO: Probably okay to do a bipush
        return il.append(new LDC(cp.addInteger(character)));
    }
}
