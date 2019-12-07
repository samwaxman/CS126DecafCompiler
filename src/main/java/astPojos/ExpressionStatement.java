package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.POP;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;

public class ExpressionStatement extends Statement {
    private final Expression expression;

    public ExpressionStatement(Expression expression, int line, int column) {
        super(line, column);
        this.expression = expression;
    }
    @Override
    public void typeCheck(StaticState s) {
        expression.typeCheck(s);
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        expression.toBytecode(state);
        if (expression.getType() != PrimitiveType.VOID) {
            state.append(new POP());
        }
    }

    public Expression getExpression() {
        return expression;
    }
}
