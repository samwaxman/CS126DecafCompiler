package staticchecks.resolvedInfo;

import ast.Modifier;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link ResolvedFieldIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ResolvedField.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ResolvedFieldIF"})
public final class ResolvedField implements ResolvedFieldIF {
  private final ResolvedType type;
  private final ImmutableSet<Modifier> modifiers;

  private ResolvedField(
      ResolvedType type,
      ImmutableSet<Modifier> modifiers) {
    this.type = type;
    this.modifiers = modifiers;
  }

  /**
   * @return The value of the {@code type} attribute
   */
  @Override
  public ResolvedType getType() {
    return type;
  }

  /**
   * @return The value of the {@code modifiers} attribute
   */
  @Override
  public ImmutableSet<Modifier> getModifiers() {
    return modifiers;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ResolvedFieldIF#getType() type} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ResolvedField withType(ResolvedType value) {
    if (this.type == value) return this;
    ResolvedType newValue = Objects.requireNonNull(value, "type");
    return new ResolvedField(newValue, this.modifiers);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ResolvedFieldIF#getModifiers() modifiers}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ResolvedField withModifiers(Modifier... elements) {
    ImmutableSet<Modifier> newValue = Sets.immutableEnumSet(Arrays.asList(elements));
    return new ResolvedField(this.type, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ResolvedFieldIF#getModifiers() modifiers}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of modifiers elements to set
   * @return A modified copy of {@code this} object
   */
  public final ResolvedField withModifiers(Iterable<Modifier> elements) {
    if (this.modifiers == elements) return this;
    ImmutableSet<Modifier> newValue = Sets.immutableEnumSet(elements);
    return new ResolvedField(this.type, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ResolvedField} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ResolvedField
        && equalTo((ResolvedField) another);
  }

  private boolean equalTo(ResolvedField another) {
    return type.equals(another.type)
        && modifiers.equals(another.modifiers);
  }

  /**
   * Computes a hash code from attributes: {@code type}, {@code modifiers}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + type.hashCode();
    h += (h << 5) + modifiers.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ResolvedField} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ResolvedField")
        .omitNullValues()
        .add("type", type)
        .add("modifiers", modifiers)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ResolvedFieldIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ResolvedField instance
   */
  public static ResolvedField copyOf(ResolvedFieldIF instance) {
    if (instance instanceof ResolvedField) {
      return (ResolvedField) instance;
    }
    return ResolvedField.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ResolvedField ResolvedField}.
   * @return A new ResolvedField builder
   */
  public static ResolvedField.Builder builder() {
    return new ResolvedField.Builder();
  }

  /**
   * Builds instances of type {@link ResolvedField ResolvedField}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_TYPE = 0x1L;
    private long initBits = 0x1L;

    private ResolvedType type;
    private ImmutableSet.Builder<Modifier> modifiers = ImmutableSet.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ResolvedFieldIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ResolvedFieldIF instance) {
      Objects.requireNonNull(instance, "instance");
      setType(instance.getType());
      addAllModifiers(instance.getModifiers());
      return this;
    }

    /**
     * Initializes the value for the {@link ResolvedFieldIF#getType() type} attribute.
     * @param type The value for type 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setType(ResolvedType type) {
      this.type = Objects.requireNonNull(type, "type");
      initBits &= ~INIT_BIT_TYPE;
      return this;
    }

    /**
     * Adds one element to {@link ResolvedFieldIF#getModifiers() modifiers} set.
     * @param element A modifiers element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addModifiers(Modifier element) {
      this.modifiers.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ResolvedFieldIF#getModifiers() modifiers} set.
     * @param elements An array of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addModifiers(Modifier... elements) {
      this.modifiers.addAll(Arrays.asList(elements));
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ResolvedFieldIF#getModifiers() modifiers} set.
     * @param elements An iterable of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setModifiers(Iterable<Modifier> elements) {
      this.modifiers = ImmutableSet.builder();
      return addAllModifiers(elements);
    }

    /**
     * Adds elements to {@link ResolvedFieldIF#getModifiers() modifiers} set.
     * @param elements An iterable of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllModifiers(Iterable<Modifier> elements) {
      this.modifiers.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ResolvedField ResolvedField}.
     * @return An immutable instance of ResolvedField
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ResolvedField build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ResolvedField(type, Sets.immutableEnumSet(modifiers.build()));
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      return "Cannot build ResolvedField, some of required attributes are not set " + attributes;
    }
  }
}
