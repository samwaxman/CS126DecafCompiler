package astPojos;

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

    public Expression getExpression() {
        return expression;
    }
}
