package astPojos;

import ast.Type;
import bytecode.ByteCodeState;
import org.apache.bcel.generic.ASTORE;
import org.apache.bcel.generic.ISTORE;
import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.Optional;

public class VariableDeclarationStatement extends Statement {
    private final String variableName;
    private final Optional<Expression> initialValue;
    private final Type type;
    private ResolvedType resolvedType;
    private Integer index;

    public VariableDeclarationStatement(String variableName,
                                        Optional<Expression> initialValue,
                                        Type type) {
        this.variableName = variableName;
        this.initialValue = initialValue;
        this.type = type;
    }

    @Override
    public void typeCheck(StaticState s) {
        ResolvedType variableType = StaticChecksHelper.resolveType(type, s);
        resolvedType = variableType;
        if (initialValue.isPresent()) {
            ResolvedType initialValueType = initialValue.get().typeCheck(s);
            if (!StaticChecksHelper.isSubclass(initialValueType, variableType, s)) {
                throw new RuntimeException("Invalid assignment. Attempted to assign a " +
                                                   initialValueType + " to a " +
                                                   variableType + ".");
            }
        }
        s.getLocalVariableTable().addLocalVariable(this);
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        initialValue.ifPresent(iv -> {
            iv.toBytecode(state);
            state.append(resolvedType.isRef() ? new ASTORE(index) : new ISTORE(index));
        });
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getVariableName() {
        return variableName;
    }

    public Optional<Expression> getInitialValue() {
        return initialValue;
    }

    public Type getType() {
        return type;
    }

    public ResolvedType getResolvedType() {
        return resolvedType;
    }

    public void setResolvedType(ResolvedType resolvedType) {
        this.resolvedType = resolvedType;
    }
}
