package staticchecks.resolvedInfo;

import ast.BlockStatement;
import ast.Modifier;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link ResolvedConstructorIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ResolvedConstructor.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ResolvedConstructorIF"})
public final class ResolvedConstructor implements ResolvedConstructorIF {
  private final ImmutableList<ResolvedParam> arguments;
  private final BlockStatement body;
  private final ImmutableSet<Modifier> modifiers;

  private ResolvedConstructor(
      ImmutableList<ResolvedParam> arguments,
      BlockStatement body,
      ImmutableSet<Modifier> modifiers) {
    this.arguments = arguments;
    this.body = body;
    this.modifiers = modifiers;
  }

  /**
   * @return The value of the {@code arguments} attribute
   */
  @Override
  public ImmutableList<ResolvedParam> getArguments() {
    return arguments;
  }

  /**
   * @return The value of the {@code body} attribute
   */
  @Override
  public BlockStatement getBody() {
    return body;
  }

  /**
   * @return The value of the {@code modifiers} attribute
   */
  @Override
  public ImmutableSet<Modifier> getModifiers() {
    return modifiers;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ResolvedConstructorIF#getArguments() arguments}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ResolvedConstructor withArguments(ResolvedParam... elements) {
    ImmutableList<ResolvedParam> newValue = ImmutableList.copyOf(elements);
    return new ResolvedConstructor(newValue, this.body, this.modifiers);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ResolvedConstructorIF#getArguments() arguments}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of arguments elements to set
   * @return A modified copy of {@code this} object
   */
  public final ResolvedConstructor withArguments(Iterable<? extends ResolvedParam> elements) {
    if (this.arguments == elements) return this;
    ImmutableList<ResolvedParam> newValue = ImmutableList.copyOf(elements);
    return new ResolvedConstructor(newValue, this.body, this.modifiers);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ResolvedConstructorIF#getBody() body} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for body
   * @return A modified copy of the {@code this} object
   */
  public final ResolvedConstructor withBody(BlockStatement value) {
    if (this.body == value) return this;
    BlockStatement newValue = Objects.requireNonNull(value, "body");
    return new ResolvedConstructor(this.arguments, newValue, this.modifiers);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ResolvedConstructorIF#getModifiers() modifiers}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ResolvedConstructor withModifiers(Modifier... elements) {
    ImmutableSet<Modifier> newValue = Sets.immutableEnumSet(Arrays.asList(elements));
    return new ResolvedConstructor(this.arguments, this.body, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ResolvedConstructorIF#getModifiers() modifiers}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of modifiers elements to set
   * @return A modified copy of {@code this} object
   */
  public final ResolvedConstructor withModifiers(Iterable<Modifier> elements) {
    if (this.modifiers == elements) return this;
    ImmutableSet<Modifier> newValue = Sets.immutableEnumSet(elements);
    return new ResolvedConstructor(this.arguments, this.body, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ResolvedConstructor} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ResolvedConstructor
        && equalTo((ResolvedConstructor) another);
  }

  private boolean equalTo(ResolvedConstructor another) {
    return arguments.equals(another.arguments)
        && body.equals(another.body)
        && modifiers.equals(another.modifiers);
  }

  /**
   * Computes a hash code from attributes: {@code arguments}, {@code body}, {@code modifiers}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + arguments.hashCode();
    h += (h << 5) + body.hashCode();
    h += (h << 5) + modifiers.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ResolvedConstructor} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ResolvedConstructor")
        .omitNullValues()
        .add("arguments", arguments)
        .add("body", body)
        .add("modifiers", modifiers)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ResolvedConstructorIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ResolvedConstructor instance
   */
  public static ResolvedConstructor copyOf(ResolvedConstructorIF instance) {
    if (instance instanceof ResolvedConstructor) {
      return (ResolvedConstructor) instance;
    }
    return ResolvedConstructor.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ResolvedConstructor ResolvedConstructor}.
   * @return A new ResolvedConstructor builder
   */
  public static ResolvedConstructor.Builder builder() {
    return new ResolvedConstructor.Builder();
  }

  /**
   * Builds instances of type {@link ResolvedConstructor ResolvedConstructor}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_BODY = 0x1L;
    private long initBits = 0x1L;

    private ImmutableList.Builder<ResolvedParam> arguments = ImmutableList.builder();
    private BlockStatement body;
    private ImmutableSet.Builder<Modifier> modifiers = ImmutableSet.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ResolvedConstructorIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ResolvedConstructorIF instance) {
      Objects.requireNonNull(instance, "instance");
      addAllArguments(instance.getArguments());
      setBody(instance.getBody());
      addAllModifiers(instance.getModifiers());
      return this;
    }

    /**
     * Adds one element to {@link ResolvedConstructorIF#getArguments() arguments} list.
     * @param element A arguments element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addArguments(ResolvedParam element) {
      this.arguments.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ResolvedConstructorIF#getArguments() arguments} list.
     * @param elements An array of arguments elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addArguments(ResolvedParam... elements) {
      this.arguments.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ResolvedConstructorIF#getArguments() arguments} list.
     * @param elements An iterable of arguments elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setArguments(Iterable<? extends ResolvedParam> elements) {
      this.arguments = ImmutableList.builder();
      return addAllArguments(elements);
    }

    /**
     * Adds elements to {@link ResolvedConstructorIF#getArguments() arguments} list.
     * @param elements An iterable of arguments elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllArguments(Iterable<? extends ResolvedParam> elements) {
      this.arguments.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link ResolvedConstructorIF#getBody() body} attribute.
     * @param body The value for body 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setBody(BlockStatement body) {
      this.body = Objects.requireNonNull(body, "body");
      initBits &= ~INIT_BIT_BODY;
      return this;
    }

    /**
     * Adds one element to {@link ResolvedConstructorIF#getModifiers() modifiers} set.
     * @param element A modifiers element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addModifiers(Modifier element) {
      this.modifiers.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ResolvedConstructorIF#getModifiers() modifiers} set.
     * @param elements An array of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addModifiers(Modifier... elements) {
      this.modifiers.addAll(Arrays.asList(elements));
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ResolvedConstructorIF#getModifiers() modifiers} set.
     * @param elements An iterable of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setModifiers(Iterable<Modifier> elements) {
      this.modifiers = ImmutableSet.builder();
      return addAllModifiers(elements);
    }

    /**
     * Adds elements to {@link ResolvedConstructorIF#getModifiers() modifiers} set.
     * @param elements An iterable of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllModifiers(Iterable<Modifier> elements) {
      this.modifiers.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ResolvedConstructor ResolvedConstructor}.
     * @return An immutable instance of ResolvedConstructor
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ResolvedConstructor build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ResolvedConstructor(arguments.build(), body, Sets.immutableEnumSet(modifiers.build()));
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_BODY) != 0) attributes.add("body");
      return "Cannot build ResolvedConstructor, some of required attributes are not set " + attributes;
    }
  }
}
