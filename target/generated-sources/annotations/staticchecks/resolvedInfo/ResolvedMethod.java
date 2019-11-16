package staticchecks.resolvedInfo;

import ast.Modifier;
import astPojos.BlockStatement;
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
 * Immutable implementation of {@link ResolvedMethodIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ResolvedMethod.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ResolvedMethodIF"})
public final class ResolvedMethod implements ResolvedMethodIF {
  private final ResolvedType returnType;
  private final ImmutableList<ResolvedParam> arguments;
  private final ImmutableSet<Modifier> modifiers;
  private final BlockStatement body;

  private ResolvedMethod(
      ResolvedType returnType,
      ImmutableList<ResolvedParam> arguments,
      ImmutableSet<Modifier> modifiers,
      BlockStatement body) {
    this.returnType = returnType;
    this.arguments = arguments;
    this.modifiers = modifiers;
    this.body = body;
  }

  /**
   * @return The value of the {@code returnType} attribute
   */
  @Override
  public ResolvedType getReturnType() {
    return returnType;
  }

  /**
   * @return The value of the {@code arguments} attribute
   */
  @Override
  public ImmutableList<ResolvedParam> getArguments() {
    return arguments;
  }

  /**
   * @return The value of the {@code modifiers} attribute
   */
  @Override
  public ImmutableSet<Modifier> getModifiers() {
    return modifiers;
  }

  /**
   * @return The value of the {@code body} attribute
   */
  @Override
  public BlockStatement getBody() {
    return body;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ResolvedMethodIF#getReturnType() returnType} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for returnType
   * @return A modified copy of the {@code this} object
   */
  public final ResolvedMethod withReturnType(ResolvedType value) {
    if (this.returnType == value) return this;
    ResolvedType newValue = Objects.requireNonNull(value, "returnType");
    return new ResolvedMethod(newValue, this.arguments, this.modifiers, this.body);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ResolvedMethodIF#getArguments() arguments}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ResolvedMethod withArguments(ResolvedParam... elements) {
    ImmutableList<ResolvedParam> newValue = ImmutableList.copyOf(elements);
    return new ResolvedMethod(this.returnType, newValue, this.modifiers, this.body);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ResolvedMethodIF#getArguments() arguments}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of arguments elements to set
   * @return A modified copy of {@code this} object
   */
  public final ResolvedMethod withArguments(Iterable<? extends ResolvedParam> elements) {
    if (this.arguments == elements) return this;
    ImmutableList<ResolvedParam> newValue = ImmutableList.copyOf(elements);
    return new ResolvedMethod(this.returnType, newValue, this.modifiers, this.body);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ResolvedMethodIF#getModifiers() modifiers}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ResolvedMethod withModifiers(Modifier... elements) {
    ImmutableSet<Modifier> newValue = Sets.immutableEnumSet(Arrays.asList(elements));
    return new ResolvedMethod(this.returnType, this.arguments, newValue, this.body);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ResolvedMethodIF#getModifiers() modifiers}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of modifiers elements to set
   * @return A modified copy of {@code this} object
   */
  public final ResolvedMethod withModifiers(Iterable<Modifier> elements) {
    if (this.modifiers == elements) return this;
    ImmutableSet<Modifier> newValue = Sets.immutableEnumSet(elements);
    return new ResolvedMethod(this.returnType, this.arguments, newValue, this.body);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ResolvedMethodIF#getBody() body} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for body
   * @return A modified copy of the {@code this} object
   */
  public final ResolvedMethod withBody(BlockStatement value) {
    if (this.body == value) return this;
    BlockStatement newValue = Objects.requireNonNull(value, "body");
    return new ResolvedMethod(this.returnType, this.arguments, this.modifiers, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ResolvedMethod} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ResolvedMethod
        && equalTo((ResolvedMethod) another);
  }

  private boolean equalTo(ResolvedMethod another) {
    return returnType.equals(another.returnType)
        && arguments.equals(another.arguments)
        && modifiers.equals(another.modifiers)
        && body.equals(another.body);
  }

  /**
   * Computes a hash code from attributes: {@code returnType}, {@code arguments}, {@code modifiers}, {@code body}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + returnType.hashCode();
    h += (h << 5) + arguments.hashCode();
    h += (h << 5) + modifiers.hashCode();
    h += (h << 5) + body.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ResolvedMethod} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ResolvedMethod")
        .omitNullValues()
        .add("returnType", returnType)
        .add("arguments", arguments)
        .add("modifiers", modifiers)
        .add("body", body)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ResolvedMethodIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ResolvedMethod instance
   */
  public static ResolvedMethod copyOf(ResolvedMethodIF instance) {
    if (instance instanceof ResolvedMethod) {
      return (ResolvedMethod) instance;
    }
    return ResolvedMethod.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ResolvedMethod ResolvedMethod}.
   * @return A new ResolvedMethod builder
   */
  public static ResolvedMethod.Builder builder() {
    return new ResolvedMethod.Builder();
  }

  /**
   * Builds instances of type {@link ResolvedMethod ResolvedMethod}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_RETURN_TYPE = 0x1L;
    private static final long INIT_BIT_BODY = 0x2L;
    private long initBits = 0x3L;

    private ResolvedType returnType;
    private ImmutableList.Builder<ResolvedParam> arguments = ImmutableList.builder();
    private ImmutableSet.Builder<Modifier> modifiers = ImmutableSet.builder();
    private BlockStatement body;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ResolvedMethodIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ResolvedMethodIF instance) {
      Objects.requireNonNull(instance, "instance");
      setReturnType(instance.getReturnType());
      addAllArguments(instance.getArguments());
      addAllModifiers(instance.getModifiers());
      setBody(instance.getBody());
      return this;
    }

    /**
     * Initializes the value for the {@link ResolvedMethodIF#getReturnType() returnType} attribute.
     * @param returnType The value for returnType 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setReturnType(ResolvedType returnType) {
      this.returnType = Objects.requireNonNull(returnType, "returnType");
      initBits &= ~INIT_BIT_RETURN_TYPE;
      return this;
    }

    /**
     * Adds one element to {@link ResolvedMethodIF#getArguments() arguments} list.
     * @param element A arguments element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addArguments(ResolvedParam element) {
      this.arguments.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ResolvedMethodIF#getArguments() arguments} list.
     * @param elements An array of arguments elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addArguments(ResolvedParam... elements) {
      this.arguments.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ResolvedMethodIF#getArguments() arguments} list.
     * @param elements An iterable of arguments elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setArguments(Iterable<? extends ResolvedParam> elements) {
      this.arguments = ImmutableList.builder();
      return addAllArguments(elements);
    }

    /**
     * Adds elements to {@link ResolvedMethodIF#getArguments() arguments} list.
     * @param elements An iterable of arguments elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllArguments(Iterable<? extends ResolvedParam> elements) {
      this.arguments.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link ResolvedMethodIF#getModifiers() modifiers} set.
     * @param element A modifiers element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addModifiers(Modifier element) {
      this.modifiers.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ResolvedMethodIF#getModifiers() modifiers} set.
     * @param elements An array of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addModifiers(Modifier... elements) {
      this.modifiers.addAll(Arrays.asList(elements));
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ResolvedMethodIF#getModifiers() modifiers} set.
     * @param elements An iterable of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setModifiers(Iterable<Modifier> elements) {
      this.modifiers = ImmutableSet.builder();
      return addAllModifiers(elements);
    }

    /**
     * Adds elements to {@link ResolvedMethodIF#getModifiers() modifiers} set.
     * @param elements An iterable of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllModifiers(Iterable<Modifier> elements) {
      this.modifiers.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link ResolvedMethodIF#getBody() body} attribute.
     * @param body The value for body 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setBody(BlockStatement body) {
      this.body = Objects.requireNonNull(body, "body");
      initBits &= ~INIT_BIT_BODY;
      return this;
    }

    /**
     * Builds a new {@link ResolvedMethod ResolvedMethod}.
     * @return An immutable instance of ResolvedMethod
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ResolvedMethod build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ResolvedMethod(
          returnType,
          arguments.build(),
          Sets.immutableEnumSet(modifiers.build()),
          body);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_RETURN_TYPE) != 0) attributes.add("returnType");
      if ((initBits & INIT_BIT_BODY) != 0) attributes.add("body");
      return "Cannot build ResolvedMethod, some of required attributes are not set " + attributes;
    }
  }
}
