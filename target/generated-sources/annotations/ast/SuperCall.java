package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link SuperCallIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code SuperCall.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "SuperCallIF"})
public final class SuperCall implements SuperCallIF {
  private final ImmutableList<Expression> args;

  private SuperCall(ImmutableList<Expression> args) {
    this.args = args;
  }

  /**
   * @return The value of the {@code args} attribute
   */
  @Override
  public ImmutableList<Expression> getArgs() {
    return args;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link SuperCallIF#getArgs() args}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final SuperCall withArgs(Expression... elements) {
    ImmutableList<Expression> newValue = ImmutableList.copyOf(elements);
    return new SuperCall(newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link SuperCallIF#getArgs() args}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of args elements to set
   * @return A modified copy of {@code this} object
   */
  public final SuperCall withArgs(Iterable<? extends Expression> elements) {
    if (this.args == elements) return this;
    ImmutableList<Expression> newValue = ImmutableList.copyOf(elements);
    return new SuperCall(newValue);
  }

  /**
   * This instance is equal to all instances of {@code SuperCall} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof SuperCall
        && equalTo((SuperCall) another);
  }

  private boolean equalTo(SuperCall another) {
    return args.equals(another.args);
  }

  /**
   * Computes a hash code from attributes: {@code args}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + args.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code SuperCall} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("SuperCall")
        .omitNullValues()
        .add("args", args)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link SuperCallIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable SuperCall instance
   */
  public static SuperCall copyOf(SuperCallIF instance) {
    if (instance instanceof SuperCall) {
      return (SuperCall) instance;
    }
    return SuperCall.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link SuperCall SuperCall}.
   * @return A new SuperCall builder
   */
  public static SuperCall.Builder builder() {
    return new SuperCall.Builder();
  }

  /**
   * Builds instances of type {@link SuperCall SuperCall}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private ImmutableList.Builder<Expression> args = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code SuperCallIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(SuperCallIF instance) {
      Objects.requireNonNull(instance, "instance");
      addAllArgs(instance.getArgs());
      return this;
    }

    /**
     * Adds one element to {@link SuperCallIF#getArgs() args} list.
     * @param element A args element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addArgs(Expression element) {
      this.args.add(element);
      return this;
    }

    /**
     * Adds elements to {@link SuperCallIF#getArgs() args} list.
     * @param elements An array of args elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addArgs(Expression... elements) {
      this.args.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link SuperCallIF#getArgs() args} list.
     * @param elements An iterable of args elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setArgs(Iterable<? extends Expression> elements) {
      this.args = ImmutableList.builder();
      return addAllArgs(elements);
    }

    /**
     * Adds elements to {@link SuperCallIF#getArgs() args} list.
     * @param elements An iterable of args elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllArgs(Iterable<? extends Expression> elements) {
      this.args.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link SuperCall SuperCall}.
     * @return An immutable instance of SuperCall
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public SuperCall build() {
      return new SuperCall(args.build());
    }
  }
}
