package astPojos;

import bytecode.ByteCodeState;
import staticchecks.StaticState;

public class BreakStatement extends Statement {

    @Override
    public void typeCheck(StaticState s) {
        if (!s.isInsideBreakableStatement()) {
            throw new RuntimeException("Break used outside of while loop.");
        }
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        assert state.getWhileLoopEnd().isPresent() : "Type checking should disallow this.";
        state.append(state.getWhileLoopEnd().get());
    }
}
