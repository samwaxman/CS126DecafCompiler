package staticchecks.resolvedInfo;

public interface ResolvedType {

    default boolean isRef() {
        return this instanceof ArrayType || this instanceof ClassType || this instanceof NullType;
    }
}
