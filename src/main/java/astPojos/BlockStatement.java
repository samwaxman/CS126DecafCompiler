package astPojos;

import staticchecks.StaticState;

import java.util.List;

public class BlockStatement extends Statement {
    private final List<Statement> statements;

    public BlockStatement(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public void typeCheck(StaticState s) {
        for (Statement statement : statements) {
            statement.typeCheck(s);
        }
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
