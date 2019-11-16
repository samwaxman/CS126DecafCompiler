package ast;

import staticchecks.StaticState;
import staticchecks.resolvedInfo.ResolvedType;

public interface ASTNode {
    ResolvedType typeCheck(StaticState s);
}
