package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link IdentifierIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Identifier.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "IdentifierIF"})
public final class Identifier implements IdentifierIF {
  private final String identifier;

  private Identifier(String identifier) {
    this.identifier = identifier;
  }

  /**
   * @return The value of the {@code identifier} attribute
   */
  @Override
  public String getIdentifier() {
    return identifier;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link IdentifierIF#getIdentifier() identifier} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for identifier
   * @return A modified copy of the {@code this} object
   */
  public final Identifier withIdentifier(String value) {
    if (this.identifier.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "identifier");
    return new Identifier(newValue);
  }

  /**
   * This instance is equal to all instances of {@code Identifier} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof Identifier
        && equalTo((Identifier) another);
  }

  private boolean equalTo(Identifier another) {
    return identifier.equals(another.identifier);
  }

  /**
   * Computes a hash code from attributes: {@code identifier}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + identifier.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Identifier} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Identifier")
        .omitNullValues()
        .add("identifier", identifier)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link IdentifierIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Identifier instance
   */
  public static Identifier copyOf(IdentifierIF instance) {
    if (instance instanceof Identifier) {
      return (Identifier) instance;
    }
    return Identifier.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link Identifier Identifier}.
   * @return A new Identifier builder
   */
  public static Identifier.Builder builder() {
    return new Identifier.Builder();
  }

  /**
   * Builds instances of type {@link Identifier Identifier}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_IDENTIFIER = 0x1L;
    private long initBits = 0x1L;

    private String identifier;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code IdentifierIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(IdentifierIF instance) {
      Objects.requireNonNull(instance, "instance");
      setIdentifier(instance.getIdentifier());
      return this;
    }

    /**
     * Initializes the value for the {@link IdentifierIF#getIdentifier() identifier} attribute.
     * @param identifier The value for identifier 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setIdentifier(String identifier) {
      this.identifier = Objects.requireNonNull(identifier, "identifier");
      initBits &= ~INIT_BIT_IDENTIFIER;
      return this;
    }

    /**
     * Builds a new {@link Identifier Identifier}.
     * @return An immutable instance of Identifier
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Identifier build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new Identifier(identifier);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_IDENTIFIER) != 0) attributes.add("identifier");
      return "Cannot build Identifier, some of required attributes are not set " + attributes;
    }
  }
}
