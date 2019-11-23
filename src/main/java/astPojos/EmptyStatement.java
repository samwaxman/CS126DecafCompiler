package astPojos;

import bytecode.ByteCodeState;
import staticchecks.StaticState;

public class EmptyStatement extends Statement {

    @Override
    public void typeCheck(StaticState s) {
        // Intentionally blank
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        // Intentionally blank. Make sure this doesn't mess up anything that expects
        // a statement to have added code. If it does, turn it into a NOP append for now
    }
}
