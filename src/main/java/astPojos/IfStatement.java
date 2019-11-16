package astPojos;

import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.Optional;

public class IfStatement extends Statement {

    private final Expression condition;
    private final Statement consequence;
    private final Optional<Statement> alternate;

    public IfStatement(Expression condition, Statement consequence, Optional<Statement> alternate) {
        this.condition = condition;
        this.consequence = consequence;
        this.alternate = alternate;
    }

    @Override
    public void typeCheck(StaticState s) {
        ResolvedType conditionType = condition.typeCheck(s);
        consequence.typeCheck(s);
        alternate.ifPresent(a -> a.typeCheck(s));

        if (conditionType != PrimitiveType.BOOLEAN) {
            throw new RuntimeException("Conditional statement expected an expression " +
                                               "of type boolean for its condition. Received " +
                                               conditionType);
        }
    }

    public Expression getCondition() {
        return condition;
    }

    public Statement getConsequence() {
        return consequence;
    }

    public Optional<Statement> getAlternate() {
        return alternate;
    }
}
