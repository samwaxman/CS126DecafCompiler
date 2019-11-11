package staticchecks.resolvedInfo;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link ResolvedParamIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ResolvedParam.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ResolvedParamIF"})
public final class ResolvedParam implements ResolvedParamIF {
  private final ResolvedType type;
  private final String name;

  private ResolvedParam(ResolvedType type, String name) {
    this.type = type;
    this.name = name;
  }

  /**
   * @return The value of the {@code type} attribute
   */
  @Override
  public ResolvedType getType() {
    return type;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ResolvedParamIF#getType() type} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ResolvedParam withType(ResolvedType value) {
    if (this.type == value) return this;
    ResolvedType newValue = Objects.requireNonNull(value, "type");
    return new ResolvedParam(newValue, this.name);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ResolvedParamIF#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ResolvedParam withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new ResolvedParam(this.type, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ResolvedParam} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ResolvedParam
        && equalTo((ResolvedParam) another);
  }

  private boolean equalTo(ResolvedParam another) {
    return type.equals(another.type)
        && name.equals(another.name);
  }

  /**
   * Computes a hash code from attributes: {@code type}, {@code name}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + type.hashCode();
    h += (h << 5) + name.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ResolvedParam} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ResolvedParam")
        .omitNullValues()
        .add("type", type)
        .add("name", name)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ResolvedParamIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ResolvedParam instance
   */
  public static ResolvedParam copyOf(ResolvedParamIF instance) {
    if (instance instanceof ResolvedParam) {
      return (ResolvedParam) instance;
    }
    return ResolvedParam.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ResolvedParam ResolvedParam}.
   * @return A new ResolvedParam builder
   */
  public static ResolvedParam.Builder builder() {
    return new ResolvedParam.Builder();
  }

  /**
   * Builds instances of type {@link ResolvedParam ResolvedParam}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_TYPE = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private long initBits = 0x3L;

    private ResolvedType type;
    private String name;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ResolvedParamIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ResolvedParamIF instance) {
      Objects.requireNonNull(instance, "instance");
      setType(instance.getType());
      setName(instance.getName());
      return this;
    }

    /**
     * Initializes the value for the {@link ResolvedParamIF#getType() type} attribute.
     * @param type The value for type 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setType(ResolvedType type) {
      this.type = Objects.requireNonNull(type, "type");
      initBits &= ~INIT_BIT_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link ResolvedParamIF#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setName(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Builds a new {@link ResolvedParam ResolvedParam}.
     * @return An immutable instance of ResolvedParam
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ResolvedParam build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ResolvedParam(type, name);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      return "Cannot build ResolvedParam, some of required attributes are not set " + attributes;
    }
  }
}
