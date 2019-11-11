package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link NewArrayExpressionIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code NewArrayExpression.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "NewArrayExpressionIF"})
public final class NewArrayExpression implements NewArrayExpressionIF {
  private final String baseType;
  private final ImmutableList<Expression> dimensions;

  private NewArrayExpression(String baseType, ImmutableList<Expression> dimensions) {
    this.baseType = baseType;
    this.dimensions = dimensions;
  }

  /**
   * @return The value of the {@code baseType} attribute
   */
  @Override
  public String getBaseType() {
    return baseType;
  }

  /**
   * @return The value of the {@code dimensions} attribute
   */
  @Override
  public ImmutableList<Expression> getDimensions() {
    return dimensions;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link NewArrayExpressionIF#getBaseType() baseType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for baseType
   * @return A modified copy of the {@code this} object
   */
  public final NewArrayExpression withBaseType(String value) {
    if (this.baseType.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "baseType");
    return new NewArrayExpression(newValue, this.dimensions);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link NewArrayExpressionIF#getDimensions() dimensions}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final NewArrayExpression withDimensions(Expression... elements) {
    ImmutableList<Expression> newValue = ImmutableList.copyOf(elements);
    return new NewArrayExpression(this.baseType, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link NewArrayExpressionIF#getDimensions() dimensions}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of dimensions elements to set
   * @return A modified copy of {@code this} object
   */
  public final NewArrayExpression withDimensions(Iterable<? extends Expression> elements) {
    if (this.dimensions == elements) return this;
    ImmutableList<Expression> newValue = ImmutableList.copyOf(elements);
    return new NewArrayExpression(this.baseType, newValue);
  }

  /**
   * This instance is equal to all instances of {@code NewArrayExpression} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof NewArrayExpression
        && equalTo((NewArrayExpression) another);
  }

  private boolean equalTo(NewArrayExpression another) {
    return baseType.equals(another.baseType)
        && dimensions.equals(another.dimensions);
  }

  /**
   * Computes a hash code from attributes: {@code baseType}, {@code dimensions}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + baseType.hashCode();
    h += (h << 5) + dimensions.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code NewArrayExpression} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("NewArrayExpression")
        .omitNullValues()
        .add("baseType", baseType)
        .add("dimensions", dimensions)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link NewArrayExpressionIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable NewArrayExpression instance
   */
  public static NewArrayExpression copyOf(NewArrayExpressionIF instance) {
    if (instance instanceof NewArrayExpression) {
      return (NewArrayExpression) instance;
    }
    return NewArrayExpression.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link NewArrayExpression NewArrayExpression}.
   * @return A new NewArrayExpression builder
   */
  public static NewArrayExpression.Builder builder() {
    return new NewArrayExpression.Builder();
  }

  /**
   * Builds instances of type {@link NewArrayExpression NewArrayExpression}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_BASE_TYPE = 0x1L;
    private long initBits = 0x1L;

    private String baseType;
    private ImmutableList.Builder<Expression> dimensions = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code NewArrayExpressionIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(NewArrayExpressionIF instance) {
      Objects.requireNonNull(instance, "instance");
      setBaseType(instance.getBaseType());
      addAllDimensions(instance.getDimensions());
      return this;
    }

    /**
     * Initializes the value for the {@link NewArrayExpressionIF#getBaseType() baseType} attribute.
     * @param baseType The value for baseType 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setBaseType(String baseType) {
      this.baseType = Objects.requireNonNull(baseType, "baseType");
      initBits &= ~INIT_BIT_BASE_TYPE;
      return this;
    }

    /**
     * Adds one element to {@link NewArrayExpressionIF#getDimensions() dimensions} list.
     * @param element A dimensions element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addDimensions(Expression element) {
      this.dimensions.add(element);
      return this;
    }

    /**
     * Adds elements to {@link NewArrayExpressionIF#getDimensions() dimensions} list.
     * @param elements An array of dimensions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addDimensions(Expression... elements) {
      this.dimensions.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link NewArrayExpressionIF#getDimensions() dimensions} list.
     * @param elements An iterable of dimensions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setDimensions(Iterable<? extends Expression> elements) {
      this.dimensions = ImmutableList.builder();
      return addAllDimensions(elements);
    }

    /**
     * Adds elements to {@link NewArrayExpressionIF#getDimensions() dimensions} list.
     * @param elements An iterable of dimensions elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllDimensions(Iterable<? extends Expression> elements) {
      this.dimensions.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link NewArrayExpression NewArrayExpression}.
     * @return An immutable instance of NewArrayExpression
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public NewArrayExpression build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new NewArrayExpression(baseType, dimensions.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_BASE_TYPE) != 0) attributes.add("baseType");
      return "Cannot build NewArrayExpression, some of required attributes are not set " + attributes;
    }
  }
}
