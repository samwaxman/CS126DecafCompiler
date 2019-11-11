package staticchecks;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import com.sun.istack.internal.Nullable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Generated;
import staticchecks.resolvedInfo.ClassInfo;
import staticchecks.resolvedInfo.ResolvedType;

/**
 * Immutable implementation of {@link StaticStateIF}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code StaticState.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "StaticStateIF"})
public final class StaticState implements StaticStateIF {
  private final @Nullable String currentClass;
  private final ImmutableMap<String, ClassInfo> classes;
  private final ImmutableMap<String, ResolvedType> environment;
  private final boolean insideBreakableStatement;
  private final boolean insideConstructorCall;
  private final ResolvedType returnType;

  private StaticState(StaticState.Builder builder) {
    this.currentClass = builder.currentClass;
    this.classes = builder.classes.build();
    this.environment = builder.environment.build();
    this.returnType = builder.returnType;
    if (builder.insideBreakableStatementIsSet()) {
      initShim.setInsideBreakableStatement(builder.insideBreakableStatement);
    }
    if (builder.insideConstructorCallIsSet()) {
      initShim.setInsideConstructorCall(builder.insideConstructorCall);
    }
    this.insideBreakableStatement = initShim.isInsideBreakableStatement();
    this.insideConstructorCall = initShim.isInsideConstructorCall();
    this.initShim = null;
  }

  private StaticState(
      @Nullable String currentClass,
      ImmutableMap<String, ClassInfo> classes,
      ImmutableMap<String, ResolvedType> environment,
      boolean insideBreakableStatement,
      boolean insideConstructorCall,
      ResolvedType returnType) {
    this.currentClass = currentClass;
    this.classes = classes;
    this.environment = environment;
    this.insideBreakableStatement = insideBreakableStatement;
    this.insideConstructorCall = insideConstructorCall;
    this.returnType = returnType;
    this.initShim = null;
  }

  private static final int STAGE_INITIALIZING = -1;
  private static final int STAGE_UNINITIALIZED = 0;
  private static final int STAGE_INITIALIZED = 1;
  private transient volatile InitShim initShim = new InitShim();

  private final class InitShim {
    private boolean insideBreakableStatement;
    private int insideBreakableStatementBuildStage;

    boolean isInsideBreakableStatement() {
      if (insideBreakableStatementBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (insideBreakableStatementBuildStage == STAGE_UNINITIALIZED) {
        insideBreakableStatementBuildStage = STAGE_INITIALIZING;
        this.insideBreakableStatement = isInsideBreakableStatementInitialize();
        insideBreakableStatementBuildStage = STAGE_INITIALIZED;
      }
      return this.insideBreakableStatement;
    }

    void setInsideBreakableStatement(boolean insideBreakableStatement) {
      this.insideBreakableStatement = insideBreakableStatement;
      insideBreakableStatementBuildStage = STAGE_INITIALIZED;
    }
    private boolean insideConstructorCall;
    private int insideConstructorCallBuildStage;

    boolean isInsideConstructorCall() {
      if (insideConstructorCallBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (insideConstructorCallBuildStage == STAGE_UNINITIALIZED) {
        insideConstructorCallBuildStage = STAGE_INITIALIZING;
        this.insideConstructorCall = isInsideConstructorCallInitialize();
        insideConstructorCallBuildStage = STAGE_INITIALIZED;
      }
      return this.insideConstructorCall;
    }

    void setInsideConstructorCall(boolean insideConstructorCall) {
      this.insideConstructorCall = insideConstructorCall;
      insideConstructorCallBuildStage = STAGE_INITIALIZED;
    }

    private String formatInitCycleMessage() {
      ArrayList<String> attributes = Lists.newArrayList();
      if (insideBreakableStatementBuildStage == STAGE_INITIALIZING) attributes.add("insideBreakableStatement");
      if (insideConstructorCallBuildStage == STAGE_INITIALIZING) attributes.add("insideConstructorCall");
      return "Cannot build StaticState, attribute initializers form cycle" + attributes;
    }
  }

  private boolean isInsideBreakableStatementInitialize() {
    return StaticStateIF.super.isInsideBreakableStatement();
  }

  private boolean isInsideConstructorCallInitialize() {
    return StaticStateIF.super.isInsideConstructorCall();
  }

  /**
   * @return The value of the {@code currentClass} attribute
   */
  @Override
  public @Nullable String getCurrentClass() {
    return currentClass;
  }

  /**
   * @return The value of the {@code classes} attribute
   */
  @Override
  public ImmutableMap<String, ClassInfo> getClasses() {
    return classes;
  }

  /**
   * @return The value of the {@code environment} attribute
   */
  @Override
  public ImmutableMap<String, ResolvedType> getEnvironment() {
    return environment;
  }

  /**
   * @return The value of the {@code insideBreakableStatement} attribute
   */
  @Override
  public boolean isInsideBreakableStatement() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.isInsideBreakableStatement()
        : this.insideBreakableStatement;
  }

  /**
   * @return The value of the {@code insideConstructorCall} attribute
   */
  @Override
  public boolean isInsideConstructorCall() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.isInsideConstructorCall()
        : this.insideConstructorCall;
  }

  /**
   * @return The value of the {@code returnType} attribute
   */
  @Override
  public Optional<ResolvedType> getReturnType() {
    return Optional.ofNullable(returnType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StaticStateIF#getCurrentClass() currentClass} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for currentClass (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final StaticState withCurrentClass(@Nullable String value) {
    if (Objects.equals(this.currentClass, value)) return this;
    return new StaticState(
        value,
        this.classes,
        this.environment,
        this.insideBreakableStatement,
        this.insideConstructorCall,
        this.returnType);
  }

  /**
   * Copy the current immutable object by replacing the {@link StaticStateIF#getClasses() classes} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entries The entries to be added to the classes map
   * @return A modified copy of {@code this} object
   */
  public final StaticState withClasses(Map<String, ? extends ClassInfo> entries) {
    if (this.classes == entries) return this;
    ImmutableMap<String, ClassInfo> newValue = ImmutableMap.copyOf(entries);
    return new StaticState(
        this.currentClass,
        newValue,
        this.environment,
        this.insideBreakableStatement,
        this.insideConstructorCall,
        this.returnType);
  }

  /**
   * Copy the current immutable object by replacing the {@link StaticStateIF#getEnvironment() environment} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entries The entries to be added to the environment map
   * @return A modified copy of {@code this} object
   */
  public final StaticState withEnvironment(Map<String, ? extends ResolvedType> entries) {
    if (this.environment == entries) return this;
    ImmutableMap<String, ResolvedType> newValue = ImmutableMap.copyOf(entries);
    return new StaticState(
        this.currentClass,
        this.classes,
        newValue,
        this.insideBreakableStatement,
        this.insideConstructorCall,
        this.returnType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StaticStateIF#isInsideBreakableStatement() insideBreakableStatement} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for insideBreakableStatement
   * @return A modified copy of the {@code this} object
   */
  public final StaticState withInsideBreakableStatement(boolean value) {
    if (this.insideBreakableStatement == value) return this;
    return new StaticState(
        this.currentClass,
        this.classes,
        this.environment,
        value,
        this.insideConstructorCall,
        this.returnType);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link StaticStateIF#isInsideConstructorCall() insideConstructorCall} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for insideConstructorCall
   * @return A modified copy of the {@code this} object
   */
  public final StaticState withInsideConstructorCall(boolean value) {
    if (this.insideConstructorCall == value) return this;
    return new StaticState(
        this.currentClass,
        this.classes,
        this.environment,
        this.insideBreakableStatement,
        value,
        this.returnType);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link StaticStateIF#getReturnType() returnType} attribute.
   * @param value The value for returnType
   * @return A modified copy of {@code this} object
   */
  public final StaticState withReturnType(ResolvedType value) {
    ResolvedType newValue = Objects.requireNonNull(value, "returnType");
    if (this.returnType == newValue) return this;
    return new StaticState(
        this.currentClass,
        this.classes,
        this.environment,
        this.insideBreakableStatement,
        this.insideConstructorCall,
        newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link StaticStateIF#getReturnType() returnType} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for returnType
   * @return A modified copy of {@code this} object
   */
  public final StaticState withReturnType(Optional<? extends ResolvedType> optional) {
    ResolvedType value = optional.orElse(null);
    if (this.returnType == value) return this;
    return new StaticState(
        this.currentClass,
        this.classes,
        this.environment,
        this.insideBreakableStatement,
        this.insideConstructorCall,
        value);
  }

  /**
   * This instance is equal to all instances of {@code StaticState} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof StaticState
        && equalTo((StaticState) another);
  }

  private boolean equalTo(StaticState another) {
    return Objects.equals(currentClass, another.currentClass)
        && classes.equals(another.classes)
        && environment.equals(another.environment)
        && insideBreakableStatement == another.insideBreakableStatement
        && insideConstructorCall == another.insideConstructorCall
        && Objects.equals(returnType, another.returnType);
  }

  /**
   * Computes a hash code from attributes: {@code currentClass}, {@code classes}, {@code environment}, {@code insideBreakableStatement}, {@code insideConstructorCall}, {@code returnType}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Objects.hashCode(currentClass);
    h += (h << 5) + classes.hashCode();
    h += (h << 5) + environment.hashCode();
    h += (h << 5) + Booleans.hashCode(insideBreakableStatement);
    h += (h << 5) + Booleans.hashCode(insideConstructorCall);
    h += (h << 5) + Objects.hashCode(returnType);
    return h;
  }

  /**
   * Prints the immutable value {@code StaticState} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("StaticState")
        .omitNullValues()
        .add("currentClass", currentClass)
        .add("classes", classes)
        .add("environment", environment)
        .add("insideBreakableStatement", insideBreakableStatement)
        .add("insideConstructorCall", insideConstructorCall)
        .add("returnType", returnType)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link StaticStateIF} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable StaticState instance
   */
  public static StaticState copyOf(StaticStateIF instance) {
    if (instance instanceof StaticState) {
      return (StaticState) instance;
    }
    return StaticState.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link StaticState StaticState}.
   * @return A new StaticState builder
   */
  public static StaticState.Builder builder() {
    return new StaticState.Builder();
  }

  /**
   * Builds instances of type {@link StaticState StaticState}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long OPT_BIT_INSIDE_BREAKABLE_STATEMENT = 0x1L;
    private static final long OPT_BIT_INSIDE_CONSTRUCTOR_CALL = 0x2L;
    private long optBits;

    private String currentClass;
    private ImmutableMap.Builder<String, ClassInfo> classes = ImmutableMap.builder();
    private ImmutableMap.Builder<String, ResolvedType> environment = ImmutableMap.builder();
    private boolean insideBreakableStatement;
    private boolean insideConstructorCall;
    private ResolvedType returnType;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code StaticStateIF} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(StaticStateIF instance) {
      Objects.requireNonNull(instance, "instance");
      @Nullable String currentClassValue = instance.getCurrentClass();
      if (currentClassValue != null) {
        setCurrentClass(currentClassValue);
      }
      putAllClasses(instance.getClasses());
      putAllEnvironment(instance.getEnvironment());
      setInsideBreakableStatement(instance.isInsideBreakableStatement());
      setInsideConstructorCall(instance.isInsideConstructorCall());
      Optional<ResolvedType> returnTypeOptional = instance.getReturnType();
      if (returnTypeOptional.isPresent()) {
        setReturnType(returnTypeOptional);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link StaticStateIF#getCurrentClass() currentClass} attribute.
     * @param currentClass The value for currentClass (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setCurrentClass(@Nullable String currentClass) {
      this.currentClass = currentClass;
      return this;
    }

    /**
     * Put one entry to the {@link StaticStateIF#getClasses() classes} map.
     * @param key The key in the classes map
     * @param value The associated value in the classes map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putClasses(String key, ClassInfo value) {
      this.classes.put(key, value);
      return this;
    }

    /**
     * Put one entry to the {@link StaticStateIF#getClasses() classes} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putClasses(Map.Entry<String, ? extends ClassInfo> entry) {
      this.classes.put(entry);
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link StaticStateIF#getClasses() classes} map. Nulls are not permitted
     * @param classes The entries that will be added to the classes map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setClasses(Map<String, ? extends ClassInfo> classes) {
      this.classes = ImmutableMap.builder();
      return putAllClasses(classes);
    }

    /**
     * Put all mappings from the specified map as entries to {@link StaticStateIF#getClasses() classes} map. Nulls are not permitted
     * @param classes The entries that will be added to the classes map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllClasses(Map<String, ? extends ClassInfo> classes) {
      this.classes.putAll(classes);
      return this;
    }

    /**
     * Put one entry to the {@link StaticStateIF#getEnvironment() environment} map.
     * @param key The key in the environment map
     * @param value The associated value in the environment map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putEnvironment(String key, ResolvedType value) {
      this.environment.put(key, value);
      return this;
    }

    /**
     * Put one entry to the {@link StaticStateIF#getEnvironment() environment} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putEnvironment(Map.Entry<String, ? extends ResolvedType> entry) {
      this.environment.put(entry);
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link StaticStateIF#getEnvironment() environment} map. Nulls are not permitted
     * @param environment The entries that will be added to the environment map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setEnvironment(Map<String, ? extends ResolvedType> environment) {
      this.environment = ImmutableMap.builder();
      return putAllEnvironment(environment);
    }

    /**
     * Put all mappings from the specified map as entries to {@link StaticStateIF#getEnvironment() environment} map. Nulls are not permitted
     * @param environment The entries that will be added to the environment map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllEnvironment(Map<String, ? extends ResolvedType> environment) {
      this.environment.putAll(environment);
      return this;
    }

    /**
     * Initializes the value for the {@link StaticStateIF#isInsideBreakableStatement() insideBreakableStatement} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link StaticStateIF#isInsideBreakableStatement() insideBreakableStatement}.</em>
     * @param insideBreakableStatement The value for insideBreakableStatement 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setInsideBreakableStatement(boolean insideBreakableStatement) {
      this.insideBreakableStatement = insideBreakableStatement;
      optBits |= OPT_BIT_INSIDE_BREAKABLE_STATEMENT;
      return this;
    }

    /**
     * Initializes the value for the {@link StaticStateIF#isInsideConstructorCall() insideConstructorCall} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link StaticStateIF#isInsideConstructorCall() insideConstructorCall}.</em>
     * @param insideConstructorCall The value for insideConstructorCall 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setInsideConstructorCall(boolean insideConstructorCall) {
      this.insideConstructorCall = insideConstructorCall;
      optBits |= OPT_BIT_INSIDE_CONSTRUCTOR_CALL;
      return this;
    }

    /**
     * Initializes the optional value {@link StaticStateIF#getReturnType() returnType} to returnType.
     * @param returnType The value for returnType
     * @return {@code this} builder for chained invocation
     */
    public final Builder setReturnType(ResolvedType returnType) {
      this.returnType = Objects.requireNonNull(returnType, "returnType");
      return this;
    }

    /**
     * Initializes the optional value {@link StaticStateIF#getReturnType() returnType} to returnType.
     * @param returnType The value for returnType
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder setReturnType(Optional<? extends ResolvedType> returnType) {
      this.returnType = returnType.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link StaticState StaticState}.
     * @return An immutable instance of StaticState
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public StaticState build() {
      return new StaticState(this);
    }

    private boolean insideBreakableStatementIsSet() {
      return (optBits & OPT_BIT_INSIDE_BREAKABLE_STATEMENT) != 0;
    }

    private boolean insideConstructorCallIsSet() {
      return (optBits & OPT_BIT_INSIDE_CONSTRUCTOR_CALL) != 0;
    }
  }
}