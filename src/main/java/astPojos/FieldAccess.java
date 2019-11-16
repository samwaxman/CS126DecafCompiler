package astPojos;

import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.*;

public class FieldAccess extends Expression implements FieldResolvable {
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
}
