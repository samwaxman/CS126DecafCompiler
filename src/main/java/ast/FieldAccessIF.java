package ast;

import org.immutables.value.Value;
import staticchecks.*;
import staticchecks.resolvedInfo.ClassInfo;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedField;
import staticchecks.resolvedInfo.ResolvedType;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface FieldAccessIF extends Expression {
    Expression getObject();
    String getFieldName();

    @Override
    default ResolvedType typeCheck(StaticState s) {
        ResolvedType objectType = getObject().typeCheck(s);
        if (objectType instanceof ClassType) {
            String className = ((ClassType) objectType).getClassName();
            ClassInfo classInfo = s.getClasses().get(className);
            assert classInfo != null : "Type check for the object should ensure the class type is valid.";
            ResolvedField resolvedField = StaticChecksHelper.resolveField(getFieldName(), className, s);
                    classInfo.getFields().get(getFieldName());
            return resolvedField.getType();
        }
        if (objectType instanceof ArrayType) {
            if (!getFieldName().equals("length")) {
                throw new RuntimeException("The only accessible field on an array is .length.");
            }
            return PrimitiveType.num;
        }
        throw new RuntimeException("Attempted to access field on primitive type.");
    }
}
