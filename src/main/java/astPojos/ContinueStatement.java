package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.BranchInstruction;
import staticchecks.StaticState;

public class ContinueStatement extends Statement {

    public ContinueStatement(int line, int column) {
        super(line, column);
    }

    @Override
    public void typeCheck(StaticState s) {
        if (!s.isInsideBreakableStatement()) {
            this.throwCompilerError("Continue used outside of while loop.");
        }
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        assert state.getWhileLoopStart().isPresent() : "Type checking should disallow this.";
        state.append((BranchInstruction)state.getWhileLoopStart().get().copy());
    }
}
