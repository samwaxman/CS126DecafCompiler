package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link ConstructorCallIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ConstructorCall.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ConstructorCallIF"})
public final class ConstructorCall implements ConstructorCallIF {
  private final String className;
  private final ImmutableList<Expression> arguments;

  private ConstructorCall(String className, ImmutableList<Expression> arguments) {
    this.className = className;
    this.arguments = arguments;
  }

  /**
   * @return The value of the {@code className} attribute
   */
  @Override
  public String getClassName() {
    return className;
  }

  /**
   * @return The value of the {@code arguments} attribute
   */
  @Override
  public ImmutableList<Expression> getArguments() {
    return arguments;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ConstructorCallIF#getClassName() className} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for className
   * @return A modified copy of the {@code this} object
   */
  public final ConstructorCall withClassName(String value) {
    if (this.className.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "className");
    return new ConstructorCall(newValue, this.arguments);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ConstructorCallIF#getArguments() arguments}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ConstructorCall withArguments(Expression... elements) {
    ImmutableList<Expression> newValue = ImmutableList.copyOf(elements);
    return new ConstructorCall(this.className, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ConstructorCallIF#getArguments() arguments}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of arguments elements to set
   * @return A modified copy of {@code this} object
   */
  public final ConstructorCall withArguments(Iterable<? extends Expression> elements) {
    if (this.arguments == elements) return this;
    ImmutableList<Expression> newValue = ImmutableList.copyOf(elements);
    return new ConstructorCall(this.className, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ConstructorCall} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ConstructorCall
        && equalTo((ConstructorCall) another);
  }

  private boolean equalTo(ConstructorCall another) {
    return className.equals(another.className)
        && arguments.equals(another.arguments);
  }

  /**
   * Computes a hash code from attributes: {@code className}, {@code arguments}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + className.hashCode();
    h += (h << 5) + arguments.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ConstructorCall} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ConstructorCall")
        .omitNullValues()
        .add("className", className)
        .add("arguments", arguments)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ConstructorCallIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ConstructorCall instance
   */
  public static ConstructorCall copyOf(ConstructorCallIF instance) {
    if (instance instanceof ConstructorCall) {
      return (ConstructorCall) instance;
    }
    return ConstructorCall.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ConstructorCall ConstructorCall}.
   * @return A new ConstructorCall builder
   */
  public static ConstructorCall.Builder builder() {
    return new ConstructorCall.Builder();
  }

  /**
   * Builds instances of type {@link ConstructorCall ConstructorCall}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_CLASS_NAME = 0x1L;
    private long initBits = 0x1L;

    private String className;
    private ImmutableList.Builder<Expression> arguments = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ConstructorCallIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ConstructorCallIF instance) {
      Objects.requireNonNull(instance, "instance");
      setClassName(instance.getClassName());
      addAllArguments(instance.getArguments());
      return this;
    }

    /**
     * Initializes the value for the {@link ConstructorCallIF#getClassName() className} attribute.
     * @param className The value for className 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setClassName(String className) {
      this.className = Objects.requireNonNull(className, "className");
      initBits &= ~INIT_BIT_CLASS_NAME;
      return this;
    }

    /**
     * Adds one element to {@link ConstructorCallIF#getArguments() arguments} list.
     * @param element A arguments element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addArguments(Expression element) {
      this.arguments.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ConstructorCallIF#getArguments() arguments} list.
     * @param elements An array of arguments elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addArguments(Expression... elements) {
      this.arguments.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ConstructorCallIF#getArguments() arguments} list.
     * @param elements An iterable of arguments elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setArguments(Iterable<? extends Expression> elements) {
      this.arguments = ImmutableList.builder();
      return addAllArguments(elements);
    }

    /**
     * Adds elements to {@link ConstructorCallIF#getArguments() arguments} list.
     * @param elements An iterable of arguments elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllArguments(Iterable<? extends Expression> elements) {
      this.arguments.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link ConstructorCall ConstructorCall}.
     * @return An immutable instance of ConstructorCall
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ConstructorCall build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ConstructorCall(className, arguments.build());
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CLASS_NAME) != 0) attributes.add("className");
      return "Cannot build ConstructorCall, some of required attributes are not set " + attributes;
    }
  }
}
