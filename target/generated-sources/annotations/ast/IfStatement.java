package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link IfStatementIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code IfStatement.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "IfStatementIF"})
public final class IfStatement implements IfStatementIF {
  private final Expression condition;
  private final Statement consequence;
  private final Statement altern;

  private IfStatement(Expression condition, Statement consequence, Statement altern) {
    this.condition = condition;
    this.consequence = consequence;
    this.altern = altern;
  }

  /**
   * @return The value of the {@code condition} attribute
   */
  @Override
  public Expression getCondition() {
    return condition;
  }

  /**
   * @return The value of the {@code consequence} attribute
   */
  @Override
  public Statement getConsequence() {
    return consequence;
  }

  /**
   * @return The value of the {@code altern} attribute
   */
  @Override
  public Optional<Statement> getAltern() {
    return Optional.ofNullable(altern);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link IfStatementIF#getCondition() condition} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for condition
   * @return A modified copy of the {@code this} object
   */
  public final IfStatement withCondition(Expression value) {
    if (this.condition == value) return this;
    Expression newValue = Objects.requireNonNull(value, "condition");
    return new IfStatement(newValue, this.consequence, this.altern);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link IfStatementIF#getConsequence() consequence} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for consequence
   * @return A modified copy of the {@code this} object
   */
  public final IfStatement withConsequence(Statement value) {
    if (this.consequence == value) return this;
    Statement newValue = Objects.requireNonNull(value, "consequence");
    return new IfStatement(this.condition, newValue, this.altern);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link IfStatementIF#getAltern() altern} attribute.
   * @param value The value for altern
   * @return A modified copy of {@code this} object
   */
  public final IfStatement withAltern(Statement value) {
    Statement newValue = Objects.requireNonNull(value, "altern");
    if (this.altern == newValue) return this;
    return new IfStatement(this.condition, this.consequence, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link IfStatementIF#getAltern() altern} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for altern
   * @return A modified copy of {@code this} object
   */
  public final IfStatement withAltern(Optional<? extends Statement> optional) {
    Statement value = optional.orElse(null);
    if (this.altern == value) return this;
    return new IfStatement(this.condition, this.consequence, value);
  }

  /**
   * This instance is equal to all instances of {@code IfStatement} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof IfStatement
        && equalTo((IfStatement) another);
  }

  private boolean equalTo(IfStatement another) {
    return condition.equals(another.condition)
        && consequence.equals(another.consequence)
        && Objects.equals(altern, another.altern);
  }

  /**
   * Computes a hash code from attributes: {@code condition}, {@code consequence}, {@code altern}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + condition.hashCode();
    h += (h << 5) + consequence.hashCode();
    h += (h << 5) + Objects.hashCode(altern);
    return h;
  }

  /**
   * Prints the immutable value {@code IfStatement} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("IfStatement")
        .omitNullValues()
        .add("condition", condition)
        .add("consequence", consequence)
        .add("altern", altern)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link IfStatementIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable IfStatement instance
   */
  public static IfStatement copyOf(IfStatementIF instance) {
    if (instance instanceof IfStatement) {
      return (IfStatement) instance;
    }
    return IfStatement.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link IfStatement IfStatement}.
   * @return A new IfStatement builder
   */
  public static IfStatement.Builder builder() {
    return new IfStatement.Builder();
  }

  /**
   * Builds instances of type {@link IfStatement IfStatement}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_CONDITION = 0x1L;
    private static final long INIT_BIT_CONSEQUENCE = 0x2L;
    private long initBits = 0x3L;

    private Expression condition;
    private Statement consequence;
    private Statement altern;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code IfStatementIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(IfStatementIF instance) {
      Objects.requireNonNull(instance, "instance");
      setCondition(instance.getCondition());
      setConsequence(instance.getConsequence());
      Optional<Statement> alternOptional = instance.getAltern();
      if (alternOptional.isPresent()) {
        setAltern(alternOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link IfStatementIF#getCondition() condition} attribute.
     * @param condition The value for condition 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setCondition(Expression condition) {
      this.condition = Objects.requireNonNull(condition, "condition");
      initBits &= ~INIT_BIT_CONDITION;
      return this;
    }

    /**
     * Initializes the value for the {@link IfStatementIF#getConsequence() consequence} attribute.
     * @param consequence The value for consequence 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setConsequence(Statement consequence) {
      this.consequence = Objects.requireNonNull(consequence, "consequence");
      initBits &= ~INIT_BIT_CONSEQUENCE;
      return this;
    }

    /**
     * Initializes the optional value {@link IfStatementIF#getAltern() altern} to altern.
     * @param altern The value for altern
     * @return {@code this} builder for chained invocation
     */
    public final Builder setAltern(Statement altern) {
      this.altern = Objects.requireNonNull(altern, "altern");
      return this;
    }

    /**
     * Initializes the optional value {@link IfStatementIF#getAltern() altern} to altern.
     * @param altern The value for altern
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setAltern(Optional<? extends Statement> altern) {
      this.altern = altern.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link IfStatement IfStatement}.
     * @return An immutable instance of IfStatement
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public IfStatement build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new IfStatement(condition, consequence, altern);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CONDITION) != 0) attributes.add("condition");
      if ((initBits & INIT_BIT_CONSEQUENCE) != 0) attributes.add("consequence");
      return "Cannot build IfStatement, some of required attributes are not set " + attributes;
    }
  }
}
