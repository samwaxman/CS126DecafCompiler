package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link MethodCallIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code MethodCall.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "MethodCallIF"})
public final class MethodCall implements MethodCallIF {
  private final Expression object;
  private final String methodName;
  private final ImmutableList<Expression> arguments;

  private MethodCall(
      Expression object,
      String methodName,
      ImmutableList<Expression> arguments) {
    this.object = object;
    this.methodName = methodName;
    this.arguments = arguments;
  }

  /**
   * @return The value of the {@code object} attribute
   */
  @Override
  public Expression getObject() {
    return object;
  }

  /**
   * @return The value of the {@code methodName} attribute
   */
  @Override
  public String getMethodName() {
    return methodName;
  }

  /**
   * @return The value of the {@code arguments} attribute
   */
  @Override
  public ImmutableList<Expression> getArguments() {
    return arguments;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link MethodCallIF#getObject() object} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for object
   * @return A modified copy of the {@code this} object
   */
  public final MethodCall withObject(Expression value) {
    if (this.object == value) return this;
    Expression newValue = Objects.requireNonNull(value, "object");
    return new MethodCall(newValue, this.methodName, this.arguments);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link MethodCallIF#getMethodName() methodName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for methodName
   * @return A modified copy of the {@code this} object
   */
  public final MethodCall withMethodName(String value) {
    if (this.methodName.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "methodName");
    return new MethodCall(this.object, newValue, this.arguments);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link MethodCallIF#getArguments() arguments}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final MethodCall withArguments(Expression... elements) {
    ImmutableList<Expression> newValue = ImmutableList.copyOf(elements);
    return new MethodCall(this.object, this.methodName, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link MethodCallIF#getArguments() arguments}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of arguments elements to set
   * @return A modified copy of {@code this} object
   */
  public final MethodCall withArguments(Iterable<? extends Expression> elements) {
    if (this.arguments == elements) return this;
    ImmutableList<Expression> newValue = ImmutableList.copyOf(elements);
    return new MethodCall(this.object, this.methodName, newValue);
  }

  /**
   * This instance is equal to all instances of {@code MethodCall} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof MethodCall
        && equalTo((MethodCall) another);
  }

  private boolean equalTo(MethodCall another) {
    return object.equals(another.object)
        && methodName.equals(another.methodName)
        && arguments.equals(another.arguments);
  }

  /**
   * Computes a hash code from attributes: {@code object}, {@code methodName}, {@code arguments}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + object.hashCode();
    h += (h << 5) + methodName.hashCode();
    h += (h << 5) + arguments.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code MethodCall} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("MethodCall")
        .omitNullValues()
        .add("object", object)
        .add("methodName", methodName)
        .add("arguments", arguments)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link MethodCallIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable MethodCall instance
   */
  public static MethodCall copyOf(MethodCallIF instance) {
    if (instance instanceof MethodCall) {
      return (MethodCall) instance;
    }
    return MethodCall.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link MethodCall MethodCall}.
   * @return A new MethodCall builder
   */
  public static MethodCall.Builder builder() {
    return new MethodCall.Builder();
  }

  /**
   * Builds instances of type {@link MethodCall MethodCall}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_OBJECT = 0x1L;
    private static final long INIT_BIT_METHOD_NAME = 0x2L;
    private long initBits = 0x3L;

    private Expression object;
    private String methodName;
    private ImmutableList.Builder<Expression> arguments = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code MethodCallIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(MethodCallIF instance) {
      Objects.requireNonNull(instance, "instance");
      setObject(instance.getObject());
      setMethodName(instance.getMethodName());
      addAllArguments(instance.getArguments());
      return this;
    }

    /**
     * Initializes the value for the {@link MethodCallIF#getObject() object} attribute.
     * @param object The value for object 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setObject(Expression object) {
      this.object = Objects.requireNonNull(object, "object");
      initBits &= ~INIT_BIT_OBJECT;
      return this;
    }

    /**
     * Initializes the value for the {@link MethodCallIF#getMethodName() methodName} attribute.
     * @param methodName The value for methodName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setMethodName(String methodName) {
      this.methodName = Objects.requireNonNull(methodName, "methodName");
      initBits &= ~INIT_BIT_METHOD_NAME;
      return this;
    }

    /**
     * Adds one element to {@link MethodCallIF#getArguments() arguments} list.
     * @param element A arguments element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addArguments(Expression element) {
      this.arguments.add(element);
      return this;
    }

    /**
     * Adds elements to {@link MethodCallIF#getArguments() arguments} list.
     * @param elements An array of arguments elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addArguments(Expression... elements) {
      this.arguments.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link MethodCallIF#getArguments() arguments} list.
     * @param elements An iterable of arguments elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setArguments(Iterable<? extends Expression> elements) {
      this.arguments = ImmutableList.builder();
      return addAllArguments(elements);
    }

    /**
     * Adds elements to {@link MethodCallIF#getArguments() arguments} list.
     * @param elements An iterable of arguments elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllArguments(Iterable<? extends Expression> elements) {
      this.arguments.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link MethodCall MethodCall}.
     * @return An immutable instance of MethodCall
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public MethodCall build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new MethodCall(object, methodName, arguments.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_OBJECT) != 0) attributes.add("object");
      if ((initBits & INIT_BIT_METHOD_NAME) != 0) attributes.add("methodName");
      return "Cannot build MethodCall, some of required attributes are not set " + attributes;
    }
  }
}
