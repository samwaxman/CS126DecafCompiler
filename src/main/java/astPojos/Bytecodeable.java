package astPojos;

import bytecode.ByteCodeState;

public interface Bytecodeable {

    default void toBytecode(ByteCodeState state) {
        throw new RuntimeException("toBytecode not implemented");
    }

}
