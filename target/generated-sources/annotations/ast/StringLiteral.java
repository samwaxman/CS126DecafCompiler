package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link StringLiteralIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code StringLiteral.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "StringLiteralIF"})
public final class StringLiteral implements StringLiteralIF {
  private final String string;

  private StringLiteral(String string) {
    this.string = string;
  }

  /**
   * @return The value of the {@code string} attribute
   */
  @Override
  public String getString() {
    return string;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StringLiteralIF#getString() string} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for string
   * @return A modified copy of the {@code this} object
   */
  public final StringLiteral withString(String value) {
    if (this.string.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "string");
    return new StringLiteral(newValue);
  }

  /**
   * This instance is equal to all instances of {@code StringLiteral} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof StringLiteral
        && equalTo((StringLiteral) another);
  }

  private boolean equalTo(StringLiteral another) {
    return string.equals(another.string);
  }

  /**
   * Computes a hash code from attributes: {@code string}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + string.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code StringLiteral} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("StringLiteral")
        .omitNullValues()
        .add("string", string)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link StringLiteralIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable StringLiteral instance
   */
  public static StringLiteral copyOf(StringLiteralIF instance) {
    if (instance instanceof StringLiteral) {
      return (StringLiteral) instance;
    }
    return StringLiteral.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link StringLiteral StringLiteral}.
   * @return A new StringLiteral builder
   */
  public static StringLiteral.Builder builder() {
    return new StringLiteral.Builder();
  }

  /**
   * Builds instances of type {@link StringLiteral StringLiteral}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_STRING = 0x1L;
    private long initBits = 0x1L;

    private String string;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code StringLiteralIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(StringLiteralIF instance) {
      Objects.requireNonNull(instance, "instance");
      setString(instance.getString());
      return this;
    }

    /**
     * Initializes the value for the {@link StringLiteralIF#getString() string} attribute.
     * @param string The value for string 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setString(String string) {
      this.string = Objects.requireNonNull(string, "string");
      initBits &= ~INIT_BIT_STRING;
      return this;
    }

    /**
     * Builds a new {@link StringLiteral StringLiteral}.
     * @return An immutable instance of StringLiteral
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public StringLiteral build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new StringLiteral(string);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_STRING) != 0) attributes.add("string");
      return "Cannot build StringLiteral, some of required attributes are not set " + attributes;
    }
  }
}
