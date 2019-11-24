package astPojos;

import bytecode.ByteCodeState;
import staticchecks.StaticState;

import java.util.List;

public class BlockStatement extends Statement {
    private final List<Statement> statements;

    public BlockStatement(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public void typeCheck(StaticState s) {
        //TODO: this is a wasteful way of passing the firstInConstructorCall information on.
        // optimize it.
        if (statements.isEmpty()) {
            return;
        }
        s.getLocalVariableTable().enterBlock();
        statements.get(0).typeCheck(s);
        for (int i = 1; i < statements.size(); i++) {
            statements.get(i).typeCheck(s.withFirstStatementInConstructorCall(false));
        }
        //TODO : Add state variable for top scope, and verify that last statement is a return statement;
        s.getLocalVariableTable().exitBlock();
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        for (Statement s : statements) {
            s.toBytecode(state);
        }
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
