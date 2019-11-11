package ast;

import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link NullIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Null.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "NullIF"})
public final class Null implements NullIF {

  private Null(Null.Builder builder) {
  }

  /**
   * This instance is equal to all instances of {@code Null} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof Null
        && equalTo((Null) another);
  }

  private boolean equalTo(Null another) {
    return true;
  }

  /**
   * Returns a constant hash code value.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    return 1236675087;
  }

  /**
   * Prints the immutable value {@code Null}.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Null{}";
  }

  /**
   * Creates an immutable copy of a {@link NullIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Null instance
   */
  public static Null copyOf(NullIF instance) {
    if (instance instanceof Null) {
      return (Null) instance;
    }
    return Null.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link Null Null}.
   * @return A new Null builder
   */
  public static Null.Builder builder() {
    return new Null.Builder();
  }

  /**
   * Builds instances of type {@link Null Null}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code NullIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(NullIF instance) {
      Objects.requireNonNull(instance, "instance");
      return this;
    }

    /**
     * Builds a new {@link Null Null}.
     * @return An immutable instance of Null
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Null build() {
      return new Null(this);
    }
  }
}
