package astPojos;

import org.apache.bcel.generic.*;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ClassType;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.Map;

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
    public InstructionHandle toBytecode(Map<String, ClassGen> javaClassMap, InstructionList il, ConstantPoolGen cp) {
        return il.append(new LDC(cp.addString(string)));
    }
}
