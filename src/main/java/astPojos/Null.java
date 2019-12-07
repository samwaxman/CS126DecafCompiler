package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.ACONST_NULL;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.NullType;
import staticchecks.resolvedInfo.ResolvedType;

public class Null extends Expression {

    public Null(Integer line, Integer column) {
        super(line, column);
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        //I should probs annotate the immutable style to give one
        //parameter immutables Constructor syntax instead of builder syntax

        return NullType.builder().build();
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        state.append(new ACONST_NULL());
    }
}
