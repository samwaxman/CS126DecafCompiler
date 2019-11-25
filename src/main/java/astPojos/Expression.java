package astPojos;

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

    public final ResolvedType getType() {
        return type;
    }

    private void setType(ResolvedType type) {
        this.type = type;
    }
}
