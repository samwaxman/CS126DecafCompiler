package staticchecks.resolvedInfo;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link ClassInfoIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ClassInfo.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ClassInfoIF"})
public final class ClassInfo implements ClassInfoIF {
  private final ImmutableMap<String, ResolvedField> fields;
  private final ImmutableMap<String, ResolvedMethod> methods;
  private final String superClassName;
  private final ResolvedConstructor constructor;

  private ClassInfo(
      ImmutableMap<String, ResolvedField> fields,
      ImmutableMap<String, ResolvedMethod> methods,
      String superClassName,
      ResolvedConstructor constructor) {
    this.fields = fields;
    this.methods = methods;
    this.superClassName = superClassName;
    this.constructor = constructor;
  }

  /**
   * @return The value of the {@code fields} attribute
   */
  @Override
  public ImmutableMap<String, ResolvedField> getFields() {
    return fields;
  }

  /**
   * @return The value of the {@code methods} attribute
   */
  @Override
  public ImmutableMap<String, ResolvedMethod> getMethods() {
    return methods;
  }

  /**
   * @return The value of the {@code superClassName} attribute
   */
  @Override
  public String getSuperClassName() {
    return superClassName;
  }

  /**
   * @return The value of the {@code constructor} attribute
   */
  @Override
  public ResolvedConstructor getConstructor() {
    return constructor;
  }

  /**
   * Copy the current immutable object by replacing the {@link ClassInfoIF#getFields() fields} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entries The entries to be added to the fields map
   * @return A modified copy of {@code this} object
   */
  public final ClassInfo withFields(Map<String, ? extends ResolvedField> entries) {
    if (this.fields == entries) return this;
    ImmutableMap<String, ResolvedField> newValue = ImmutableMap.copyOf(entries);
    return new ClassInfo(newValue, this.methods, this.superClassName, this.constructor);
  }

