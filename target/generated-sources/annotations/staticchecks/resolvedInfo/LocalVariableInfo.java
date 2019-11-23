package staticchecks.resolvedInfo;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link LocalVariableInfoIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code LocalVariableInfoTable.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "LocalVariableInfoIF"})
public final class LocalVariableInfo implements LocalVariableInfoIF {
  private final ResolvedType type;
  private final int index;

  private LocalVariableInfo(ResolvedType type, int index) {
    this.type = type;
    this.index = index;
  }

  /**
   * @return The value of the {@code type} attribute
   */
  @Override
  public ResolvedType getType() {
    return type;
  }

  /**
   * @return The value of the {@code index} attribute
   */
  @Override
  public int getIndex() {
    return index;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link LocalVariableInfoIF#getType() type} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final LocalVariableInfo withType(ResolvedType value) {
    if (this.type == value) return this;
    ResolvedType newValue = Objects.requireNonNull(value, "type");
    return new LocalVariableInfo(newValue, this.index);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link LocalVariableInfoIF#getIndex() index} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for index
   * @return A modified copy of the {@code this} object
   */
  public final LocalVariableInfo withIndex(int value) {
    if (this.index == value) return this;
    return new LocalVariableInfo(this.type, value);
  }

  /**
   * This instance is equal to all instances of {@code LocalVariableInfoTable} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof LocalVariableInfo
        && equalTo((LocalVariableInfo) another);
  }

  private boolean equalTo(LocalVariableInfo another) {
    return type.equals(another.type)
        && index == another.index;
  }

  /**
   * Computes a hash code from attributes: {@code type}, {@code index}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + type.hashCode();
    h += (h << 5) + index;
    return h;
  }

  /**
   * Prints the immutable value {@code LocalVariableInfoTable} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("LocalVariableInfoTable")
        .omitNullValues()
        .add("type", type)
        .add("index", index)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link LocalVariableInfoIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable LocalVariableInfoTable instance
   */
  public static LocalVariableInfo copyOf(LocalVariableInfoIF instance) {
    if (instance instanceof LocalVariableInfo) {
      return (LocalVariableInfo) instance;
    }
    return LocalVariableInfo.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link LocalVariableInfo LocalVariableInfoTable}.
   * @return A new LocalVariableInfoTable builder
   */
  public static LocalVariableInfo.Builder builder() {
    return new LocalVariableInfo.Builder();
  }

  /**
   * Builds instances of type {@link LocalVariableInfo LocalVariableInfoTable}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_TYPE = 0x1L;
    private static final long INIT_BIT_INDEX = 0x2L;
    private long initBits = 0x3L;

    private ResolvedType type;
    private int index;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code LocalVariableInfoIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(LocalVariableInfoIF instance) {
      Objects.requireNonNull(instance, "instance");
      setType(instance.getType());
      setIndex(instance.getIndex());
      return this;
    }

    /**
     * Initializes the value for the {@link LocalVariableInfoIF#getType() type} attribute.
     * @param type The value for type 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setType(ResolvedType type) {
      this.type = Objects.requireNonNull(type, "type");
      initBits &= ~INIT_BIT_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link LocalVariableInfoIF#getIndex() index} attribute.
     * @param index The value for index 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setIndex(int index) {
      this.index = index;
      initBits &= ~INIT_BIT_INDEX;
      return this;
    }

    /**
     * Builds a new {@link LocalVariableInfo LocalVariableInfoTable}.
     * @return An immutable instance of LocalVariableInfoTable
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public LocalVariableInfo build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new LocalVariableInfo(type, index);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      if ((initBits & INIT_BIT_INDEX) != 0) attributes.add("index");
      return "Cannot build LocalVariableInfoTable, some of required attributes are not set " + attributes;
    }
  }
}
