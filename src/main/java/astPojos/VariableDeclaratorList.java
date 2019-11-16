package astPojos;

import staticchecks.StaticState;

import java.util.List;

public class VariableDeclaratorList extends Statement {
    private final List<VariableDeclarationStatement> declarations;

    public VariableDeclaratorList(List<VariableDeclarationStatement> declarations) {
        this.declarations = declarations;
    }

    @Override
    public void typeCheck(StaticState s) {
        for (VariableDeclarationStatement declaration : declarations) {
            declaration.typeCheck(s);
        }
    }

    public List<VariableDeclarationStatement> getDeclarations() {
        return declarations;
    }
}
