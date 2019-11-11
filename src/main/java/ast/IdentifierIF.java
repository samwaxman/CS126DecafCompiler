package ast;

import org.immutables.value.Value;
import staticchecks.resolvedInfo.ClassInfo;
import staticchecks.resolvedInfo.ResolvedField;
import staticchecks.resolvedInfo.ResolvedMethod;
import staticchecks.resolvedInfo.ResolvedType;
import staticchecks.StaticState;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface IdentifierIF extends Expression {
    String getIdentifier();

    @Override
    default ResolvedType typeCheck(StaticState s) {
        ResolvedType t = s.getEnvironment().get(getIdentifier());
        if (t == null) {
            ClassInfo classInfo = s.getClasses().get(s.getCurrentClass());
            assert classInfo != null : "current class should be in class table";
            ResolvedField field = classInfo.getFields().get(getIdentifier());
            if (field != null) {
                return field.getType();
            }
            throw new RuntimeException("Unbound identifier: " + getIdentifier());
        }
        return t;
    }


}
