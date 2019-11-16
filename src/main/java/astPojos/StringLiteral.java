package astPojos;

import staticchecks.StaticState;
import staticchecks.resolvedInfo.ClassType;
import staticchecks.resolvedInfo.ResolvedType;

public class StringLiteral extends Expression {
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
}
