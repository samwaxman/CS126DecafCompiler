package astPojos;

import staticchecks.StaticState;

abstract public class Statement extends ASTNode implements Bytecodeable {

    public Statement(Integer line, Integer column) {
        super(line, column);
    }

    abstract public void typeCheck(StaticState s);

}
