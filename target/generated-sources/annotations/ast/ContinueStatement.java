package ast;

import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link ContinueStatementIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ContinueStatement.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ContinueStatementIF"})
public final class ContinueStatement implements ContinueStatementIF {

  private ContinueStatement(ContinueStatement.Builder builder) {
  }

  /**
   * This instance is equal to all instances of {@code ContinueStatement} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ContinueStatement
        && equalTo((ContinueStatement) another);
  }

  private boolean equalTo(ContinueStatement another) {
    return true;
  }

  /**
   * Returns a constant hash code value.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    return -1771052488;
  }

  /**
   * Prints the immutable value {@code ContinueStatement}.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "ContinueStatement{}";
  }

  /**
   * Creates an immutable copy of a {@link ContinueStatementIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ContinueStatement instance
   */
  public static ContinueStatement copyOf(ContinueStatementIF instance) {
    if (instance instanceof ContinueStatement) {
      return (ContinueStatement) instance;
    }
    return ContinueStatement.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ContinueStatement ContinueStatement}.
   * @return A new ContinueStatement builder
   */
  public static ContinueStatement.Builder builder() {
    return new ContinueStatement.Builder();
  }

  /**
   * Builds instances of type {@link ContinueStatement ContinueStatement}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ContinueStatementIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ContinueStatementIF instance) {
      Objects.requireNonNull(instance, "instance");
      return this;
    }

    /**
     * Builds a new {@link ContinueStatement ContinueStatement}.
     * @return An immutable instance of ContinueStatement
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ContinueStatement build() {
      return new ContinueStatement(this);
    }
  }
}
