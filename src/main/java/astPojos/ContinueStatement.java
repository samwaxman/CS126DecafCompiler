package astPojos;

import bytecode.ByteCodeState;
import staticchecks.StaticState;

public class ContinueStatement extends Statement {

    @Override
    public void typeCheck(StaticState s) {
        if (!s.isInsideBreakableStatement()) {
            throw new RuntimeException("Continue used outside of while loop.");
        }
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        assert state.getWhileLoopStart().isPresent() : "Type checking should disallow this.";
        state.append(state.getWhileLoopStart().get());
    }
}
