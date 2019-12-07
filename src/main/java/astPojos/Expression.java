package astPojos;

import staticchecks.StaticState;
import staticchecks.resolvedInfo.ResolvedType;

public abstract class Expression extends ASTNode implements Bytecodeable {

    private ResolvedType type;

    public Expression(int line, int column) {
        super(line, column);
    }

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
