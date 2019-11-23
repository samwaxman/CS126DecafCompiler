package bytecode;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.GOTO;
import org.apache.bcel.generic.InstructionList;

/**
 * Immutable implementation of {@link ByteCodeStateIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ByteCodeState.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "ByteCodeStateIF"})
public final class ByteCodeState implements ByteCodeStateIF {
  private final InstructionList instructionList;
  private final ImmutableMap<String, ClassGen> classMap;
  private final ConstantPoolGen constantPoolGen;
  private final GOTO whileLoopEnd;
  private final GOTO whileLoopStart;

  private ByteCodeState(
      InstructionList instructionList,
      ImmutableMap<String, ClassGen> classMap,
      ConstantPoolGen constantPoolGen,
      GOTO whileLoopEnd,
      GOTO whileLoopStart) {
    this.instructionList = instructionList;
    this.classMap = classMap;
    this.constantPoolGen = constantPoolGen;
    this.whileLoopEnd = whileLoopEnd;
    this.whileLoopStart = whileLoopStart;
  }

  /**
   * @return The value of the {@code instructionList} attribute
   */
  @Override
  public InstructionList getInstructionList() {
    return instructionList;
  }

  /**
   * @return The value of the {@code classMap} attribute
   */
  @Override
  public ImmutableMap<String, ClassGen> getClassMap() {
    return classMap;
  }

  /**
   * @return The value of the {@code constantPoolGen} attribute
   */
  @Override
  public ConstantPoolGen getConstantPoolGen() {
    return constantPoolGen;
  }

  /**
   * @return The value of the {@code whileLoopEnd} attribute
   */
  @Override
  public Optional<GOTO> getWhileLoopEnd() {
    return Optional.ofNullable(whileLoopEnd);
  }

  /**
   * @return The value of the {@code whileLoopStart} attribute
   */
  @Override
  public Optional<GOTO> getWhileLoopStart() {
    return Optional.ofNullable(whileLoopStart);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ByteCodeStateIF#getInstructionList() instructionList} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for instructionList
   * @return A modified copy of the {@code this} object
   */
  public final ByteCodeState withInstructionList(InstructionList value) {
    if (this.instructionList == value) return this;
    InstructionList newValue = Objects.requireNonNull(value, "instructionList");
    return new ByteCodeState(newValue, this.classMap, this.constantPoolGen, this.whileLoopEnd, this.whileLoopStart);
  }

  /**
   * Copy the current immutable object by replacing the {@link ByteCodeStateIF#getClassMap() classMap} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entries The entries to be added to the classMap map
   * @return A modified copy of {@code this} object
   */
  public final ByteCodeState withClassMap(Map<String, ? extends ClassGen> entries) {
    if (this.classMap == entries) return this;
    ImmutableMap<String, ClassGen> newValue = ImmutableMap.copyOf(entries);
    return new ByteCodeState(this.instructionList, newValue, this.constantPoolGen, this.whileLoopEnd, this.whileLoopStart);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ByteCodeStateIF#getConstantPoolGen() constantPoolGen} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for constantPoolGen
   * @return A modified copy of the {@code this} object
   */
  public final ByteCodeState withConstantPoolGen(ConstantPoolGen value) {
    if (this.constantPoolGen == value) return this;
    ConstantPoolGen newValue = Objects.requireNonNull(value, "constantPoolGen");
    return new ByteCodeState(this.instructionList, this.classMap, newValue, this.whileLoopEnd, this.whileLoopStart);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link ByteCodeStateIF#getWhileLoopEnd() whileLoopEnd} attribute.
   * @param value The value for whileLoopEnd
   * @return A modified copy of {@code this} object
   */
  public final ByteCodeState withWhileLoopEnd(GOTO value) {
    GOTO newValue = Objects.requireNonNull(value, "whileLoopEnd");
    if (this.whileLoopEnd == newValue) return this;
    return new ByteCodeState(this.instructionList, this.classMap, this.constantPoolGen, newValue, this.whileLoopStart);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link ByteCodeStateIF#getWhileLoopEnd() whileLoopEnd} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for whileLoopEnd
   * @return A modified copy of {@code this} object
   */
  public final ByteCodeState withWhileLoopEnd(Optional<? extends GOTO> optional) {
    GOTO value = optional.orElse(null);
    if (this.whileLoopEnd == value) return this;
    return new ByteCodeState(this.instructionList, this.classMap, this.constantPoolGen, value, this.whileLoopStart);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link ByteCodeStateIF#getWhileLoopStart() whileLoopStart} attribute.
   * @param value The value for whileLoopStart
   * @return A modified copy of {@code this} object
   */
  public final ByteCodeState withWhileLoopStart(GOTO value) {
    GOTO newValue = Objects.requireNonNull(value, "whileLoopStart");
    if (this.whileLoopStart == newValue) return this;
    return new ByteCodeState(this.instructionList, this.classMap, this.constantPoolGen, this.whileLoopEnd, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link ByteCodeStateIF#getWhileLoopStart() whileLoopStart} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for whileLoopStart
   * @return A modified copy of {@code this} object
   */
  public final ByteCodeState withWhileLoopStart(Optional<? extends GOTO> optional) {
    GOTO value = optional.orElse(null);
    if (this.whileLoopStart == value) return this;
    return new ByteCodeState(this.instructionList, this.classMap, this.constantPoolGen, this.whileLoopEnd, value);
  }

  /**
   * This instance is equal to all instances of {@code ByteCodeState} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ByteCodeState
        && equalTo((ByteCodeState) another);
  }

  private boolean equalTo(ByteCodeState another) {
    return instructionList.equals(another.instructionList)
        && classMap.equals(another.classMap)
        && constantPoolGen.equals(another.constantPoolGen)
        && Objects.equals(whileLoopEnd, another.whileLoopEnd)
        && Objects.equals(whileLoopStart, another.whileLoopStart);
  }

  /**
   * Computes a hash code from attributes: {@code instructionList}, {@code classMap}, {@code constantPoolGen}, {@code whileLoopEnd}, {@code whileLoopStart}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + instructionList.hashCode();
    h += (h << 5) + classMap.hashCode();
    h += (h << 5) + constantPoolGen.hashCode();
    h += (h << 5) + Objects.hashCode(whileLoopEnd);
    h += (h << 5) + Objects.hashCode(whileLoopStart);
    return h;
  }

  /**
   * Prints the immutable value {@code ByteCodeState} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ByteCodeState")
        .omitNullValues()
        .add("instructionList", instructionList)
        .add("classMap", classMap)
        .add("constantPoolGen", constantPoolGen)
        .add("whileLoopEnd", whileLoopEnd)
        .add("whileLoopStart", whileLoopStart)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link ByteCodeStateIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ByteCodeState instance
   */
  public static ByteCodeState copyOf(ByteCodeStateIF instance) {
    if (instance instanceof ByteCodeState) {
      return (ByteCodeState) instance;
    }
    return ByteCodeState.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ByteCodeState ByteCodeState}.
   * @return A new ByteCodeState builder
   */
  public static ByteCodeState.Builder builder() {
    return new ByteCodeState.Builder();
  }

  /**
   * Builds instances of type {@link ByteCodeState ByteCodeState}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_INSTRUCTION_LIST = 0x1L;
    private static final long INIT_BIT_CONSTANT_POOL_GEN = 0x2L;
    private long initBits = 0x3L;

    private InstructionList instructionList;
    private ImmutableMap.Builder<String, ClassGen> classMap = ImmutableMap.builder();
    private ConstantPoolGen constantPoolGen;
    private GOTO whileLoopEnd;
    private GOTO whileLoopStart;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ByteCodeStateIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ByteCodeStateIF instance) {
      Objects.requireNonNull(instance, "instance");
      setInstructionList(instance.getInstructionList());
      putAllClassMap(instance.getClassMap());
      setConstantPoolGen(instance.getConstantPoolGen());
      Optional<GOTO> whileLoopEndOptional = instance.getWhileLoopEnd();
      if (whileLoopEndOptional.isPresent()) {
        setWhileLoopEnd(whileLoopEndOptional);
      }
      Optional<GOTO> whileLoopStartOptional = instance.getWhileLoopStart();
      if (whileLoopStartOptional.isPresent()) {
        setWhileLoopStart(whileLoopStartOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link ByteCodeStateIF#getInstructionList() instructionList} attribute.
     * @param instructionList The value for instructionList 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setInstructionList(InstructionList instructionList) {
      this.instructionList = Objects.requireNonNull(instructionList, "instructionList");
      initBits &= ~INIT_BIT_INSTRUCTION_LIST;
      return this;
    }

    /**
     * Put one entry to the {@link ByteCodeStateIF#getClassMap() classMap} map.
     * @param key The key in the classMap map
     * @param value The associated value in the classMap map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putClassMap(String key, ClassGen value) {
      this.classMap.put(key, value);
      return this;
    }

    /**
     * Put one entry to the {@link ByteCodeStateIF#getClassMap() classMap} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putClassMap(Map.Entry<String, ? extends ClassGen> entry) {
      this.classMap.put(entry);
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link ByteCodeStateIF#getClassMap() classMap} map. Nulls are not permitted
     * @param classMap The entries that will be added to the classMap map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setClassMap(Map<String, ? extends ClassGen> classMap) {
      this.classMap = ImmutableMap.builder();
      return putAllClassMap(classMap);
    }

    /**
     * Put all mappings from the specified map as entries to {@link ByteCodeStateIF#getClassMap() classMap} map. Nulls are not permitted
     * @param classMap The entries that will be added to the classMap map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllClassMap(Map<String, ? extends ClassGen> classMap) {
      this.classMap.putAll(classMap);
      return this;
    }

    /**
     * Initializes the value for the {@link ByteCodeStateIF#getConstantPoolGen() constantPoolGen} attribute.
     * @param constantPoolGen The value for constantPoolGen 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setConstantPoolGen(ConstantPoolGen constantPoolGen) {
      this.constantPoolGen = Objects.requireNonNull(constantPoolGen, "constantPoolGen");
      initBits &= ~INIT_BIT_CONSTANT_POOL_GEN;
      return this;
    }

    /**
     * Initializes the optional value {@link ByteCodeStateIF#getWhileLoopEnd() whileLoopEnd} to whileLoopEnd.
     * @param whileLoopEnd The value for whileLoopEnd
     * @return {@code this} builder for chained invocation
     */
    public final Builder setWhileLoopEnd(GOTO whileLoopEnd) {
      this.whileLoopEnd = Objects.requireNonNull(whileLoopEnd, "whileLoopEnd");
      return this;
    }

    /**
     * Initializes the optional value {@link ByteCodeStateIF#getWhileLoopEnd() whileLoopEnd} to whileLoopEnd.
     * @param whileLoopEnd The value for whileLoopEnd
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setWhileLoopEnd(Optional<? extends GOTO> whileLoopEnd) {
      this.whileLoopEnd = whileLoopEnd.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link ByteCodeStateIF#getWhileLoopStart() whileLoopStart} to whileLoopStart.
     * @param whileLoopStart The value for whileLoopStart
     * @return {@code this} builder for chained invocation
     */
    public final Builder setWhileLoopStart(GOTO whileLoopStart) {
      this.whileLoopStart = Objects.requireNonNull(whileLoopStart, "whileLoopStart");
      return this;
    }

    /**
     * Initializes the optional value {@link ByteCodeStateIF#getWhileLoopStart() whileLoopStart} to whileLoopStart.
     * @param whileLoopStart The value for whileLoopStart
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setWhileLoopStart(Optional<? extends GOTO> whileLoopStart) {
      this.whileLoopStart = whileLoopStart.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ByteCodeState ByteCodeState}.
     * @return An immutable instance of ByteCodeState
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ByteCodeState build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ByteCodeState(instructionList, classMap.build(), constantPoolGen, whileLoopEnd, whileLoopStart);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_INSTRUCTION_LIST) != 0) attributes.add("instructionList");
      if ((initBits & INIT_BIT_CONSTANT_POOL_GEN) != 0) attributes.add("constantPoolGen");
      return "Cannot build ByteCodeState, some of required attributes are not set " + attributes;
    }
  }
}
