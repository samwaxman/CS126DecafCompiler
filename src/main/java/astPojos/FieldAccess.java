package astPojos;

import bytecode.ByteCodeState;
import bytecode.BytecodeCreator;
import org.apache.bcel.generic.ARRAYLENGTH;
import org.apache.bcel.generic.DUP_X1;
import org.apache.bcel.generic.GETFIELD;
import org.apache.bcel.generic.PUTFIELD;
import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.*;

public class FieldAccess extends Expression implements FieldResolvable, LValue {
    private final Expression object;
    private final String fieldName;
    private String fromClass;

    public FieldAccess(Expression object, String fieldName) {
        this.object = object;
        this.fieldName = fieldName;
    }

    public String getFromClass() {
        return fromClass;
    }

    public Expression getObject() {
        return object;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFromClass(String fromClass) {
        this.fromClass = fromClass;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        ResolvedType objectType = object.typeCheck(s);
        if (objectType instanceof ClassType) {
            String className = ((ClassType) objectType).getClassName();
            ClassInfo classInfo = s.getClasses().get(className);
            assert classInfo != null : "Type check for the object should ensure the class type is valid.";
            ResolvedField resolvedField = StaticChecksHelper.resolveField(this, className, s);
            return resolvedField.getType();
        }
        if (objectType instanceof ArrayType) {
            if (!fieldName.equals("length")) {
                throw new RuntimeException("The only accessible field on an array is .length.");
            }
            return PrimitiveType.INT;
        }
        throw new RuntimeException("Attempted to access field on primitive type.");
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        if (object.getType() instanceof ArrayType) {
            if (fieldName.equals("length")) {
                object.toBytecode(state);
                state.append(new ARRAYLENGTH());
                return;
            }
            assert false : "Type checking should assure we don't get here";
        }
        object.toBytecode(state);
        accessField(state, false);
    }

    @Override
    public void bind(ByteCodeState state, Expression expr) {
        object.toBytecode(state);
        expr.toBytecode(state);
        state.append(new DUP_X1());
        accessField(state, true);
    }

    private void accessField(ByteCodeState state, boolean set) {
        String signature = BytecodeCreator.resolvedTypeToBcelType(getType()).getSignature();
        int fieldIndex = state.getConstantPoolGen().addFieldref(fromClass, fieldName, signature);
        state.append(set ? new PUTFIELD(fieldIndex) : new GETFIELD(fieldIndex));
    }
}
