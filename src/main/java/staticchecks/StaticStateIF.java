package staticchecks;

import com.sun.istack.internal.Nullable;
import org.immutables.value.Value;
import staticchecks.resolvedInfo.ClassInfo;
import staticchecks.resolvedInfo.ResolvedType;
import styles.ImmutableStyle;

import java.util.Map;
import java.util.Optional;

@Value.Immutable
@ImmutableStyle
public interface StaticStateIF {
    @Nullable
    String getCurrentClass();
    Map<String, ClassInfo> getClasses();
    @Nullable
    LocalVariableInfoTable getLocalVariableTable();

    @Value.Default
    default boolean isInsideBreakableStatement() {
        return false;
    };

    // To know if a super constructor call is allowed.
    @Value.Default
    default boolean isFirstStatementInConstructorCall() {
        return false;
    };

    // To know if we should throw a return in a block end
    @Value.Default
    default boolean isTopLevelBlock() {
        return true;
    };

    // To know if THIS and SUPER are allowed
    @Value.Default
    default boolean isMethodStatic() {
        return false;
    };
    Optional<ResolvedType> getReturnType();
}