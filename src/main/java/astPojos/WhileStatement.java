package astPojos;

import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

public class WhileStatement extends Statement {

    private final Expression testExpression;
    private final Statement body;

    public WhileStatement(Expression testExpression, Statement body) {
        this.testExpression = testExpression;
        this.body = body;
    }

    @Override
    public void typeCheck(StaticState s) {
        ResolvedType testType = testExpression.typeCheck(s);
        body.typeCheck(s.withInsideBreakableStatement(true));
        if (testType != PrimitiveType.BOOLEAN) {
            throw new RuntimeException("Expected boolean for test expression of while loop. Found "
            + testType + ".");
        }
    }

    public Expression getTestExpression() {
        return testExpression;
    }

    public Statement getBody() {
        return body;
    }
}
