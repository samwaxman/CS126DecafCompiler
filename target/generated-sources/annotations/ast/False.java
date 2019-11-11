package ast;

import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link FalseIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code False.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "FalseIF"})
public final class False implements FalseIF {

  private False(False.Builder builder) {
  }

  /**
   * This instance is equal to all instances of {@code False} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof False
        && equalTo((False) another);
  }

  private boolean equalTo(False another) {
    return true;
  }

  /**
   * Returns a constant hash code value.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    return 599778835;
  }

  /**
   * Prints the immutable value {@code False}.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "False{}";
  }

  /**
   * Creates an immutable copy of a {@link FalseIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable False instance
   */
  public static False copyOf(FalseIF instance) {
    if (instance instanceof False) {
      return (False) instance;
    }
    return False.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link False False}.
   * @return A new False builder
   */
  public static False.Builder builder() {
    return new False.Builder();
  }

  /**
   * Builds instances of type {@link False False}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code FalseIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(FalseIF instance) {
      Objects.requireNonNull(instance, "instance");
      return this;
    }

    /**
     * Builds a new {@link False False}.
     * @return An immutable instance of False
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public False build() {
      return new False(this);
    }
  }
}
