package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link FunctionCallIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code FunctionCall.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "FunctionCallIF"})
public final class FunctionCall implements FunctionCallIF {
  private final ImmutableList<Expression> args;
  private final String functionName;

  private FunctionCall(ImmutableList<Expression> args, String functionName) {
    this.args = args;
    this.functionName = functionName;
  }

  /**
   * @return The value of the {@code args} attribute
   */
  @Override
  public ImmutableList<Expression> getArgs() {
    return args;
  }

  /**
   * @return The value of the {@code functionName} attribute
   */
  @Override
  public String getFunctionName() {
    return functionName;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link FunctionCallIF#getArgs() args}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final FunctionCall withArgs(Expression... elements) {
    ImmutableList<Expression> newValue = ImmutableList.copyOf(elements);
    return new FunctionCall(newValue, this.functionName);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link FunctionCallIF#getArgs() args}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of args elements to set
   * @return A modified copy of {@code this} object
   */
  public final FunctionCall withArgs(Iterable<? extends Expression> elements) {
    if (this.args == elements) return this;
    ImmutableList<Expression> newValue = ImmutableList.copyOf(elements);
    return new FunctionCall(newValue, this.functionName);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FunctionCallIF#getFunctionName() functionName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for functionName
   * @return A modified copy of the {@code this} object
   */
  public final FunctionCall withFunctionName(String value) {
    if (this.functionName.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "functionName");
    return new FunctionCall(this.args, newValue);
  }

  /**
   * This instance is equal to all instances of {@code FunctionCall} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof FunctionCall
        && equalTo((FunctionCall) another);
  }

  private boolean equalTo(FunctionCall another) {
    return args.equals(another.args)
        && functionName.equals(another.functionName);
  }

  /**
   * Computes a hash code from attributes: {@code args}, {@code functionName}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + args.hashCode();
    h += (h << 5) + functionName.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code FunctionCall} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("FunctionCall")
        .omitNullValues()
        .add("args", args)
        .add("functionName", functionName)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link FunctionCallIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable FunctionCall instance
   */
  public static FunctionCall copyOf(FunctionCallIF instance) {
    if (instance instanceof FunctionCall) {
      return (FunctionCall) instance;
    }
    return FunctionCall.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link FunctionCall FunctionCall}.
   * @return A new FunctionCall builder
   */
  public static FunctionCall.Builder builder() {
    return new FunctionCall.Builder();
  }

  /**
   * Builds instances of type {@link FunctionCall FunctionCall}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_FUNCTION_NAME = 0x1L;
    private long initBits = 0x1L;

    private ImmutableList.Builder<Expression> args = ImmutableList.builder();
    private String functionName;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code FunctionCallIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(FunctionCallIF instance) {
      Objects.requireNonNull(instance, "instance");
      addAllArgs(instance.getArgs());
      setFunctionName(instance.getFunctionName());
      return this;
    }

    /**
     * Adds one element to {@link FunctionCallIF#getArgs() args} list.
     * @param element A args element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addArgs(Expression element) {
      this.args.add(element);
      return this;
    }

    /**
     * Adds elements to {@link FunctionCallIF#getArgs() args} list.
     * @param elements An array of args elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addArgs(Expression... elements) {
      this.args.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link FunctionCallIF#getArgs() args} list.
     * @param elements An iterable of args elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setArgs(Iterable<? extends Expression> elements) {
      this.args = ImmutableList.builder();
      return addAllArgs(elements);
    }

    /**
     * Adds elements to {@link FunctionCallIF#getArgs() args} list.
     * @param elements An iterable of args elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllArgs(Iterable<? extends Expression> elements) {
      this.args.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link FunctionCallIF#getFunctionName() functionName} attribute.
     * @param functionName The value for functionName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setFunctionName(String functionName) {
      this.functionName = Objects.requireNonNull(functionName, "functionName");
      initBits &= ~INIT_BIT_FUNCTION_NAME;
      return this;
    }

    /**
     * Builds a new {@link FunctionCall FunctionCall}.
     * @return An immutable instance of FunctionCall
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public FunctionCall build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new FunctionCall(args.build(), functionName);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_FUNCTION_NAME) != 0) attributes.add("functionName");
      return "Cannot build FunctionCall, some of required attributes are not set " + attributes;
    }
  }
}
