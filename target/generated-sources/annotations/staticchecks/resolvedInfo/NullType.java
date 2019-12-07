package staticchecks.resolvedInfo;

import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link NullTypeIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code NullType.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "NullTypeIF"})
public final class NullType implements NullTypeIF {

  private NullType(NullType.Builder builder) {
  }

  /**
   * This instance is equal to all instances of {@code NullType} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof NullType
        && equalTo((NullType) another);
  }

  private boolean equalTo(NullType another) {
    return true;
  }

  /**
   * Returns a constant hash code value.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    return -686105072;
  }

  /**
   * Prints the immutable value {@code NullType}.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "NullType{}";
  }

  /**
   * Creates an immutable copy of a {@link NullTypeIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable NullType instance
   */
  public static NullType copyOf(NullTypeIF instance) {
    if (instance instanceof NullType) {
      return (NullType) instance;
    }
    return NullType.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link NullType NullType}.
   * @return A new NullType builder
   */
  public static NullType.Builder builder() {
    return new NullType.Builder();
  }

  /**
   * Builds instances of type {@link NullType NullType}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code NullTypeIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(NullTypeIF instance) {
      Objects.requireNonNull(instance, "instance");
      return this;
    }

    /**
     * Builds a new {@link NullType NullType}.
     * @return An immutable instance of NullType
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public NullType build() {
      return new NullType(this);
    }
  }
}
