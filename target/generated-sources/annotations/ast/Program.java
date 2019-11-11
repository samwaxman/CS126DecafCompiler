package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link ProgramIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code Program.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ProgramIF"})
public final class Program implements ProgramIF {
  private final ImmutableList<ClassASTNode> classes;

  private Program(ImmutableList<ClassASTNode> classes) {
    this.classes = classes;
  }

  /**
   * @return The value of the {@code classes} attribute
   */
  @Override
  public ImmutableList<ClassASTNode> getClasses() {
    return classes;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ProgramIF#getClasses() classes}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final Program withClasses(ClassASTNode... elements) {
    ImmutableList<ClassASTNode> newValue = ImmutableList.copyOf(elements);
    return new Program(newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link ProgramIF#getClasses() classes}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of classes elements to set
   * @return A modified copy of {@code this} object
   */
  public final Program withClasses(Iterable<? extends ClassASTNode> elements) {
    if (this.classes == elements) return this;
    ImmutableList<ClassASTNode> newValue = ImmutableList.copyOf(elements);
    return new Program(newValue);
  }

  /**
   * This instance is equal to all instances of {@code Program} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof Program
        && equalTo((Program) another);
  }

  private boolean equalTo(Program another) {
    return classes.equals(another.classes);
  }

  /**
   * Computes a hash code from attributes: {@code classes}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + classes.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Program} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("Program")
        .omitNullValues()
        .add("classes", classes)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ProgramIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Program instance
   */
  public static Program copyOf(ProgramIF instance) {
    if (instance instanceof Program) {
      return (Program) instance;
    }
    return Program.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link Program Program}.
   * @return A new Program builder
   */
  public static Program.Builder builder() {
    return new Program.Builder();
  }

  /**
   * Builds instances of type {@link Program Program}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private ImmutableList.Builder<ClassASTNode> classes = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ProgramIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ProgramIF instance) {
      Objects.requireNonNull(instance, "instance");
      addAllClasses(instance.getClasses());
      return this;
    }

    /**
     * Adds one element to {@link ProgramIF#getClasses() classes} list.
     * @param element A classes element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addClasses(ClassASTNode element) {
      this.classes.add(element);
      return this;
    }

    /**
     * Adds elements to {@link ProgramIF#getClasses() classes} list.
     * @param elements An array of classes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addClasses(ClassASTNode... elements) {
      this.classes.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link ProgramIF#getClasses() classes} list.
     * @param elements An iterable of classes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setClasses(Iterable<? extends ClassASTNode> elements) {
      this.classes = ImmutableList.builder();
      return addAllClasses(elements);
    }

    /**
     * Adds elements to {@link ProgramIF#getClasses() classes} list.
     * @param elements An iterable of classes elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllClasses(Iterable<? extends ClassASTNode> elements) {
      this.classes.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link Program Program}.
     * @return An immutable instance of Program
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public Program build() {
      return new Program(classes.build());
    }
  }
}
