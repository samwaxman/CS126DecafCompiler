package astPojos;

import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ResolvedType;

public abstract class Expression implements Bytecodeable {

    private ResolvedType type;

    abstract protected ResolvedType typeCheckCore(StaticState s);

    public final ResolvedType typeCheck(StaticState s) {
        ResolvedType type = typeCheckCore(s);
        setType(type);
        return type;
    }

    public InstructionHandle pushOntoStack(InstructionList il) {
        throw new RuntimeException("Not implemented");
    }

    public final ResolvedType getType() {
        return type;
    }

    private void setType(ResolvedType type) {
        this.type = type;
    }
}
