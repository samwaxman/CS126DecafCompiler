package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link BinaryOpIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code BinaryOp.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "BinaryOpIF"})
public final class BinaryOp implements BinaryOpIF {
  private final Expression left;
  private final Expression right;
  private final String operator;

  private BinaryOp(Expression left, Expression right, String operator) {
    this.left = left;
    this.right = right;
    this.operator = operator;
  }

  /**
   * @return The value of the {@code left} attribute
   */
  @Override
  public Expression getLeft() {
    return left;
  }

  /**
   * @return The value of the {@code right} attribute
   */
  @Override
  public Expression getRight() {
    return right;
  }

  /**
   * @return The value of the {@code operator} attribute
   */
  @Override
  public String getOperator() {
    return operator;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link BinaryOpIF#getLeft() left} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for left
   * @return A modified copy of the {@code this} object
   */
  public final BinaryOp withLeft(Expression value) {
    if (this.left == value) return this;
    Expression newValue = Objects.requireNonNull(value, "left");
    return new BinaryOp(newValue, this.right, this.operator);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link BinaryOpIF#getRight() right} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for right
   * @return A modified copy of the {@code this} object
   */
  public final BinaryOp withRight(Expression value) {
    if (this.right == value) return this;
    Expression newValue = Objects.requireNonNull(value, "right");
    return new BinaryOp(this.left, newValue, this.operator);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link BinaryOpIF#getOperator() operator} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for operator
   * @return A modified copy of the {@code this} object
   */
  public final BinaryOp withOperator(String value) {
    if (this.operator.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "operator");
    return new BinaryOp(this.left, this.right, newValue);
  }

  /**
   * This instance is equal to all instances of {@code BinaryOp} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof BinaryOp
        && equalTo((BinaryOp) another);
  }

  private boolean equalTo(BinaryOp another) {
    return left.equals(another.left)
        && right.equals(another.right)
        && operator.equals(another.operator);
  }

  /**
   * Computes a hash code from attributes: {@code left}, {@code right}, {@code operator}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + left.hashCode();
    h += (h << 5) + right.hashCode();
    h += (h << 5) + operator.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code BinaryOp} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("BinaryOp")
        .omitNullValues()
        .add("left", left)
        .add("right", right)
        .add("operator", operator)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link BinaryOpIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable BinaryOp instance
   */
  public static BinaryOp copyOf(BinaryOpIF instance) {
    if (instance instanceof BinaryOp) {
      return (BinaryOp) instance;
    }
    return BinaryOp.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link BinaryOp BinaryOp}.
   * @return A new BinaryOp builder
   */
  public static BinaryOp.Builder builder() {
    return new BinaryOp.Builder();
  }

  /**
   * Builds instances of type {@link BinaryOp BinaryOp}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_LEFT = 0x1L;
    private static final long INIT_BIT_RIGHT = 0x2L;
    private static final long INIT_BIT_OPERATOR = 0x4L;
    private long initBits = 0x7L;

    private Expression left;
    private Expression right;
    private String operator;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code BinaryOpIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(BinaryOpIF instance) {
      Objects.requireNonNull(instance, "instance");
      setLeft(instance.getLeft());
      setRight(instance.getRight());
      setOperator(instance.getOperator());
      return this;
    }

    /**
     * Initializes the value for the {@link BinaryOpIF#getLeft() left} attribute.
     * @param left The value for left 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setLeft(Expression left) {
      this.left = Objects.requireNonNull(left, "left");
      initBits &= ~INIT_BIT_LEFT;
      return this;
    }

    /**
     * Initializes the value for the {@link BinaryOpIF#getRight() right} attribute.
     * @param right The value for right 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setRight(Expression right) {
      this.right = Objects.requireNonNull(right, "right");
      initBits &= ~INIT_BIT_RIGHT;
      return this;
    }

    /**
     * Initializes the value for the {@link BinaryOpIF#getOperator() operator} attribute.
     * @param operator The value for operator 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setOperator(String operator) {
      this.operator = Objects.requireNonNull(operator, "operator");
      initBits &= ~INIT_BIT_OPERATOR;
      return this;
    }

    /**
     * Builds a new {@link BinaryOp BinaryOp}.
     * @return An immutable instance of BinaryOp
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public BinaryOp build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new BinaryOp(left, right, operator);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_LEFT) != 0) attributes.add("left");
      if ((initBits & INIT_BIT_RIGHT) != 0) attributes.add("right");
      if ((initBits & INIT_BIT_OPERATOR) != 0) attributes.add("operator");
      return "Cannot build BinaryOp, some of required attributes are not set " + attributes;
    }
  }
}
