package staticchecks;

import ast.*;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.Map;

public class TypeChecker {

    //Skipped -- ClassASTNode
    public static ResolvedType typeCheck(ASTNode node, Map<String, ResolvedType> environment, StaticState state) {

        if (node instanceof ConstructorCall) {
            ConstructorCall n = (ConstructorCall) node;

        }
    }

    private static ResolvedType checkBinaryOp(ResolvedType left, ResolvedType right, String operator) {
        return PrimitiveType.num;
    }

    private static StaticState buildClassInformation(Program p) {
        for (ClassASTNode clazz : p.getClasses()) {

        }
    }
}
