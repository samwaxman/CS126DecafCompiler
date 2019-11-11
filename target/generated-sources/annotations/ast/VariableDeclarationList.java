package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link VariableDeclarationListIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code VariableDeclarationList.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "VariableDeclarationListIF"})
public final class VariableDeclarationList implements VariableDeclarationListIF {
  private final ImmutableList<VariableDeclarationStatement> declarations;

  private VariableDeclarationList(ImmutableList<VariableDeclarationStatement> declarations) {
    this.declarations = declarations;
  }

  /**
   * @return The value of the {@code declarations} attribute
   */
  @Override
  public ImmutableList<VariableDeclarationStatement> getDeclarations() {
    return declarations;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link VariableDeclarationListIF#getDeclarations() declarations}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final VariableDeclarationList withDeclarations(VariableDeclarationStatement... elements) {
    ImmutableList<VariableDeclarationStatement> newValue = ImmutableList.copyOf(elements);
    return new VariableDeclarationList(newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link VariableDeclarationListIF#getDeclarations() declarations}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of declarations elements to set
   * @return A modified copy of {@code this} object
   */
  public final VariableDeclarationList withDeclarations(Iterable<? extends VariableDeclarationStatement> elements) {
    if (this.declarations == elements) return this;
    ImmutableList<VariableDeclarationStatement> newValue = ImmutableList.copyOf(elements);
    return new VariableDeclarationList(newValue);
  }

  /**
   * This instance is equal to all instances of {@code VariableDeclarationList} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof VariableDeclarationList
        && equalTo((VariableDeclarationList) another);
  }

  private boolean equalTo(VariableDeclarationList another) {
    return declarations.equals(another.declarations);
  }

  /**
   * Computes a hash code from attributes: {@code declarations}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + declarations.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code VariableDeclarationList} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("VariableDeclarationList")
        .omitNullValues()
        .add("declarations", declarations)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link VariableDeclarationListIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable VariableDeclarationList instance
   */
  public static VariableDeclarationList copyOf(VariableDeclarationListIF instance) {
    if (instance instanceof VariableDeclarationList) {
      return (VariableDeclarationList) instance;
    }
    return VariableDeclarationList.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link VariableDeclarationList VariableDeclarationList}.
   * @return A new VariableDeclarationList builder
   */
  public static VariableDeclarationList.Builder builder() {
    return new VariableDeclarationList.Builder();
  }

  /**
   * Builds instances of type {@link VariableDeclarationList VariableDeclarationList}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private ImmutableList.Builder<VariableDeclarationStatement> declarations = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code VariableDeclarationListIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(VariableDeclarationListIF instance) {
      Objects.requireNonNull(instance, "instance");
      addAllDeclarations(instance.getDeclarations());
      return this;
    }

    /**
     * Adds one element to {@link VariableDeclarationListIF#getDeclarations() declarations} list.
     * @param element A declarations element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addDeclarations(VariableDeclarationStatement element) {
      this.declarations.add(element);
      return this;
    }

    /**
     * Adds elements to {@link VariableDeclarationListIF#getDeclarations() declarations} list.
     * @param elements An array of declarations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addDeclarations(VariableDeclarationStatement... elements) {
      this.declarations.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link VariableDeclarationListIF#getDeclarations() declarations} list.
     * @param elements An iterable of declarations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setDeclarations(Iterable<? extends VariableDeclarationStatement> elements) {
      this.declarations = ImmutableList.builder();
      return addAllDeclarations(elements);
    }

    /**
     * Adds elements to {@link VariableDeclarationListIF#getDeclarations() declarations} list.
     * @param elements An iterable of declarations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllDeclarations(Iterable<? extends VariableDeclarationStatement> elements) {
      this.declarations.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link VariableDeclarationList VariableDeclarationList}.
     * @return An immutable instance of VariableDeclarationList
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public VariableDeclarationList build() {
      return new VariableDeclarationList(declarations.build());
    }
  }
}
