package astPojos;

import bytecode.ByteCodeState;
import staticchecks.StaticState;

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
    public void toBytecode(ByteCodeState state) {
        expression.toBytecode(state);
    }

    public Expression getExpression() {
        return expression;
    }
}
