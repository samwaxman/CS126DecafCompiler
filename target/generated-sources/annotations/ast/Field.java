package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link FieldIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Field.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "FieldIF"})
public final class Field implements FieldIF {
  private final Param param;
  private final ImmutableList<Modifier> modifiers;

  private Field(Param param, ImmutableList<Modifier> modifiers) {
    this.param = param;
    this.modifiers = modifiers;
  }

  /**
   * @return The value of the {@code param} attribute
   */
  @Override
  public Param getParam() {
    return param;
  }

  /**
   * @return The value of the {@code modifiers} attribute
   */
  @Override
  public ImmutableList<Modifier> getModifiers() {
    return modifiers;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldIF#getParam() param} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for param
   * @return A modified copy of the {@code this} object
   */
  public final Field withParam(Param value) {
    if (this.param == value) return this;
    Param newValue = Objects.requireNonNull(value, "param");
    return new Field(newValue, this.modifiers);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link FieldIF#getModifiers() modifiers}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final Field withModifiers(Modifier... elements) {
    ImmutableList<Modifier> newValue = ImmutableList.copyOf(elements);
    return new Field(this.param, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link FieldIF#getModifiers() modifiers}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of modifiers elements to set
   * @return A modified copy of {@code this} object
   */
  public final Field withModifiers(Iterable<? extends Modifier> elements) {
    if (this.modifiers == elements) return this;
    ImmutableList<Modifier> newValue = ImmutableList.copyOf(elements);
    return new Field(this.param, newValue);
  }

  /**
   * This instance is equal to all instances of {@code Field} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof Field
        && equalTo((Field) another);
  }

  private boolean equalTo(Field another) {
    return param.equals(another.param)
        && modifiers.equals(another.modifiers);
  }

  /**
   * Computes a hash code from attributes: {@code param}, {@code modifiers}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + param.hashCode();
    h += (h << 5) + modifiers.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Field} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Field")
        .omitNullValues()
        .add("param", param)
        .add("modifiers", modifiers)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link FieldIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Field instance
   */
  public static Field copyOf(FieldIF instance) {
    if (instance instanceof Field) {
      return (Field) instance;
    }
    return Field.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link Field Field}.
   * @return A new Field builder
   */
  public static Field.Builder builder() {
    return new Field.Builder();
  }

  /**
   * Builds instances of type {@link Field Field}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_PARAM = 0x1L;
    private long initBits = 0x1L;

    private Param param;
    private ImmutableList.Builder<Modifier> modifiers = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code FieldIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(FieldIF instance) {
      Objects.requireNonNull(instance, "instance");
      setParam(instance.getParam());
      addAllModifiers(instance.getModifiers());
      return this;
    }

    /**
     * Initializes the value for the {@link FieldIF#getParam() param} attribute.
     * @param param The value for param 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setParam(Param param) {
      this.param = Objects.requireNonNull(param, "param");
      initBits &= ~INIT_BIT_PARAM;
      return this;
    }

    /**
     * Adds one element to {@link FieldIF#getModifiers() modifiers} list.
     * @param element A modifiers element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addModifiers(Modifier element) {
      this.modifiers.add(element);
      return this;
    }

    /**
     * Adds elements to {@link FieldIF#getModifiers() modifiers} list.
     * @param elements An array of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addModifiers(Modifier... elements) {
      this.modifiers.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link FieldIF#getModifiers() modifiers} list.
     * @param elements An iterable of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setModifiers(Iterable<? extends Modifier> elements) {
      this.modifiers = ImmutableList.builder();
      return addAllModifiers(elements);
    }

    /**
     * Adds elements to {@link FieldIF#getModifiers() modifiers} list.
     * @param elements An iterable of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllModifiers(Iterable<? extends Modifier> elements) {
      this.modifiers.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link Field Field}.
     * @return An immutable instance of Field
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Field build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new Field(param, modifiers.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_PARAM) != 0) attributes.add("param");
      return "Cannot build Field, some of required attributes are not set " + attributes;
    }
  }
}
