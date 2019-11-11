package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link IntegerLiteralIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code IntegerLiteral.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "IntegerLiteralIF"})
public final class IntegerLiteral implements IntegerLiteralIF {
  private final int getInt;

  private IntegerLiteral(int getInt) {
    this.getInt = getInt;
  }

  /**
   * @return The value of the {@code getInt} attribute
   */
  @Override
  public int getInt() {
    return getInt;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link IntegerLiteralIF#getInt() int} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for getInt
   * @return A modified copy of the {@code this} object
   */
  public final IntegerLiteral withInt(int value) {
    if (this.getInt == value) return this;
    return new IntegerLiteral(value);
  }

  /**
   * This instance is equal to all instances of {@code IntegerLiteral} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof IntegerLiteral
        && equalTo((IntegerLiteral) another);
  }

  private boolean equalTo(IntegerLiteral another) {
    return getInt == another.getInt;
  }

  /**
   * Computes a hash code from attributes: {@code getInt}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + getInt;
    return h;
  }

  /**
   * Prints the immutable value {@code IntegerLiteral} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("IntegerLiteral")
        .omitNullValues()
        .add("int", getInt)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link IntegerLiteralIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable IntegerLiteral instance
   */
  public static IntegerLiteral copyOf(IntegerLiteralIF instance) {
    if (instance instanceof IntegerLiteral) {
      return (IntegerLiteral) instance;
    }
    return IntegerLiteral.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link IntegerLiteral IntegerLiteral}.
   * @return A new IntegerLiteral builder
   */
  public static IntegerLiteral.Builder builder() {
    return new IntegerLiteral.Builder();
  }

  /**
   * Builds instances of type {@link IntegerLiteral IntegerLiteral}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_GET_INT = 0x1L;
    private long initBits = 0x1L;

    private int getInt;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code IntegerLiteralIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(IntegerLiteralIF instance) {
      Objects.requireNonNull(instance, "instance");
      setInt(instance.getInt());
      return this;
    }

    /**
     * Initializes the value for the {@link IntegerLiteralIF#getInt() int} attribute.
     * @param getInt The value for getInt 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setInt(int getInt) {
      this.getInt = getInt;
      initBits &= ~INIT_BIT_GET_INT;
      return this;
    }

    /**
     * Builds a new {@link IntegerLiteral IntegerLiteral}.
     * @return An immutable instance of IntegerLiteral
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public IntegerLiteral build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new IntegerLiteral(getInt);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_GET_INT) != 0) attributes.add("int");
      return "Cannot build IntegerLiteral, some of required attributes are not set " + attributes;
    }
  }
}
