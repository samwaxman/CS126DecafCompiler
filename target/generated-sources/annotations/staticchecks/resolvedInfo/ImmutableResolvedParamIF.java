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
 * {@code ImmutableResolvedParamIF.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ResolvedParamIF"})
public final class ImmutableResolvedParamIF implements ResolvedParamIF {
  private final ResolvedType type;
  private final String name;

  private ImmutableResolvedParamIF(ResolvedType type, String name) {
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
  public final ImmutableResolvedParamIF withType(ResolvedType value) {
    if (this.type == value) return this;
    ResolvedType newValue = Objects.requireNonNull(value, "type");
    return new ImmutableResolvedParamIF(newValue, this.name);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ResolvedParamIF#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableResolvedParamIF withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new ImmutableResolvedParamIF(this.type, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableResolvedParamIF} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableResolvedParamIF
        && equalTo((ImmutableResolvedParamIF) another);
  }

  private boolean equalTo(ImmutableResolvedParamIF another) {
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
   * Prints the immutable value {@code ResolvedParamIF} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ResolvedParamIF")
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
   * @return A copied immutable ResolvedParamIF instance
   */
  public static ImmutableResolvedParamIF copyOf(ResolvedParamIF instance) {
    if (instance instanceof ImmutableResolvedParamIF) {
      return (ImmutableResolvedParamIF) instance;
    }
    return ImmutableResolvedParamIF.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableResolvedParamIF ImmutableResolvedParamIF}.
   * @return A new ImmutableResolvedParamIF builder
   */
  public static ImmutableResolvedParamIF.Builder builder() {
    return new ImmutableResolvedParamIF.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableResolvedParamIF ImmutableResolvedParamIF}.
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
      type(instance.getType());
      name(instance.getName());
      return this;
    }

    /**
     * Initializes the value for the {@link ResolvedParamIF#getType() type} attribute.
     * @param type The value for type 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder type(ResolvedType type) {
      this.type = Objects.requireNonNull(type, "type");
      initBits &= ~INIT_BIT_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link ResolvedParamIF#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Builds a new {@link ImmutableResolvedParamIF ImmutableResolvedParamIF}.
     * @return An immutable instance of ResolvedParamIF
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableResolvedParamIF build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableResolvedParamIF(type, name);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      return "Cannot build ResolvedParamIF, some of required attributes are not set " + attributes;
    }
  }
}
