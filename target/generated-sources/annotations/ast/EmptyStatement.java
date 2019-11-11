package ast;

import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link EmptyStatementIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code EmptyStatement.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "EmptyStatementIF"})
public final class EmptyStatement implements EmptyStatementIF {

  private EmptyStatement(EmptyStatement.Builder builder) {
  }

  /**
   * This instance is equal to all instances of {@code EmptyStatement} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof EmptyStatement
        && equalTo((EmptyStatement) another);
  }

  private boolean equalTo(EmptyStatement another) {
    return true;
  }

  /**
   * Returns a constant hash code value.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    return 613684586;
  }

  /**
   * Prints the immutable value {@code EmptyStatement}.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "EmptyStatement{}";
  }

  /**
   * Creates an immutable copy of a {@link EmptyStatementIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable EmptyStatement instance
   */
  public static EmptyStatement copyOf(EmptyStatementIF instance) {
    if (instance instanceof EmptyStatement) {
      return (EmptyStatement) instance;
    }
    return EmptyStatement.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link EmptyStatement EmptyStatement}.
   * @return A new EmptyStatement builder
   */
  public static EmptyStatement.Builder builder() {
    return new EmptyStatement.Builder();
  }

  /**
   * Builds instances of type {@link EmptyStatement EmptyStatement}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code EmptyStatementIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(EmptyStatementIF instance) {
      Objects.requireNonNull(instance, "instance");
      return this;
    }

    /**
     * Builds a new {@link EmptyStatement EmptyStatement}.
     * @return An immutable instance of EmptyStatement
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public EmptyStatement build() {
      return new EmptyStatement(this);
    }
  }
}
