package astPojos;

import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import staticchecks.StaticState;

import java.util.Map;

public class ExpressionStatement extends Statement {
    private final Expression expression;

    public ExpressionStatement(Expression expression) {
        this.expression = expression;
    }
    @Override
    public void typeCheck(StaticState s) {
        expression.typeCheck(s);
    }

    @Override
    public InstructionHandle toBytecode(Map<String, ClassGen> javaClassMap, InstructionList il, ConstantPoolGen cp) {
        return expression.toBytecode(javaClassMap, il, cp);
    }

    public Expression getExpression() {
        return expression;
    }
}
