package astPojos;

import staticchecks.StaticState;

public class BreakStatement extends Statement {

    @Override
    public void typeCheck(StaticState s) {
        if (!s.isInsideBreakableStatement()) {
            throw new RuntimeException("Break used outside of while loop.");
        }
    }
}
