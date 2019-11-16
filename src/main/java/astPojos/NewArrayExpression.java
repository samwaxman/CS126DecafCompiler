package astPojos;

import ast.Type;
import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ArrayType;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.List;

public class NewArrayExpression extends Expression {

    private final Type baseType;
    private final List<Expression> dimensions;

    public NewArrayExpression(Type baseType, List<Expression> dimensions) {
        this.baseType = baseType;
        // TODO: I thought I saw some weird constructor syntax in the docs where
        // you didn't write new String[1][4], you wrote new String[][](1,4)
        this.dimensions = dimensions;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        ResolvedType type = StaticChecksHelper.resolveType(baseType, s);
        for (Expression index : dimensions) {
            if (index.typeCheck(s) != PrimitiveType.INT) {
                throw new RuntimeException("Expected integer for indexing into array but received" +
                index.getType());
            }
        }

       return ArrayType.builder()
               .setType(type)
               .setDimension(dimensions.size())
               .build();
    }

    public Type getBaseType() {
        return baseType;
    }

    public List<Expression> getDimensions() {
        return dimensions;
    }
}
