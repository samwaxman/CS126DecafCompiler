package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link VariableDeclarationStatementIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code VariableDeclarationStatement.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "VariableDeclarationStatementIF"})
public final class VariableDeclarationStatement implements VariableDeclarationStatementIF {
  private final Param var;
  private final Expression initialVal;

  private VariableDeclarationStatement(Param var, Expression initialVal) {
    this.var = var;
    this.initialVal = initialVal;
  }

  /**
   * @return The value of the {@code var} attribute
   */
  @Override
  public Param getVar() {
    return var;
  }

  /**
   * @return The value of the {@code initialVal} attribute
   */
  @Override
  public Optional<Expression> getInitialVal() {
    return Optional.ofNullable(initialVal);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link VariableDeclarationStatementIF#getVar() var} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for var
   * @return A modified copy of the {@code this} object
   */
  public final VariableDeclarationStatement withVar(Param value) {
    if (this.var == value) return this;
    Param newValue = Objects.requireNonNull(value, "var");
    return new VariableDeclarationStatement(newValue, this.initialVal);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link VariableDeclarationStatementIF#getInitialVal() initialVal} attribute.
   * @param value The value for initialVal
   * @return A modified copy of {@code this} object
   */
  public final VariableDeclarationStatement withInitialVal(Expression value) {
    Expression newValue = Objects.requireNonNull(value, "initialVal");
    if (this.initialVal == newValue) return this;
    return new VariableDeclarationStatement(this.var, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link VariableDeclarationStatementIF#getInitialVal() initialVal} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for initialVal
   * @return A modified copy of {@code this} object
   */
  public final VariableDeclarationStatement withInitialVal(Optional<? extends Expression> optional) {
    Expression value = optional.orElse(null);
    if (this.initialVal == value) return this;
    return new VariableDeclarationStatement(this.var, value);
  }

  /**
   * This instance is equal to all instances of {@code VariableDeclarationStatement} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof VariableDeclarationStatement
        && equalTo((VariableDeclarationStatement) another);
  }

  private boolean equalTo(VariableDeclarationStatement another) {
    return var.equals(another.var)
        && Objects.equals(initialVal, another.initialVal);
  }

  /**
   * Computes a hash code from attributes: {@code var}, {@code initialVal}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + var.hashCode();
    h += (h << 5) + Objects.hashCode(initialVal);
    return h;
  }

  /**
   * Prints the immutable value {@code VariableDeclarationStatement} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("VariableDeclarationStatement")
        .omitNullValues()
        .add("var", var)
        .add("initialVal", initialVal)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link VariableDeclarationStatementIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable VariableDeclarationStatement instance
   */
  public static VariableDeclarationStatement copyOf(VariableDeclarationStatementIF instance) {
    if (instance instanceof VariableDeclarationStatement) {
      return (VariableDeclarationStatement) instance;
    }
    return VariableDeclarationStatement.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link VariableDeclarationStatement VariableDeclarationStatement}.
   * @return A new VariableDeclarationStatement builder
   */
  public static VariableDeclarationStatement.Builder builder() {
    return new VariableDeclarationStatement.Builder();
  }

  /**
   * Builds instances of type {@link VariableDeclarationStatement VariableDeclarationStatement}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_VAR = 0x1L;
    private long initBits = 0x1L;

    private Param var;
    private Expression initialVal;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code VariableDeclarationStatementIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(VariableDeclarationStatementIF instance) {
      Objects.requireNonNull(instance, "instance");
      setVar(instance.getVar());
      Optional<Expression> initialValOptional = instance.getInitialVal();
      if (initialValOptional.isPresent()) {
        setInitialVal(initialValOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link VariableDeclarationStatementIF#getVar() var} attribute.
     * @param var The value for var 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setVar(Param var) {
      this.var = Objects.requireNonNull(var, "var");
      initBits &= ~INIT_BIT_VAR;
      return this;
    }

    /**
     * Initializes the optional value {@link VariableDeclarationStatementIF#getInitialVal() initialVal} to initialVal.
     * @param initialVal The value for initialVal
     * @return {@code this} builder for chained invocation
     */
    public final Builder setInitialVal(Expression initialVal) {
      this.initialVal = Objects.requireNonNull(initialVal, "initialVal");
      return this;
    }

    /**
     * Initializes the optional value {@link VariableDeclarationStatementIF#getInitialVal() initialVal} to initialVal.
     * @param initialVal The value for initialVal
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setInitialVal(Optional<? extends Expression> initialVal) {
      this.initialVal = initialVal.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link VariableDeclarationStatement VariableDeclarationStatement}.
     * @return An immutable instance of VariableDeclarationStatement
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public VariableDeclarationStatement build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new VariableDeclarationStatement(var, initialVal);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_VAR) != 0) attributes.add("var");
      return "Cannot build VariableDeclarationStatement, some of required attributes are not set " + attributes;
    }
  }
}
