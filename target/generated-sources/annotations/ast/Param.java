package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link ParamIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Param.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ParamIF"})
public final class Param implements ParamIF {
  private final String name;
  private final Type type;

  private Param(String name, Type type) {
    this.name = name;
    this.type = type;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * @return The value of the {@code type} attribute
   */
  @Override
  public Type getType() {
    return type;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ParamIF#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final Param withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new Param(newValue, this.type);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ParamIF#getType() type} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final Param withType(Type value) {
    if (this.type == value) return this;
    Type newValue = Objects.requireNonNull(value, "type");
    return new Param(this.name, newValue);
  }

  /**
   * This instance is equal to all instances of {@code Param} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof Param
        && equalTo((Param) another);
  }

  private boolean equalTo(Param another) {
    return name.equals(another.name)
        && type.equals(another.type);
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code type}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + type.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Param} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Param")
        .omitNullValues()
        .add("name", name)
        .add("type", type)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ParamIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Param instance
   */
  public static Param copyOf(ParamIF instance) {
    if (instance instanceof Param) {
      return (Param) instance;
    }
    return Param.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link Param Param}.
   * @return A new Param builder
   */
  public static Param.Builder builder() {
    return new Param.Builder();
  }

  /**
   * Builds instances of type {@link Param Param}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_TYPE = 0x2L;
    private long initBits = 0x3L;

    private String name;
    private Type type;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ParamIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ParamIF instance) {
      Objects.requireNonNull(instance, "instance");
      setName(instance.getName());
      setType(instance.getType());
      return this;
    }

    /**
     * Initializes the value for the {@link ParamIF#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setName(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link ParamIF#getType() type} attribute.
     * @param type The value for type 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setType(Type type) {
      this.type = Objects.requireNonNull(type, "type");
      initBits &= ~INIT_BIT_TYPE;
      return this;
    }

    /**
     * Builds a new {@link Param Param}.
     * @return An immutable instance of Param
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Param build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new Param(name, type);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      return "Cannot build Param, some of required attributes are not set " + attributes;
    }
  }
}
