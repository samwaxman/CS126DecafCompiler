package ast;

import astPojos.BlockStatement;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link MethodIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Method.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "MethodIF"})
public final class Method implements MethodIF {
  private final String methodName;
  private final ImmutableList<Modifier> modifiers;
  private final ImmutableList<Param> params;
  private final BlockStatement body;
  private final Type returnType;

  private Method(
      String methodName,
      ImmutableList<Modifier> modifiers,
      ImmutableList<Param> params,
      BlockStatement body,
      Type returnType) {
    this.methodName = methodName;
    this.modifiers = modifiers;
    this.params = params;
    this.body = body;
    this.returnType = returnType;
  }

  /**
   * @return The value of the {@code methodName} attribute
   */
  @Override
  public String getMethodName() {
    return methodName;
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
   * @return The value of the {@code returnType} attribute
   */
  @Override
  public Type getReturnType() {
    return returnType;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link MethodIF#getMethodName() methodName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for methodName
   * @return A modified copy of the {@code this} object
   */
  public final Method withMethodName(String value) {
    if (this.methodName.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "methodName");
    return new Method(newValue, this.modifiers, this.params, this.body, this.returnType);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link MethodIF#getModifiers() modifiers}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final Method withModifiers(Modifier... elements) {
    ImmutableList<Modifier> newValue = ImmutableList.copyOf(elements);
    return new Method(this.methodName, newValue, this.params, this.body, this.returnType);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link MethodIF#getModifiers() modifiers}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of modifiers elements to set
   * @return A modified copy of {@code this} object
   */
  public final Method withModifiers(Iterable<? extends Modifier> elements) {
    if (this.modifiers == elements) return this;
    ImmutableList<Modifier> newValue = ImmutableList.copyOf(elements);
    return new Method(this.methodName, newValue, this.params, this.body, this.returnType);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link MethodIF#getParams() params}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final Method withParams(Param... elements) {
    ImmutableList<Param> newValue = ImmutableList.copyOf(elements);
    return new Method(this.methodName, this.modifiers, newValue, this.body, this.returnType);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link MethodIF#getParams() params}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of params elements to set
   * @return A modified copy of {@code this} object
   */
  public final Method withParams(Iterable<? extends Param> elements) {
    if (this.params == elements) return this;
    ImmutableList<Param> newValue = ImmutableList.copyOf(elements);
    return new Method(this.methodName, this.modifiers, newValue, this.body, this.returnType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link MethodIF#getBody() body} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for body
   * @return A modified copy of the {@code this} object
   */
  public final Method withBody(BlockStatement value) {
    if (this.body == value) return this;
    BlockStatement newValue = Objects.requireNonNull(value, "body");
    return new Method(this.methodName, this.modifiers, this.params, newValue, this.returnType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link MethodIF#getReturnType() returnType} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for returnType
   * @return A modified copy of the {@code this} object
   */
  public final Method withReturnType(Type value) {
    if (this.returnType == value) return this;
    Type newValue = Objects.requireNonNull(value, "returnType");
    return new Method(this.methodName, this.modifiers, this.params, this.body, newValue);
  }

  /**
   * This instance is equal to all instances of {@code Method} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof Method
        && equalTo((Method) another);
  }

  private boolean equalTo(Method another) {
    return methodName.equals(another.methodName)
        && modifiers.equals(another.modifiers)
        && params.equals(another.params)
        && body.equals(another.body)
        && returnType.equals(another.returnType);
  }

  /**
   * Computes a hash code from attributes: {@code methodName}, {@code modifiers}, {@code params}, {@code body}, {@code returnType}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + methodName.hashCode();
    h += (h << 5) + modifiers.hashCode();
    h += (h << 5) + params.hashCode();
    h += (h << 5) + body.hashCode();
    h += (h << 5) + returnType.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Method} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Method")
        .omitNullValues()
        .add("methodName", methodName)
        .add("modifiers", modifiers)
        .add("params", params)
        .add("body", body)
        .add("returnType", returnType)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link MethodIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Method instance
   */
  public static Method copyOf(MethodIF instance) {
    if (instance instanceof Method) {
      return (Method) instance;
    }
    return Method.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link Method Method}.
   * @return A new Method builder
   */
  public static Method.Builder builder() {
    return new Method.Builder();
  }

  /**
   * Builds instances of type {@link Method Method}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_METHOD_NAME = 0x1L;
    private static final long INIT_BIT_BODY = 0x2L;
    private static final long INIT_BIT_RETURN_TYPE = 0x4L;
    private long initBits = 0x7L;

    private String methodName;
    private ImmutableList.Builder<Modifier> modifiers = ImmutableList.builder();
    private ImmutableList.Builder<Param> params = ImmutableList.builder();
    private BlockStatement body;
    private Type returnType;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code MethodIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(MethodIF instance) {
      Objects.requireNonNull(instance, "instance");
      setMethodName(instance.getMethodName());
      addAllModifiers(instance.getModifiers());
      addAllParams(instance.getParams());
      setBody(instance.getBody());
      setReturnType(instance.getReturnType());
      return this;
    }

    /**
     * Initializes the value for the {@link MethodIF#getMethodName() methodName} attribute.
     * @param methodName The value for methodName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setMethodName(String methodName) {
      this.methodName = Objects.requireNonNull(methodName, "methodName");
      initBits &= ~INIT_BIT_METHOD_NAME;
      return this;
    }

    /**
     * Adds one element to {@link MethodIF#getModifiers() modifiers} list.
     * @param element A modifiers element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addModifiers(Modifier element) {
      this.modifiers.add(element);
      return this;
    }

    /**
     * Adds elements to {@link MethodIF#getModifiers() modifiers} list.
     * @param elements An array of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addModifiers(Modifier... elements) {
      this.modifiers.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link MethodIF#getModifiers() modifiers} list.
     * @param elements An iterable of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setModifiers(Iterable<? extends Modifier> elements) {
      this.modifiers = ImmutableList.builder();
      return addAllModifiers(elements);
    }

    /**
     * Adds elements to {@link MethodIF#getModifiers() modifiers} list.
     * @param elements An iterable of modifiers elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllModifiers(Iterable<? extends Modifier> elements) {
      this.modifiers.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link MethodIF#getParams() params} list.
     * @param element A params element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addParams(Param element) {
      this.params.add(element);
      return this;
    }

    /**
     * Adds elements to {@link MethodIF#getParams() params} list.
     * @param elements An array of params elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addParams(Param... elements) {
      this.params.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link MethodIF#getParams() params} list.
     * @param elements An iterable of params elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setParams(Iterable<? extends Param> elements) {
      this.params = ImmutableList.builder();
      return addAllParams(elements);
    }

    /**
     * Adds elements to {@link MethodIF#getParams() params} list.
     * @param elements An iterable of params elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllParams(Iterable<? extends Param> elements) {
      this.params.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link MethodIF#getBody() body} attribute.
     * @param body The value for body 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setBody(BlockStatement body) {
      this.body = Objects.requireNonNull(body, "body");
      initBits &= ~INIT_BIT_BODY;
      return this;
    }

    /**
     * Initializes the value for the {@link MethodIF#getReturnType() returnType} attribute.
     * @param returnType The value for returnType 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setReturnType(Type returnType) {
      this.returnType = Objects.requireNonNull(returnType, "returnType");
      initBits &= ~INIT_BIT_RETURN_TYPE;
      return this;
    }

    /**
     * Builds a new {@link Method Method}.
     * @return An immutable instance of Method
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Method build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new Method(methodName, modifiers.build(), params.build(), body, returnType);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_METHOD_NAME) != 0) attributes.add("methodName");
      if ((initBits & INIT_BIT_BODY) != 0) attributes.add("body");
      if ((initBits & INIT_BIT_RETURN_TYPE) != 0) attributes.add("returnType");
      return "Cannot build Method, some of required attributes are not set " + attributes;
    }
  }
}
