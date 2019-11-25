package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.*;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ArrayType;
import staticchecks.resolvedInfo.ClassType;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

public class ArrayAccess extends Expression implements LValue{
    private final Expression array;
    private final Expression index;

    public ArrayAccess(Expression expr, Expression index) {
        this.array = expr;
        this.index = index;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        ResolvedType arrayType = array.typeCheck(s);
        ResolvedType indexType = index.typeCheck(s);
        if (indexType != PrimitiveType.INT) {
            throw new RuntimeException("Array index not a number.");
        }
        if (!(arrayType instanceof ArrayType)) {
            throw new RuntimeException("Attempted to perform an array access on a non-array.");
        }
        ResolvedType type;
        ArrayType arrT = (ArrayType) arrayType;
        if (arrT.getDimension() == 1) {
            return arrT.getType();
        } else {
            return arrT.withDimension(arrT.getDimension() - 1);
        }
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        array.toBytecode(state);
        index.toBytecode(state);
        ResolvedType t = array.getType();
        assert t instanceof ArrayType;
        ArrayType arrayType = (ArrayType) t;
        if (arrayType.getDimension() > 1 || arrayType.getType() instanceof ClassType) {
            state.append(new AALOAD());
            return;
        }

        ResolvedType baseType = arrayType.getType();
        if (baseType == PrimitiveType.BOOLEAN) {
            state.append(new BALOAD());
        } else if (baseType == PrimitiveType.CHAR) {
            state.append(new CALOAD());
        } else if (baseType == PrimitiveType.INT) {
            state.append(new IALOAD());
        } else {
            assert false : "Base type was not a non-void primitive or a class type.";
        }
    }

    @Override
    public void bind(ByteCodeState state, Expression expr) {
        array.toBytecode(state);
        index.toBytecode(state);
        expr.toBytecode(state);
        state.append(new DUP_X2());
        assert array.getType() instanceof ArrayType;
        ArrayType arrayType = (ArrayType) array.getType();
        if (arrayType.getType().isRef() || arrayType.getDimension() > 1) {
            state.append(new AASTORE());
        } else if (arrayType.getType() == PrimitiveType.BOOLEAN) {
            state.append(new BASTORE());
        } else if (arrayType.getType() == PrimitiveType.CHAR) {
            state.append(new CASTORE());
        } else if (arrayType.getType() == PrimitiveType.INT) {
            state.append(new IASTORE());
        } else {
            assert false : "Types exhausted.";
        }
    }

    public Expression getArray() {
        return array;
    }

    public Expression getIndex() {
        return index;
    }
}
