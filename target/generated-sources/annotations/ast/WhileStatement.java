package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link WhileStatementIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code WhileStatement.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "WhileStatementIF"})
public final class WhileStatement implements WhileStatementIF {
  private final Expression testExpression;
  private final Statement body;

  private WhileStatement(Expression testExpression, Statement body) {
    this.testExpression = testExpression;
    this.body = body;
  }

  /**
   * @return The value of the {@code testExpression} attribute
   */
  @Override
  public Expression getTestExpression() {
    return testExpression;
  }

  /**
   * @return The value of the {@code body} attribute
   */
  @Override
  public Statement getBody() {
    return body;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WhileStatementIF#getTestExpression() testExpression} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for testExpression
   * @return A modified copy of the {@code this} object
   */
  public final WhileStatement withTestExpression(Expression value) {
    if (this.testExpression == value) return this;
    Expression newValue = Objects.requireNonNull(value, "testExpression");
    return new WhileStatement(newValue, this.body);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WhileStatementIF#getBody() body} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for body
   * @return A modified copy of the {@code this} object
   */
  public final WhileStatement withBody(Statement value) {
    if (this.body == value) return this;
    Statement newValue = Objects.requireNonNull(value, "body");
    return new WhileStatement(this.testExpression, newValue);
  }

  /**
   * This instance is equal to all instances of {@code WhileStatement} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof WhileStatement
        && equalTo((WhileStatement) another);
  }

  private boolean equalTo(WhileStatement another) {
    return testExpression.equals(another.testExpression)
        && body.equals(another.body);
  }

  /**
   * Computes a hash code from attributes: {@code testExpression}, {@code body}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + testExpression.hashCode();
    h += (h << 5) + body.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code WhileStatement} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("WhileStatement")
        .omitNullValues()
        .add("testExpression", testExpression)
        .add("body", body)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link WhileStatementIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable WhileStatement instance
   */
  public static WhileStatement copyOf(WhileStatementIF instance) {
    if (instance instanceof WhileStatement) {
      return (WhileStatement) instance;
    }
    return WhileStatement.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link WhileStatement WhileStatement}.
   * @return A new WhileStatement builder
   */
  public static WhileStatement.Builder builder() {
    return new WhileStatement.Builder();
  }

  /**
   * Builds instances of type {@link WhileStatement WhileStatement}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_TEST_EXPRESSION = 0x1L;
    private static final long INIT_BIT_BODY = 0x2L;
    private long initBits = 0x3L;

    private Expression testExpression;
    private Statement body;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code WhileStatementIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(WhileStatementIF instance) {
      Objects.requireNonNull(instance, "instance");
      setTestExpression(instance.getTestExpression());
      setBody(instance.getBody());
      return this;
    }

    /**
     * Initializes the value for the {@link WhileStatementIF#getTestExpression() testExpression} attribute.
     * @param testExpression The value for testExpression 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setTestExpression(Expression testExpression) {
      this.testExpression = Objects.requireNonNull(testExpression, "testExpression");
      initBits &= ~INIT_BIT_TEST_EXPRESSION;
      return this;
    }

    /**
     * Initializes the value for the {@link WhileStatementIF#getBody() body} attribute.
     * @param body The value for body 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setBody(Statement body) {
      this.body = Objects.requireNonNull(body, "body");
      initBits &= ~INIT_BIT_BODY;
      return this;
    }

    /**
     * Builds a new {@link WhileStatement WhileStatement}.
     * @return An immutable instance of WhileStatement
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public WhileStatement build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new WhileStatement(testExpression, body);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_TEST_EXPRESSION) != 0) attributes.add("testExpression");
      if ((initBits & INIT_BIT_BODY) != 0) attributes.add("body");
      return "Cannot build WhileStatement, some of required attributes are not set " + attributes;
    }
  }
}
