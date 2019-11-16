package astPojos;

import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

public class UnaryOp extends Expression {
    private final Expression expression;
    private final String operator;

    public UnaryOp(Expression expression, String operator) {
        this.expression = expression;
        this.operator = operator;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        ResolvedType t = expression.typeCheck(s);
        switch (operator) {
            case "!":
                //Realistically should factor the conditional check into the helper function too
                // but ehh.
                if (t != PrimitiveType.BOOLEAN) {
                    throwTypeError(PrimitiveType.BOOLEAN, t);
                }
                return PrimitiveType.BOOLEAN;
            case "+":
            case "-":
                if (t != PrimitiveType.INT) {
                    throwTypeError(PrimitiveType.INT, t);
                }
                return PrimitiveType.INT;
        }
        assert false : "All operators handled.";
        return null;
    }

    // Could also not pass in the got type and just use expression.getType(), but ehh
    private void throwTypeError(ResolvedType expected, ResolvedType got) {
        throw new RuntimeException(operator + " expected a " + expected + ". Received " + got + ".");
    }

    public Expression getExpression() {
        return expression;
    }

    public String getOperator() {
        return operator;
    }
}
