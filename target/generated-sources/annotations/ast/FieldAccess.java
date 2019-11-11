package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link FieldAccessIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code FieldAccess.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "FieldAccessIF"})
public final class FieldAccess implements FieldAccessIF {
  private final Expression object;
  private final String fieldName;

  private FieldAccess(Expression object, String fieldName) {
    this.object = object;
    this.fieldName = fieldName;
  }

  /**
   * @return The value of the {@code object} attribute
   */
  @Override
  public Expression getObject() {
    return object;
  }

  /**
   * @return The value of the {@code fieldName} attribute
   */
  @Override
  public String getFieldName() {
    return fieldName;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldAccessIF#getObject() object} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for object
   * @return A modified copy of the {@code this} object
   */
  public final FieldAccess withObject(Expression value) {
    if (this.object == value) return this;
    Expression newValue = Objects.requireNonNull(value, "object");
    return new FieldAccess(newValue, this.fieldName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldAccessIF#getFieldName() fieldName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for fieldName
   * @return A modified copy of the {@code this} object
   */
  public final FieldAccess withFieldName(String value) {
    if (this.fieldName.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "fieldName");
    return new FieldAccess(this.object, newValue);
  }

  /**
   * This instance is equal to all instances of {@code FieldAccess} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof FieldAccess
        && equalTo((FieldAccess) another);
  }

  private boolean equalTo(FieldAccess another) {
    return object.equals(another.object)
        && fieldName.equals(another.fieldName);
  }

  /**
   * Computes a hash code from attributes: {@code object}, {@code fieldName}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + object.hashCode();
    h += (h << 5) + fieldName.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code FieldAccess} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("FieldAccess")
        .omitNullValues()
        .add("object", object)
        .add("fieldName", fieldName)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link FieldAccessIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable FieldAccess instance
   */
  public static FieldAccess copyOf(FieldAccessIF instance) {
    if (instance instanceof FieldAccess) {
      return (FieldAccess) instance;
    }
    return FieldAccess.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link FieldAccess FieldAccess}.
   * @return A new FieldAccess builder
   */
  public static FieldAccess.Builder builder() {
    return new FieldAccess.Builder();
  }

  /**
   * Builds instances of type {@link FieldAccess FieldAccess}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_OBJECT = 0x1L;
    private static final long INIT_BIT_FIELD_NAME = 0x2L;
    private long initBits = 0x3L;

    private Expression object;
    private String fieldName;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code FieldAccessIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(FieldAccessIF instance) {
      Objects.requireNonNull(instance, "instance");
      setObject(instance.getObject());
      setFieldName(instance.getFieldName());
      return this;
    }

    /**
     * Initializes the value for the {@link FieldAccessIF#getObject() object} attribute.
     * @param object The value for object 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setObject(Expression object) {
      this.object = Objects.requireNonNull(object, "object");
      initBits &= ~INIT_BIT_OBJECT;
      return this;
    }

    /**
     * Initializes the value for the {@link FieldAccessIF#getFieldName() fieldName} attribute.
     * @param fieldName The value for fieldName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setFieldName(String fieldName) {
      this.fieldName = Objects.requireNonNull(fieldName, "fieldName");
      initBits &= ~INIT_BIT_FIELD_NAME;
      return this;
    }

    /**
     * Builds a new {@link FieldAccess FieldAccess}.
     * @return An immutable instance of FieldAccess
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public FieldAccess build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new FieldAccess(object, fieldName);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_OBJECT) != 0) attributes.add("object");
      if ((initBits & INIT_BIT_FIELD_NAME) != 0) attributes.add("fieldName");
      return "Cannot build FieldAccess, some of required attributes are not set " + attributes;
    }
  }
}
