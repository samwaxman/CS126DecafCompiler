package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.*;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ClassType;
import staticchecks.resolvedInfo.ResolvedType;

public class StringLiteral extends LiteralExpression {
    private final String string;

    public StringLiteral(String string) {
        this.string = string;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        return ClassType.builder().setClassName("String").build();
    }

    public String getString() {
        return string;
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        state.append(new LDC(state.getConstantPoolGen().addString(string)));
    }
}
