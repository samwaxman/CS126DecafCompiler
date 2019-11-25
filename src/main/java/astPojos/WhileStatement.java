package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.GOTO;
import org.apache.bcel.generic.IFEQ;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.NOP;
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

    @Override
    public void toBytecode(ByteCodeState state) {
        InstructionHandle start = state.getInstructionList().getEnd();
        testExpression.toBytecode(state);
        GOTO whileLoopEnd = new GOTO(null);
        assert start == null || start.getNext() != null : "Test expression should have added instructions.";
        GOTO whileLoopStart = new GOTO(start == null ? state.getInstructionList().getStart() : start.getNext());
        IFEQ ifIns = new IFEQ(null);
        state.append(ifIns);
        body.toBytecode(state.withWhileLoopEnd(whileLoopEnd)
                             .withWhileLoopStart(whileLoopStart));
        state.append(whileLoopStart);
        InstructionHandle end = state.append(new NOP());
        ifIns.setTarget(end);
        whileLoopEnd.setTarget(end);
    }
}
