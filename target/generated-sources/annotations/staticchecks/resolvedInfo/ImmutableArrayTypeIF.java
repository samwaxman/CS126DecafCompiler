package staticchecks.resolvedInfo;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link ArrayTypeIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableArrayTypeIF.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ArrayTypeIF"})
public final class ImmutableArrayTypeIF implements ArrayTypeIF {
  private final int dimension;
  private final ResolvedType type;

  private ImmutableArrayTypeIF(int dimension, ResolvedType type) {
    this.dimension = dimension;
    this.type = type;
  }

  /**
   * @return The value of the {@code dimension} attribute
   */
  @Override
  public int getDimension() {
    return dimension;
  }

  /**
   * @return The value of the {@code type} attribute
   */
  @Override
  public ResolvedType getType() {
    return type;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ArrayTypeIF#getDimension() dimension} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for dimension
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableArrayTypeIF withDimension(int value) {
    if (this.dimension == value) return this;
    return new ImmutableArrayTypeIF(value, this.type);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ArrayTypeIF#getType() type} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableArrayTypeIF withType(ResolvedType value) {
    if (this.type == value) return this;
    ResolvedType newValue = Objects.requireNonNull(value, "type");
    return new ImmutableArrayTypeIF(this.dimension, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableArrayTypeIF} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableArrayTypeIF
        && equalTo((ImmutableArrayTypeIF) another);
  }

  private boolean equalTo(ImmutableArrayTypeIF another) {
    return dimension == another.dimension
        && type.equals(another.type);
  }

  /**
   * Computes a hash code from attributes: {@code dimension}, {@code type}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + dimension;
    h += (h << 5) + type.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ArrayTypeIF} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ArrayTypeIF")
        .omitNullValues()
        .add("dimension", dimension)
        .add("type", type)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ArrayTypeIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ArrayTypeIF instance
   */
  public static ImmutableArrayTypeIF copyOf(ArrayTypeIF instance) {
    if (instance instanceof ImmutableArrayTypeIF) {
      return (ImmutableArrayTypeIF) instance;
    }
    return ImmutableArrayTypeIF.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableArrayTypeIF ImmutableArrayTypeIF}.
   * @return A new ImmutableArrayTypeIF builder
   */
  public static ImmutableArrayTypeIF.Builder builder() {
    return new ImmutableArrayTypeIF.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableArrayTypeIF ImmutableArrayTypeIF}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_DIMENSION = 0x1L;
    private static final long INIT_BIT_TYPE = 0x2L;
    private long initBits = 0x3L;

    private int dimension;
    private ResolvedType type;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ArrayTypeIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ArrayTypeIF instance) {
      Objects.requireNonNull(instance, "instance");
      dimension(instance.getDimension());
      type(instance.getType());
      return this;
    }

    /**
     * Initializes the value for the {@link ArrayTypeIF#getDimension() dimension} attribute.
     * @param dimension The value for dimension 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder dimension(int dimension) {
      this.dimension = dimension;
      initBits &= ~INIT_BIT_DIMENSION;
      return this;
    }

    /**
     * Initializes the value for the {@link ArrayTypeIF#getType() type} attribute.
     * @param type The value for type 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder type(ResolvedType type) {
      this.type = Objects.requireNonNull(type, "type");
      initBits &= ~INIT_BIT_TYPE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableArrayTypeIF ImmutableArrayTypeIF}.
     * @return An immutable instance of ArrayTypeIF
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableArrayTypeIF build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableArrayTypeIF(dimension, type);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_DIMENSION) != 0) attributes.add("dimension");
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      return "Cannot build ArrayTypeIF, some of required attributes are not set " + attributes;
    }
  }
}
