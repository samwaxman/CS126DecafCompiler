package staticchecks.resolvedInfo;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link ClassTypeIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableClassTypeIF.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ClassTypeIF"})
public final class ImmutableClassTypeIF implements ClassTypeIF {
  private final String className;

  private ImmutableClassTypeIF(String className) {
    this.className = className;
  }

  /**
   * @return The value of the {@code className} attribute
   */
  @Override
  public String getClassName() {
    return className;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ClassTypeIF#getClassName() className} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for className
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableClassTypeIF withClassName(String value) {
    if (this.className.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "className");
    return new ImmutableClassTypeIF(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableClassTypeIF} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableClassTypeIF
        && equalTo((ImmutableClassTypeIF) another);
  }

  private boolean equalTo(ImmutableClassTypeIF another) {
    return className.equals(another.className);
  }

  /**
   * Computes a hash code from attributes: {@code className}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + className.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ClassTypeIF} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ClassTypeIF")
        .omitNullValues()
        .add("className", className)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ClassTypeIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ClassTypeIF instance
   */
  public static ImmutableClassTypeIF copyOf(ClassTypeIF instance) {
    if (instance instanceof ImmutableClassTypeIF) {
      return (ImmutableClassTypeIF) instance;
    }
    return ImmutableClassTypeIF.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableClassTypeIF ImmutableClassTypeIF}.
   * @return A new ImmutableClassTypeIF builder
   */
  public static ImmutableClassTypeIF.Builder builder() {
    return new ImmutableClassTypeIF.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableClassTypeIF ImmutableClassTypeIF}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_CLASS_NAME = 0x1L;
    private long initBits = 0x1L;

    private String className;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ClassTypeIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ClassTypeIF instance) {
      Objects.requireNonNull(instance, "instance");
      className(instance.getClassName());
      return this;
    }

    /**
     * Initializes the value for the {@link ClassTypeIF#getClassName() className} attribute.
     * @param className The value for className 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder className(String className) {
      this.className = Objects.requireNonNull(className, "className");
      initBits &= ~INIT_BIT_CLASS_NAME;
      return this;
    }

    /**
     * Builds a new {@link ImmutableClassTypeIF ImmutableClassTypeIF}.
     * @return An immutable instance of ClassTypeIF
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableClassTypeIF build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableClassTypeIF(className);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CLASS_NAME) != 0) attributes.add("className");
      return "Cannot build ClassTypeIF, some of required attributes are not set " + attributes;
    }
  }
}
