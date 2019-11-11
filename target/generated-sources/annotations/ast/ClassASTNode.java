package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link ClassASTNodeIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ClassASTNode.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ClassASTNodeIF"})
public final class ClassASTNode implements ClassASTNodeIF {
  private final String className;
  private final ImmutableList<Method> methods;
  private final ImmutableList<Field> fields;
  private final String getSuper;
  private final Constructor constructor;

  private ClassASTNode(
      String className,
      ImmutableList<Method> methods,
      ImmutableList<Field> fields,
      String getSuper,
      Constructor constructor) {
    this.className = className;
    this.methods = methods;
    this.fields = fields;
    this.getSuper = getSuper;
    this.constructor = constructor;
  }

  /**
   * @return The value of the {@code className} attribute
   */
  @Override
  public String getClassName() {
    return className;
  }

  /**
   * @return The value of the {@code methods} attribute
   */
  @Override
  public ImmutableList<Method> getMethods() {
    return methods;
  }

  /**
   * @return The value of the {@code fields} attribute
   */
  @Override
  public ImmutableList<Field> getFields() {
    return fields;
  }

  /**
   * @return The value of the {@code getSuper} attribute
   */
  @Override
  public Optional<String> getSuper() {
    return Optional.ofNullable(getSuper);
  }

  /**
   * @return The value of the {@code constructor} attribute
   */
  @Override
  public Optional<Constructor> getConstructor() {
    return Optional.ofNullable(constructor);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ClassASTNodeIF#getClassName() className} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for className
   * @return A modified copy of the {@code this} object
   */
  public final ClassASTNode withClassName(String value) {
    if (this.className.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "className");
    return new ClassASTNode(newValue, this.methods, this.fields, this.getSuper, this.constructor);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ClassASTNodeIF#getMethods() methods}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ClassASTNode withMethods(Method... elements) {
    ImmutableList<Method> newValue = ImmutableList.copyOf(elements);
    return new ClassASTNode(this.className, newValue, this.fields, this.getSuper, this.constructor);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ClassASTNodeIF#getMethods() methods}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of methods elements to set
   * @return A modified copy of {@code this} object
   */
  public final ClassASTNode withMethods(Iterable<? extends Method> elements) {
    if (this.methods == elements) return this;
    ImmutableList<Method> newValue = ImmutableList.copyOf(elements);
    return new ClassASTNode(this.className, newValue, this.fields, this.getSuper, this.constructor);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ClassASTNodeIF#getFields() fields}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ClassASTNode withFields(Field... elements) {
    ImmutableList<Field> newValue = ImmutableList.copyOf(elements);
    return new ClassASTNode(this.className, this.methods, newValue, this.getSuper, this.constructor);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ClassASTNodeIF#getFields() fields}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of fields elements to set
   * @return A modified copy of {@code this} object
   */
  public final ClassASTNode withFields(Iterable<? extends Field> elements) {
    if (this.fields == elements) return this;
    ImmutableList<Field> newValue = ImmutableList.copyOf(elements);
    return new ClassASTNode(this.className, this.methods, newValue, this.getSuper, this.constructor);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link ClassASTNodeIF#getSuper() super} attribute.
   * @param value The value for getSuper
   * @return A modified copy of {@code this} object
   */
  public final ClassASTNode withSuper(String value) {
    String newValue = Objects.requireNonNull(value, "getSuper");
    if (Objects.equals(this.getSuper, newValue)) return this;
    return new ClassASTNode(this.className, this.methods, this.fields, newValue, this.constructor);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link ClassASTNodeIF#getSuper() super} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for getSuper
   * @return A modified copy of {@code this} object
   */
  public final ClassASTNode withSuper(Optional<String> optional) {
    String value = optional.orElse(null);
    if (Objects.equals(this.getSuper, value)) return this;
    return new ClassASTNode(this.className, this.methods, this.fields, value, this.constructor);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link ClassASTNodeIF#getConstructor() constructor} attribute.
   * @param value The value for constructor
   * @return A modified copy of {@code this} object
   */
  public final ClassASTNode withConstructor(Constructor value) {
    Constructor newValue = Objects.requireNonNull(value, "constructor");
    if (this.constructor == newValue) return this;
    return new ClassASTNode(this.className, this.methods, this.fields, this.getSuper, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link ClassASTNodeIF#getConstructor() constructor} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for constructor
   * @return A modified copy of {@code this} object
   */
  public final ClassASTNode withConstructor(Optional<? extends Constructor> optional) {
    Constructor value = optional.orElse(null);
    if (this.constructor == value) return this;
    return new ClassASTNode(this.className, this.methods, this.fields, this.getSuper, value);
  }

  /**
   * This instance is equal to all instances of {@code ClassASTNode} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ClassASTNode
        && equalTo((ClassASTNode) another);
  }

  private boolean equalTo(ClassASTNode another) {
    return className.equals(another.className)
        && methods.equals(another.methods)
        && fields.equals(another.fields)
        && Objects.equals(getSuper, another.getSuper)
        && Objects.equals(constructor, another.constructor);
  }

  /**
   * Computes a hash code from attributes: {@code className}, {@code methods}, {@code fields}, {@code getSuper}, {@code constructor}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + className.hashCode();
    h += (h << 5) + methods.hashCode();
    h += (h << 5) + fields.hashCode();
    h += (h << 5) + Objects.hashCode(getSuper);
    h += (h << 5) + Objects.hashCode(constructor);
    return h;
  }

  /**
   * Prints the immutable value {@code ClassASTNode} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ClassASTNode")
        .omitNullValues()
        .add("className", className)
        .add("methods", methods)
        .add("fields", fields)
        .add("super", getSuper)
        .add("constructor", constructor)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ClassASTNodeIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ClassASTNode instance
   */
  public static ClassASTNode copyOf(ClassASTNodeIF instance) {
    if (instance instanceof ClassASTNode) {
      return (ClassASTNode) instance;
    }
    return ClassASTNode.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ClassASTNode ClassASTNode}.
   * @return A new ClassASTNode builder
   */
  public static ClassASTNode.Builder builder() {
    return new ClassASTNode.Builder();
  }

  /**
   * Builds instances of type {@link ClassASTNode ClassASTNode}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_CLASS_NAME = 0x1L;
    private long initBits = 0x1L;

    private String className;
    private ImmutableList.Builder<Method> methods = ImmutableList.builder();
    private ImmutableList.Builder<Field> fields = ImmutableList.builder();
    private String getSuper;
    private Constructor constructor;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ClassASTNodeIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ClassASTNodeIF instance) {
      Objects.requireNonNull(instance, "instance");
      setClassName(instance.getClassName());
      addAllMethods(instance.getMethods());
      addAllFields(instance.getFields());
      Optional<String> getSuperOptional = instance.getSuper();
      if (getSuperOptional.isPresent()) {
        setSuper(getSuperOptional);
      }
      Optional<Constructor> constructorOptional = instance.getConstructor();
      if (constructorOptional.isPresent()) {
        setConstructor(constructorOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link ClassASTNodeIF#getClassName() className} attribute.
     * @param className The value for className 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setClassName(String className) {
      this.className = Objects.requireNonNull(className, "className");
      initBits &= ~INIT_BIT_CLASS_NAME;
      return this;
    }

    /**
     * Adds one element to {@link ClassASTNodeIF#getMethods() methods} list.
     * @param element A methods element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addMethods(Method element) {
      this.methods.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ClassASTNodeIF#getMethods() methods} list.
     * @param elements An array of methods elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addMethods(Method... elements) {
      this.methods.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ClassASTNodeIF#getMethods() methods} list.
     * @param elements An iterable of methods elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setMethods(Iterable<? extends Method> elements) {
      this.methods = ImmutableList.builder();
      return addAllMethods(elements);
    }

    /**
     * Adds elements to {@link ClassASTNodeIF#getMethods() methods} list.
     * @param elements An iterable of methods elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllMethods(Iterable<? extends Method> elements) {
      this.methods.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link ClassASTNodeIF#getFields() fields} list.
     * @param element A fields element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addFields(Field element) {
      this.fields.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ClassASTNodeIF#getFields() fields} list.
     * @param elements An array of fields elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addFields(Field... elements) {
      this.fields.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ClassASTNodeIF#getFields() fields} list.
     * @param elements An iterable of fields elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setFields(Iterable<? extends Field> elements) {
      this.fields = ImmutableList.builder();
      return addAllFields(elements);
    }

    /**
     * Adds elements to {@link ClassASTNodeIF#getFields() fields} list.
     * @param elements An iterable of fields elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllFields(Iterable<? extends Field> elements) {
      this.fields.addAll(elements);
      return this;
    }

    /**
     * Initializes the optional value {@link ClassASTNodeIF#getSuper() super} to getSuper.
     * @param getSuper The value for getSuper
     * @return {@code this} builder for chained invocation
     */
    public final Builder setSuper(String getSuper) {
      this.getSuper = Objects.requireNonNull(getSuper, "getSuper");
      return this;
    }

    /**
     * Initializes the optional value {@link ClassASTNodeIF#getSuper() super} to getSuper.
     * @param getSuper The value for getSuper
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setSuper(Optional<String> getSuper) {
      this.getSuper = getSuper.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link ClassASTNodeIF#getConstructor() constructor} to constructor.
     * @param constructor The value for constructor
     * @return {@code this} builder for chained invocation
     */
    public final Builder setConstructor(Constructor constructor) {
      this.constructor = Objects.requireNonNull(constructor, "constructor");
      return this;
    }

    /**
     * Initializes the optional value {@link ClassASTNodeIF#getConstructor() constructor} to constructor.
     * @param constructor The value for constructor
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setConstructor(Optional<? extends Constructor> constructor) {
      this.constructor = constructor.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ClassASTNode ClassASTNode}.
     * @return An immutable instance of ClassASTNode
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ClassASTNode build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ClassASTNode(className, methods.build(), fields.build(), getSuper, constructor);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_CLASS_NAME) != 0) attributes.add("className");
      return "Cannot build ClassASTNode, some of required attributes are not set " + attributes;
    }
  }
}
