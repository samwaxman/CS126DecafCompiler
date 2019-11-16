package ast;

import astPojos.BlockStatement;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link ConstructorIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Constructor.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ConstructorIF"})
public final class Constructor implements ConstructorIF {
  private final ImmutableList<Modifier> modifiers;
  private final ImmutableList<Param> params;
  private final BlockStatement body;

  private Constructor(
      ImmutableList<Modifier> modifiers,
      ImmutableList<Param> params,
      BlockStatement body) {
    this.modifiers = modifiers;
    this.params = params;
    this.body = body;
  }

  /**
   * @return The value of the {@code modifiers} attribute
   */
  @Override
  public ImmutableList<Modifier> getModifiers() {
    return modifiers;
  }

  /**
   * @return The value of the {@code params} attribute
   */
  @Override
  public ImmutableList<Param> getParams() {
    return params;
  }

  /**
   * @return The value of the {@code body} attribute
   */
  @Override
  public BlockStatement getBody() {
    return body;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ConstructorIF#getModifiers() modifiers}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final Constructor withModifiers(Modifier... elements) {
    ImmutableList<Modifier> newValue = ImmutableList.copyOf(elements);
    return new Constructor(newValue, this.params, this.body);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ConstructorIF#getModifiers() modifiers}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of modifiers elements to set
   * @return A modified copy of {@code this} object
   */
  public final Constructor withModifiers(Iterable<? extends Modifier> elements) {
    if (this.modifiers == elements) return this;
    ImmutableList<Modifier> newValue = ImmutableList.copyOf(elements);
    return new Constructor(newValue, this.params, this.body);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ConstructorIF#getParams() params}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final Constructor withParams(Param... elements) {
    ImmutableList<Param> newValue = ImmutableList.copyOf(elements);
    return new Constructor(this.modifiers, newValue, this.body);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ConstructorIF#getParams() params}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of params elements to set
   * @return A modified copy of {@code this} object
   */
  public final Constructor withParams(Iterable<? extends Param> elements) {
    if (this.params == elements) return this;
    ImmutableList<Param> newValue = ImmutableList.copyOf(elements);
    return new Constructor(this.modifiers, newValue, this.body);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ConstructorIF#getBody() body} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for body
   * @return A modified copy of the {@code this} object
   */
  public final Constructor withBody(BlockStatement value) {
    if (this.body == value) return this;
    BlockStatement newValue = Objects.requireNonNull(value, "body");
    return new Constructor(this.modifiers, this.params, newValue);
  }

  /**
   * This instance is equal to all instances of {@code Constructor} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof Constructor
        && equalTo((Constructor) another);
  }

  private boolean equalTo(Constructor another) {
    return modifiers.equals(another.modifiers)
        && params.equals(another.params)
        && body.equals(another.body);
  }

  /**
   * Computes a hash code from attributes: {@code modifiers}, {@code params}, {@code body}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + modifiers.hashCode();
    h += (h << 5) + params.hashCode();
    h += (h << 5) + body.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Constructor} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Constructor")
        .omitNullValues()
        .add("modifiers", modifiers)
        .add("params", params)
        .add("body", body)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ConstructorIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Constructor instance
   */
  public static Constructor copyOf(ConstructorIF instance) {
    if (instance instanceof Constructor) {
      return (Constructor) instance;
    }
    return Constructor.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link Constructor Constructor}.
   * @return A new Constructor builder
   */
  public static Constructor.Builder builder() {
    return new Constructor.Builder();
  }

  /**
   * Builds instances of type {@link Constructor Constructor}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_BODY = 0x1L;
    private long initBits = 0x1L;

    private ImmutableList.Builder<Modifier> modifiers = ImmutableList.builder();
    private ImmutableList.Builder<Param> params = ImmutableList.builder();
    private BlockStatement body;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ConstructorIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ConstructorIF instance) {
      Objects.requireNonNull(instance, "instance");
      addAllModifiers(instance.getModifiers());
      addAllParams(instance.getParams());
      setBody(instance.getBody());
      return this;
    }

    /**
     * Adds one element to {@link ConstructorIF#getModifiers() modifiers} list.
     * @param element A modifiers element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addModifiers(Modifier element) {
      this.modifiers.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ConstructorIF#getModifiers() modifiers} list.
     * @param elements An array of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addModifiers(Modifier... elements) {
      this.modifiers.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ConstructorIF#getModifiers() modifiers} list.
     * @param elements An iterable of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setModifiers(Iterable<? extends Modifier> elements) {
      this.modifiers = ImmutableList.builder();
      return addAllModifiers(elements);
    }

    /**
     * Adds elements to {@link ConstructorIF#getModifiers() modifiers} list.
     * @param elements An iterable of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllModifiers(Iterable<? extends Modifier> elements) {
      this.modifiers.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link ConstructorIF#getParams() params} list.
     * @param element A params element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addParams(Param element) {
      this.params.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ConstructorIF#getParams() params} list.
     * @param elements An array of params elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addParams(Param... elements) {
      this.params.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ConstructorIF#getParams() params} list.
     * @param elements An iterable of params elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setParams(Iterable<? extends Param> elements) {
      this.params = ImmutableList.builder();
      return addAllParams(elements);
    }

    /**
     * Adds elements to {@link ConstructorIF#getParams() params} list.
     * @param elements An iterable of params elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllParams(Iterable<? extends Param> elements) {
      this.params.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link ConstructorIF#getBody() body} attribute.
     * @param body The value for body 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setBody(BlockStatement body) {
      this.body = Objects.requireNonNull(body, "body");
      initBits &= ~INIT_BIT_BODY;
      return this;
    }

    /**
     * Builds a new {@link Constructor Constructor}.
     * @return An immutable instance of Constructor
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Constructor build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new Constructor(modifiers.build(), params.build(), body);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_BODY) != 0) attributes.add("body");
      return "Cannot build Constructor, some of required attributes are not set " + attributes;
    }
  }
}
