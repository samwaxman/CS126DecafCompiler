package ast;

import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link TrueIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code True.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "TrueIF"})
public final class True implements TrueIF {

  private True(True.Builder builder) {
  }

  /**
   * This instance is equal to all instances of {@code True} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof True
        && equalTo((True) another);
  }

  private boolean equalTo(True another) {
    return true;
  }

  /**
   * Returns a constant hash code value.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    return 1405940822;
  }

  /**
   * Prints the immutable value {@code True}.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "True{}";
  }

  /**
   * Creates an immutable copy of a {@link TrueIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable True instance
   */
  public static True copyOf(TrueIF instance) {
    if (instance instanceof True) {
      return (True) instance;
    }
    return True.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link True True}.
   * @return A new True builder
   */
  public static True.Builder builder() {
    return new True.Builder();
  }

  /**
   * Builds instances of type {@link True True}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code TrueIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(TrueIF instance) {
      Objects.requireNonNull(instance, "instance");
      return this;
    }

    /**
     * Builds a new {@link True True}.
     * @return An immutable instance of True
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public True build() {
      return new True(this);
    }
  }
}
