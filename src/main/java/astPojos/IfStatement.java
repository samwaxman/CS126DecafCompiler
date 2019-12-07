package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.*;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.Optional;

public class IfStatement extends Statement {

    private final Expression condition;
    private final Statement consequence;
    private final Optional<Statement> alternate;

    public IfStatement(Expression condition,
                       Statement consequence,
                       Optional<Statement> alternate,
                       int line,
                       int column) {
        super(line, column);
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
            this.throwCompilerError("Conditional statement expected an expression " +
                                               "of type boolean for its condition. Received " +
                                               conditionType);
        }
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        condition.toBytecode(state);
        IFEQ ifIns = new IFEQ(null);
        state.append(ifIns);
        consequence.toBytecode(state);
        if (alternate.isPresent()) {
            GOTO gotoIns = new GOTO(null);
            state.append(gotoIns);
            InstructionHandle current =  state.getInstructionList().getEnd();
            alternate.get().toBytecode(state);
            InstructionHandle alternateStart = current.getNext();
            assert alternateStart != null : "alternate should have added instructions";
            ifIns.setTarget(alternateStart);
            gotoIns.setTarget(state.append(new NOP()));
        } else {
            ifIns.setTarget(state.append(new NOP()));
        }
        return;
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
