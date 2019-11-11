package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link UnaryOpIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code UnaryOp.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "UnaryOpIF"})
public final class UnaryOp implements UnaryOpIF {
  private final Expression expression;
  private final String operator;

  private UnaryOp(Expression expression, String operator) {
    this.expression = expression;
    this.operator = operator;
  }

  /**
   * @return The value of the {@code expression} attribute
   */
  @Override
  public Expression getExpression() {
    return expression;
  }

  /**
   * @return The value of the {@code operator} attribute
   */
  @Override
  public String getOperator() {
    return operator;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UnaryOpIF#getExpression() expression} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for expression
   * @return A modified copy of the {@code this} object
   */
  public final UnaryOp withExpression(Expression value) {
    if (this.expression == value) return this;
    Expression newValue = Objects.requireNonNull(value, "expression");
    return new UnaryOp(newValue, this.operator);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link UnaryOpIF#getOperator() operator} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for operator
   * @return A modified copy of the {@code this} object
   */
  public final UnaryOp withOperator(String value) {
    if (this.operator.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "operator");
    return new UnaryOp(this.expression, newValue);
  }

  /**
   * This instance is equal to all instances of {@code UnaryOp} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof UnaryOp
        && equalTo((UnaryOp) another);
  }

  private boolean equalTo(UnaryOp another) {
    return expression.equals(another.expression)
        && operator.equals(another.operator);
  }

  /**
   * Computes a hash code from attributes: {@code expression}, {@code operator}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + expression.hashCode();
    h += (h << 5) + operator.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code UnaryOp} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("UnaryOp")
        .omitNullValues()
        .add("expression", expression)
        .add("operator", operator)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link UnaryOpIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable UnaryOp instance
   */
  public static UnaryOp copyOf(UnaryOpIF instance) {
    if (instance instanceof UnaryOp) {
      return (UnaryOp) instance;
    }
    return UnaryOp.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link UnaryOp UnaryOp}.
   * @return A new UnaryOp builder
   */
  public static UnaryOp.Builder builder() {
    return new UnaryOp.Builder();
  }

  /**
   * Builds instances of type {@link UnaryOp UnaryOp}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_EXPRESSION = 0x1L;
    private static final long INIT_BIT_OPERATOR = 0x2L;
    private long initBits = 0x3L;

    private Expression expression;
    private String operator;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code UnaryOpIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(UnaryOpIF instance) {
      Objects.requireNonNull(instance, "instance");
      setExpression(instance.getExpression());
      setOperator(instance.getOperator());
      return this;
    }

    /**
     * Initializes the value for the {@link UnaryOpIF#getExpression() expression} attribute.
     * @param expression The value for expression 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setExpression(Expression expression) {
      this.expression = Objects.requireNonNull(expression, "expression");
      initBits &= ~INIT_BIT_EXPRESSION;
      return this;
    }

    /**
     * Initializes the value for the {@link UnaryOpIF#getOperator() operator} attribute.
     * @param operator The value for operator 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setOperator(String operator) {
      this.operator = Objects.requireNonNull(operator, "operator");
      initBits &= ~INIT_BIT_OPERATOR;
      return this;
    }

    /**
     * Builds a new {@link UnaryOp UnaryOp}.
     * @return An immutable instance of UnaryOp
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public UnaryOp build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new UnaryOp(expression, operator);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_EXPRESSION) != 0) attributes.add("expression");
      if ((initBits & INIT_BIT_OPERATOR) != 0) attributes.add("operator");
      return "Cannot build UnaryOp, some of required attributes are not set " + attributes;
    }
  }
}