  /**
   * Copy the current immutable object by replacing the {@link ClassInfoIF#getMethods() methods} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entries The entries to be added to the methods map
   * @return A modified copy of {@code this} object
   */
  public final ClassInfo withMethods(Map<String, ? extends ResolvedMethod> entries) {
    if (this.methods == entries) return this;
    ImmutableMap<String, ResolvedMethod> newValue = ImmutableMap.copyOf(entries);
    return new ClassInfo(this.fields, newValue, this.superClassName, this.constructor);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ClassInfoIF#getSuperClassName() superClassName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for superClassName
   * @return A modified copy of the {@code this} object
   */
  public final ClassInfo withSuperClassName(String value) {
    if (this.superClassName.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "superClassName");
    return new ClassInfo(this.fields, this.methods, newValue, this.constructor);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ClassInfoIF#getConstructor() constructor} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for constructor
   * @return A modified copy of the {@code this} object
   */
  public final ClassInfo withConstructor(ResolvedConstructor value) {
    if (this.constructor == value) return this;
    ResolvedConstructor newValue = Objects.requireNonNull(value, "constructor");
    return new ClassInfo(this.fields, this.methods, this.superClassName, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ClassInfo} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ClassInfo
        && equalTo((ClassInfo) another);
  }

  private boolean equalTo(ClassInfo another) {
    return fields.equals(another.fields)
        && methods.equals(another.methods)
        && superClassName.equals(another.superClassName)
        && constructor.equals(another.constructor);
  }

  /**
   * Computes a hash code from attributes: {@code fields}, {@code methods}, {@code superClassName}, {@code constructor}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + fields.hashCode();
    h += (h << 5) + methods.hashCode();
    h += (h << 5) + superClassName.hashCode();
    h += (h << 5) + constructor.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ClassInfo} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ClassInfo")
        .omitNullValues()
        .add("fields", fields)
        .add("methods", methods)
        .add("superClassName", superClassName)
        .add("constructor", constructor)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ClassInfoIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ClassInfo instance
   */
  public static ClassInfo copyOf(ClassInfoIF instance) {
    if (instance instanceof ClassInfo) {
      return (ClassInfo) instance;
    }
    return ClassInfo.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ClassInfo ClassInfo}.
   * @return A new ClassInfo builder
   */
  public static ClassInfo.Builder builder() {
    return new ClassInfo.Builder();
  }

  /**
   * Builds instances of type {@link ClassInfo ClassInfo}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_SUPER_CLASS_NAME = 0x1L;
    private static final long INIT_BIT_CONSTRUCTOR = 0x2L;
    private long initBits = 0x3L;

    private ImmutableMap.Builder<String, ResolvedField> fields = ImmutableMap.builder();
    private ImmutableMap.Builder<String, ResolvedMethod> methods = ImmutableMap.builder();
    private String superClassName;
    private ResolvedConstructor constructor;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ClassInfoIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ClassInfoIF instance) {
      Objects.requireNonNull(instance, "instance");
      putAllFields(instance.getFields());
      putAllMethods(instance.getMethods());
      setSuperClassName(instance.getSuperClassName());
      setConstructor(instance.getConstructor());
      return this;
    }

    /**
     * Put one entry to the {@link ClassInfoIF#getFields() fields} map.
     * @param key The key in the fields map
     * @param value The associated value in the fields map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putFields(String key, ResolvedField value) {
      this.fields.put(key, value);
      return this;
    }

    /**
     * Put one entry to the {@link ClassInfoIF#getFields() fields} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putFields(Map.Entry<String, ? extends ResolvedField> entry) {
      this.fields.put(entry);
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link ClassInfoIF#getFields() fields} map. Nulls are not permitted
     * @param fields The entries that will be added to the fields map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setFields(Map<String, ? extends ResolvedField> fields) {
      this.fields = ImmutableMap.builder();
      return putAllFields(fields);
    }

    /**
     * Put all mappings from the specified map as entries to {@link ClassInfoIF#getFields() fields} map. Nulls are not permitted
     * @param fields The entries that will be added to the fields map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllFields(Map<String, ? extends ResolvedField> fields) {
      this.fields.putAll(fields);
      return this;
    }

    /**
     * Put one entry to the {@link ClassInfoIF#getMethods() methods} map.
     * @param key The key in the methods map
     * @param value The associated value in the methods map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putMethods(String key, ResolvedMethod value) {
      this.methods.put(key, value);
      return this;
    }

    /**
     * Put one entry to the {@link ClassInfoIF#getMethods() methods} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putMethods(Map.Entry<String, ? extends ResolvedMethod> entry) {
      this.methods.put(entry);
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link ClassInfoIF#getMethods() methods} map. Nulls are not permitted
     * @param methods The entries that will be added to the methods map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setMethods(Map<String, ? extends ResolvedMethod> methods) {
      this.methods = ImmutableMap.builder();
      return putAllMethods(methods);
    }

    /**
     * Put all mappings from the specified map as entries to {@link ClassInfoIF#getMethods() methods} map. Nulls are not permitted
     * @param methods The entries that will be added to the methods map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllMethods(Map<String, ? extends ResolvedMethod> methods) {
      this.methods.putAll(methods);
      return this;
    }

    /**
     * Initializes the value for the {@link ClassInfoIF#getSuperClassName() superClassName} attribute.
     * @param superClassName The value for superClassName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setSuperClassName(String superClassName) {
      this.superClassName = Objects.requireNonNull(superClassName, "superClassName");
      initBits &= ~INIT_BIT_SUPER_CLASS_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link ClassInfoIF#getConstructor() constructor} attribute.
     * @param constructor The value for constructor 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setConstructor(ResolvedConstructor constructor) {
      this.constructor = Objects.requireNonNull(constructor, "constructor");
      initBits &= ~INIT_BIT_CONSTRUCTOR;
      return this;
    }

    /**
     * Builds a new {@link ClassInfo ClassInfo}.
     * @return An immutable instance of ClassInfo
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ClassInfo build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ClassInfo(fields.build(), methods.build(), superClassName, constructor);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_SUPER_CLASS_NAME) != 0) attributes.add("superClassName");
      if ((initBits & INIT_BIT_CONSTRUCTOR) != 0) attributes.add("constructor");
      return "Cannot build ClassInfo, some of required attributes are not set " + attributes;
    }
  }
}
