package ast;

import staticchecks.resolvedInfo.ResolvedType;
import staticchecks.StaticState;

public interface ASTNode {
    ResolvedType typeCheck(StaticState s);
}
