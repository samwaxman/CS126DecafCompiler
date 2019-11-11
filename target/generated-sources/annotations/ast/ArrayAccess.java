package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link ArrayAccessIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ArrayAccess.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ArrayAccessIF"})
public final class ArrayAccess implements ArrayAccessIF {
  private final Expression expr;
  private final Expression index;

  private ArrayAccess(Expression expr, Expression index) {
    this.expr = expr;
    this.index = index;
  }

  /**
   * @return The value of the {@code expr} attribute
   */
  @Override
  public Expression getExpr() {
    return expr;
  }

  /**
   * @return The value of the {@code index} attribute
   */
  @Override
  public Expression getIndex() {
    return index;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ArrayAccessIF#getExpr() expr} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for expr
   * @return A modified copy of the {@code this} object
   */
  public final ArrayAccess withExpr(Expression value) {
    if (this.expr == value) return this;
    Expression newValue = Objects.requireNonNull(value, "expr");
    return new ArrayAccess(newValue, this.index);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ArrayAccessIF#getIndex() index} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for index
   * @return A modified copy of the {@code this} object
   */
  public final ArrayAccess withIndex(Expression value) {
    if (this.index == value) return this;
    Expression newValue = Objects.requireNonNull(value, "index");
    return new ArrayAccess(this.expr, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ArrayAccess} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ArrayAccess
        && equalTo((ArrayAccess) another);
  }

  private boolean equalTo(ArrayAccess another) {
    return expr.equals(another.expr)
        && index.equals(another.index);
  }

  /**
   * Computes a hash code from attributes: {@code expr}, {@code index}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + expr.hashCode();
    h += (h << 5) + index.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ArrayAccess} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ArrayAccess")
        .omitNullValues()
        .add("expr", expr)
        .add("index", index)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ArrayAccessIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ArrayAccess instance
   */
  public static ArrayAccess copyOf(ArrayAccessIF instance) {
    if (instance instanceof ArrayAccess) {
      return (ArrayAccess) instance;
    }
    return ArrayAccess.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ArrayAccess ArrayAccess}.
   * @return A new ArrayAccess builder
   */
  public static ArrayAccess.Builder builder() {
    return new ArrayAccess.Builder();
  }

  /**
   * Builds instances of type {@link ArrayAccess ArrayAccess}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_EXPR = 0x1L;
    private static final long INIT_BIT_INDEX = 0x2L;
    private long initBits = 0x3L;

    private Expression expr;
    private Expression index;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ArrayAccessIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ArrayAccessIF instance) {
      Objects.requireNonNull(instance, "instance");
      setExpr(instance.getExpr());
      setIndex(instance.getIndex());
      return this;
    }

    /**
     * Initializes the value for the {@link ArrayAccessIF#getExpr() expr} attribute.
     * @param expr The value for expr 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setExpr(Expression expr) {
      this.expr = Objects.requireNonNull(expr, "expr");
      initBits &= ~INIT_BIT_EXPR;
      return this;
    }

    /**
     * Initializes the value for the {@link ArrayAccessIF#getIndex() index} attribute.
     * @param index The value for index 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setIndex(Expression index) {
      this.index = Objects.requireNonNull(index, "index");
      initBits &= ~INIT_BIT_INDEX;
      return this;
    }

    /**
     * Builds a new {@link ArrayAccess ArrayAccess}.
     * @return An immutable instance of ArrayAccess
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ArrayAccess build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ArrayAccess(expr, index);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_EXPR) != 0) attributes.add("expr");
      if ((initBits & INIT_BIT_INDEX) != 0) attributes.add("index");
      return "Cannot build ArrayAccess, some of required attributes are not set " + attributes;
    }
  }
}
