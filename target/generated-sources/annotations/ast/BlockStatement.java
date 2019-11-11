package ast;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link BlockStatementIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code BlockStatement.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "BlockStatementIF"})
public final class BlockStatement implements BlockStatementIF {
  private final ImmutableList<Statement> statements;

  private BlockStatement(ImmutableList<Statement> statements) {
    this.statements = statements;
  }

  /**
   * @return The value of the {@code statements} attribute
   */
  @Override
  public ImmutableList<Statement> getStatements() {
    return statements;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link BlockStatementIF#getStatements() statements}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final BlockStatement withStatements(Statement... elements) {
    ImmutableList<Statement> newValue = ImmutableList.copyOf(elements);
    return new BlockStatement(newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link BlockStatementIF#getStatements() statements}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of statements elements to set
   * @return A modified copy of {@code this} object
   */
  public final BlockStatement withStatements(Iterable<? extends Statement> elements) {
    if (this.statements == elements) return this;
    ImmutableList<Statement> newValue = ImmutableList.copyOf(elements);
    return new BlockStatement(newValue);
  }

  /**
   * This instance is equal to all instances of {@code BlockStatement} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof BlockStatement
        && equalTo((BlockStatement) another);
  }

  private boolean equalTo(BlockStatement another) {
    return statements.equals(another.statements);
  }

  /**
   * Computes a hash code from attributes: {@code statements}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + statements.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code BlockStatement} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("BlockStatement")
        .omitNullValues()
        .add("statements", statements)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link BlockStatementIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable BlockStatement instance
   */
  public static BlockStatement copyOf(BlockStatementIF instance) {
    if (instance instanceof BlockStatement) {
      return (BlockStatement) instance;
    }
    return BlockStatement.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link BlockStatement BlockStatement}.
   * @return A new BlockStatement builder
   */
  public static BlockStatement.Builder builder() {
    return new BlockStatement.Builder();
  }

  /**
   * Builds instances of type {@link BlockStatement BlockStatement}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private ImmutableList.Builder<Statement> statements = ImmutableList.builder();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code BlockStatementIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(BlockStatementIF instance) {
      Objects.requireNonNull(instance, "instance");
      addAllStatements(instance.getStatements());
      return this;
    }

    /**
     * Adds one element to {@link BlockStatementIF#getStatements() statements} list.
     * @param element A statements element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addStatements(Statement element) {
      this.statements.add(element);
      return this;
    }

    /**
     * Adds elements to {@link BlockStatementIF#getStatements() statements} list.
     * @param elements An array of statements elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addStatements(Statement... elements) {
      this.statements.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link BlockStatementIF#getStatements() statements} list.
     * @param elements An iterable of statements elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setStatements(Iterable<? extends Statement> elements) {
      this.statements = ImmutableList.builder();
      return addAllStatements(elements);
    }

    /**
     * Adds elements to {@link BlockStatementIF#getStatements() statements} list.
     * @param elements An iterable of statements elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllStatements(Iterable<? extends Statement> elements) {
      this.statements.addAll(elements);
      return this;
    }

    /**
     * Builds a new {@link BlockStatement BlockStatement}.
     * @return An immutable instance of BlockStatement
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public BlockStatement build() {
      return new BlockStatement(statements.build());
    }
  }
}
