package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.*;
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
                if (t != PrimitiveType.INT && t != PrimitiveType.CHAR) {
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

    @Override
    public void toBytecode(ByteCodeState state) {
        switch (operator) {
            case "!":
                BranchInstruction negateBranch = new IFEQ(null);
                state.append(new ICONST(0));
                GOTO leaveIf = new GOTO(null);
                state.append(leaveIf);
                negateBranch.setTarget(state.append(new ICONST(1)));
                leaveIf.setTarget(state.append(new NOP()));
                break;
            case "-":
               state.append(new INEG());
               break;
            case "+":
                //Intentionally blank -- + does nothing code-wise
                break;
            default:
                assert false : "All operators handled.";
        }
    }

    public Expression getExpression() {
        return expression;
    }

    public String getOperator() {
        return operator;
    }
}
