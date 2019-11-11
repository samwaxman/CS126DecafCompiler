package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link TypeIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Type.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "TypeIF"})
public final class Type implements TypeIF {
  private final String typeIdentifier;
  private final int arrayLevel;

  private Type(Type.Builder builder) {
    this.typeIdentifier = builder.typeIdentifier;
    this.arrayLevel = builder.arrayLevelIsSet()
        ? builder.arrayLevel
        : TypeIF.super.getArrayLevel();
  }

  private Type(String typeIdentifier, int arrayLevel) {
    this.typeIdentifier = typeIdentifier;
    this.arrayLevel = arrayLevel;
  }

  /**
   * @return The value of the {@code typeIdentifier} attribute
   */
  @Override
  public String getTypeIdentifier() {
    return typeIdentifier;
  }

  /**
   * @return The value of the {@code arrayLevel} attribute
   */
  @Override
  public int getArrayLevel() {
    return arrayLevel;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link TypeIF#getTypeIdentifier() typeIdentifier} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for typeIdentifier
   * @return A modified copy of the {@code this} object
   */
  public final Type withTypeIdentifier(String value) {
    if (this.typeIdentifier.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "typeIdentifier");
    return new Type(newValue, this.arrayLevel);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link TypeIF#getArrayLevel() arrayLevel} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for arrayLevel
   * @return A modified copy of the {@code this} object
   */
  public final Type withArrayLevel(int value) {
    if (this.arrayLevel == value) return this;
    return new Type(this.typeIdentifier, value);
  }

  /**
   * This instance is equal to all instances of {@code Type} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof Type
        && equalTo((Type) another);
  }

  private boolean equalTo(Type another) {
    return typeIdentifier.equals(another.typeIdentifier)
        && arrayLevel == another.arrayLevel;
  }

  /**
   * Computes a hash code from attributes: {@code typeIdentifier}, {@code arrayLevel}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + typeIdentifier.hashCode();
    h += (h << 5) + arrayLevel;
    return h;
  }

  /**
   * Prints the immutable value {@code Type} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Type")
        .omitNullValues()
        .add("typeIdentifier", typeIdentifier)
        .add("arrayLevel", arrayLevel)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link TypeIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Type instance
   */
  public static Type copyOf(TypeIF instance) {
    if (instance instanceof Type) {
      return (Type) instance;
    }
    return Type.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link Type Type}.
   * @return A new Type builder
   */
  public static Type.Builder builder() {
    return new Type.Builder();
  }

  /**
   * Builds instances of type {@link Type Type}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_TYPE_IDENTIFIER = 0x1L;
    private static final long OPT_BIT_ARRAY_LEVEL = 0x1L;
    private long initBits = 0x1L;
    private long optBits;

    private String typeIdentifier;
    private int arrayLevel;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code TypeIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(TypeIF instance) {
      Objects.requireNonNull(instance, "instance");
      setTypeIdentifier(instance.getTypeIdentifier());
      setArrayLevel(instance.getArrayLevel());
      return this;
    }

    /**
     * Initializes the value for the {@link TypeIF#getTypeIdentifier() typeIdentifier} attribute.
     * @param typeIdentifier The value for typeIdentifier 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setTypeIdentifier(String typeIdentifier) {
      this.typeIdentifier = Objects.requireNonNull(typeIdentifier, "typeIdentifier");
      initBits &= ~INIT_BIT_TYPE_IDENTIFIER;
      return this;
    }

    /**
     * Initializes the value for the {@link TypeIF#getArrayLevel() arrayLevel} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link TypeIF#getArrayLevel() arrayLevel}.</em>
     * @param arrayLevel The value for arrayLevel 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setArrayLevel(int arrayLevel) {
      this.arrayLevel = arrayLevel;
      optBits |= OPT_BIT_ARRAY_LEVEL;
      return this;
    }

    /**
     * Builds a new {@link Type Type}.
     * @return An immutable instance of Type
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Type build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new Type(this);
    }

    private boolean arrayLevelIsSet() {
      return (optBits & OPT_BIT_ARRAY_LEVEL) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_TYPE_IDENTIFIER) != 0) attributes.add("typeIdentifier");
      return "Cannot build Type, some of required attributes are not set " + attributes;
    }
  }
}
