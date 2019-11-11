package ast;

import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link BreakStatementIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code BreakStatement.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "BreakStatementIF"})
public final class BreakStatement implements BreakStatementIF {

  private BreakStatement(BreakStatement.Builder builder) {
  }

  /**
   * This instance is equal to all instances of {@code BreakStatement} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof BreakStatement
        && equalTo((BreakStatement) another);
  }

  private boolean equalTo(BreakStatement another) {
    return true;
  }

  /**
   * Returns a constant hash code value.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    return 1831820920;
  }

  /**
   * Prints the immutable value {@code BreakStatement}.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "BreakStatement{}";
  }

  /**
   * Creates an immutable copy of a {@link BreakStatementIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable BreakStatement instance
   */
  public static BreakStatement copyOf(BreakStatementIF instance) {
    if (instance instanceof BreakStatement) {
      return (BreakStatement) instance;
    }
    return BreakStatement.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link BreakStatement BreakStatement}.
   * @return A new BreakStatement builder
   */
  public static BreakStatement.Builder builder() {
    return new BreakStatement.Builder();
  }

  /**
   * Builds instances of type {@link BreakStatement BreakStatement}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code BreakStatementIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(BreakStatementIF instance) {
      Objects.requireNonNull(instance, "instance");
      return this;
    }

    /**
     * Builds a new {@link BreakStatement BreakStatement}.
     * @return An immutable instance of BreakStatement
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public BreakStatement build() {
      return new BreakStatement(this);
    }
  }
}
