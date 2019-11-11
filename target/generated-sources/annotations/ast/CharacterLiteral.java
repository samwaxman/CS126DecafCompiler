package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link CharacterLiteralIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code CharacterLiteral.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "CharacterLiteralIF"})
public final class CharacterLiteral implements CharacterLiteralIF {
  private final String character;

  private CharacterLiteral(String character) {
    this.character = character;
  }

  /**
   * @return The value of the {@code character} attribute
   */
  @Override
  public String getCharacter() {
    return character;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CharacterLiteralIF#getCharacter() character} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for character
   * @return A modified copy of the {@code this} object
   */
  public final CharacterLiteral withCharacter(String value) {
    if (this.character.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "character");
    return new CharacterLiteral(newValue);
  }

  /**
   * This instance is equal to all instances of {@code CharacterLiteral} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof CharacterLiteral
        && equalTo((CharacterLiteral) another);
  }

  private boolean equalTo(CharacterLiteral another) {
    return character.equals(another.character);
  }

  /**
   * Computes a hash code from attributes: {@code character}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + character.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code CharacterLiteral} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("CharacterLiteral")
        .omitNullValues()
        .add("character", character)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link CharacterLiteralIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CharacterLiteral instance
   */
  public static CharacterLiteral copyOf(CharacterLiteralIF instance) {
    if (instance instanceof CharacterLiteral) {
      return (CharacterLiteral) instance;
    }
    return CharacterLiteral.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link CharacterLiteral CharacterLiteral}.
   * @return A new CharacterLiteral builder
   */
  public static CharacterLiteral.Builder builder() {
    return new CharacterLiteral.Builder();
  }

  /**
   * Builds instances of type {@link CharacterLiteral CharacterLiteral}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_CHARACTER = 0x1L;
    private long initBits = 0x1L;

    private String character;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code CharacterLiteralIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CharacterLiteralIF instance) {
      Objects.requireNonNull(instance, "instance");
      setCharacter(instance.getCharacter());
      return this;
    }

    /**
     * Initializes the value for the {@link CharacterLiteralIF#getCharacter() character} attribute.
     * @param character The value for character 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setCharacter(String character) {
      this.character = Objects.requireNonNull(character, "character");
      initBits &= ~INIT_BIT_CHARACTER;
      return this;
    }

    /**
     * Builds a new {@link CharacterLiteral CharacterLiteral}.
     * @return An immutable instance of CharacterLiteral
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public CharacterLiteral build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new CharacterLiteral(character);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CHARACTER) != 0) attributes.add("character");
      return "Cannot build CharacterLiteral, some of required attributes are not set " + attributes;
    }
  }
}
