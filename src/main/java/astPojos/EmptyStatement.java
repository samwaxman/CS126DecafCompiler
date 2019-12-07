package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.NOP;
import staticchecks.StaticState;

public class EmptyStatement extends Statement {

    public EmptyStatement(int line, int column) {
        super(line, column);
    }

    @Override
    public void typeCheck(StaticState s) {
        // Intentionally blank
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        // Intentionally blank. Make sure this doesn't mess up anything that expects
        // a statement to have added code. If it does, turn it into a NOP append for now
        state.append(new NOP());
    }
}
