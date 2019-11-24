package astPojos;

import bytecode.ByteCodeState;

public interface LValue {

    void bind(ByteCodeState state, Expression expr);

}
