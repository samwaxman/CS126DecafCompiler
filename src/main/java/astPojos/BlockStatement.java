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
        s.getLocalVariableTable().enterBlock();
        for (Statement statement : statements) {
            statement.typeCheck(s);
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
