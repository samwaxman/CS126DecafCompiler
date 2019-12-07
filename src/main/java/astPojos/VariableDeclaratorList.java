package astPojos;

import bytecode.ByteCodeState;
import staticchecks.StaticState;

import java.util.List;

public class VariableDeclaratorList extends Statement {
    private final List<VariableDeclarationStatement> declarations;

    public VariableDeclaratorList(List<VariableDeclarationStatement> declarations,
                                  Integer line,
                                  Integer column) {
        super(line, column);
        this.declarations = declarations;
    }

    @Override
    public void typeCheck(StaticState s) {
        for (VariableDeclarationStatement declaration : declarations) {
            declaration.typeCheck(s);
        }
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        //TODO: Are they done in parallel? Can one declaration access a previously initialized var?
        for (VariableDeclarationStatement vds : declarations) {
            vds.toBytecode(state);
        }
    }

    public List<VariableDeclarationStatement> getDeclarations() {
        return declarations;
    }
}
