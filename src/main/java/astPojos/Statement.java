package astPojos;

import staticchecks.StaticState;

abstract public class Statement implements Bytecodeable {

    abstract public void typeCheck(StaticState s);

}
