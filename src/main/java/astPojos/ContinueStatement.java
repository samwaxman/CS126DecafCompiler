package astPojos;

import staticchecks.StaticState;

public class ContinueStatement extends Statement {

    @Override
    public void typeCheck(StaticState s) {
        if (!s.isInsideBreakableStatement()) {
            throw new RuntimeException("Continue used outside of while loop.");
        }
    }
}
