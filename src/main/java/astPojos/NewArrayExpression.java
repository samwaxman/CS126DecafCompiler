package astPojos;

import ast.Type;
import bytecode.ByteCodeState;
import bytecode.BytecodeCreator;
import org.apache.bcel.generic.MULTIANEWARRAY;
import org.apache.bcel.generic.NEWARRAY;
import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ArrayType;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.List;

public class NewArrayExpression extends Expression {

    private final Type baseType;
    private final List<Expression> dimensions;

    public NewArrayExpression(Type baseType, List<Expression> dimensions, int line, int column) {
        super(line, column);
        this.baseType = baseType;
        // TODO: I thought I saw some weird constructor syntax in the docs where
        // you didn't write new String[1][4], you wrote new String[][](1,4)
        this.dimensions = dimensions;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        ResolvedType type = StaticChecksHelper.resolveType(baseType, s);
        if (!(type == PrimitiveType.BOOLEAN || type == PrimitiveType.INT || type == PrimitiveType.CHAR)) {
            this.throwCompilerError("Decaf only supports creation of primitive non-void arrays. " +
                                               "Got array base type of " + type);
        }
        for (Expression index : dimensions) {
            if (index.typeCheck(s) != PrimitiveType.INT) {
                this.throwCompilerError("Expected integer for indexing into array but received" +
                index.getType());
            }
        }
        if (dimensions.size() > 32767) {
            this.throwCompilerError("Dimension count for arrays must be within short range.");
        }

       return ArrayType.builder()
               .setType(type)
               .setDimension(dimensions.size())
               .build();
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        ArrayType t = (ArrayType)getType();
        org.apache.bcel.generic.ArrayType arrayType =
                (org.apache.bcel.generic.ArrayType) BytecodeCreator.resolvedTypeToBcelType(t);
        if (dimensions.size() == 1) {
            dimensions.get(0).toBytecode(state);
            state.append(new NEWARRAY(arrayType.getBasicType().getType()));
        } else {
            for (Expression e : dimensions) {
                e.toBytecode(state);
            }
            int index = state.getConstantPoolGen().addArrayClass(arrayType);
            state.append(new MULTIANEWARRAY(index, (short)dimensions.size()));
        }
    }

    public Type getBaseType() {
        return baseType;
    }

    public List<Expression> getDimensions() {
        return dimensions;
    }
}
