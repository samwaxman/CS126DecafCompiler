package ast;

import com.google.common.base.MoreObjects;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link ReturnStatementIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ReturnStatement.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ReturnStatementIF"})
public final class ReturnStatement implements ReturnStatementIF {
  private final Expression returnExpression;

  private ReturnStatement(Expression returnExpression) {
    this.returnExpression = returnExpression;
  }

  /**
   * @return The value of the {@code returnExpression} attribute
   */
  @Override
  public Optional<Expression> getReturnExpression() {
    return Optional.ofNullable(returnExpression);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link ReturnStatementIF#getReturnExpression() returnExpression} attribute.
   * @param value The value for returnExpression
   * @return A modified copy of {@code this} object
   */
  public final ReturnStatement withReturnExpression(Expression value) {
    Expression newValue = Objects.requireNonNull(value, "returnExpression");
    if (this.returnExpression == newValue) return this;
    return new ReturnStatement(newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link ReturnStatementIF#getReturnExpression() returnExpression} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for returnExpression
   * @return A modified copy of {@code this} object
   */
  public final ReturnStatement withReturnExpression(Optional<? extends Expression> optional) {
    Expression value = optional.orElse(null);
    if (this.returnExpression == value) return this;
    return new ReturnStatement(value);
  }

  /**
   * This instance is equal to all instances of {@code ReturnStatement} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ReturnStatement
        && equalTo((ReturnStatement) another);
  }

  private boolean equalTo(ReturnStatement another) {
    return Objects.equals(returnExpression, another.returnExpression);
  }

  /**
   * Computes a hash code from attributes: {@code returnExpression}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Objects.hashCode(returnExpression);
    return h;
  }

  /**
   * Prints the immutable value {@code ReturnStatement} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ReturnStatement")
        .omitNullValues()
        .add("returnExpression", returnExpression)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ReturnStatementIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ReturnStatement instance
   */
  public static ReturnStatement copyOf(ReturnStatementIF instance) {
    if (instance instanceof ReturnStatement) {
      return (ReturnStatement) instance;
    }
    return ReturnStatement.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ReturnStatement ReturnStatement}.
   * @return A new ReturnStatement builder
   */
  public static ReturnStatement.Builder builder() {
    return new ReturnStatement.Builder();
  }

  /**
   * Builds instances of type {@link ReturnStatement ReturnStatement}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private Expression returnExpression;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ReturnStatementIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ReturnStatementIF instance) {
      Objects.requireNonNull(instance, "instance");
      Optional<Expression> returnExpressionOptional = instance.getReturnExpression();
      if (returnExpressionOptional.isPresent()) {
        setReturnExpression(returnExpressionOptional);
      }
      return this;
    }

    /**
     * Initializes the optional value {@link ReturnStatementIF#getReturnExpression() returnExpression} to returnExpression.
     * @param returnExpression The value for returnExpression
     * @return {@code this} builder for chained invocation
     */
    public final Builder setReturnExpression(Expression returnExpression) {
      this.returnExpression = Objects.requireNonNull(returnExpression, "returnExpression");
      return this;
    }

    /**
     * Initializes the optional value {@link ReturnStatementIF#getReturnExpression() returnExpression} to returnExpression.
     * @param returnExpression The value for returnExpression
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setReturnExpression(Optional<? extends Expression> returnExpression) {
      this.returnExpression = returnExpression.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ReturnStatement ReturnStatement}.
     * @return An immutable instance of ReturnStatement
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ReturnStatement build() {
      return new ReturnStatement(returnExpression);
    }
  }
}
