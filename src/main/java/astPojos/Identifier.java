package astPojos;

import bytecode.ByteCodeState;
import bytecode.BytecodeCreator;
import org.apache.bcel.generic.*;
import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.LocalVariableInfo;
import staticchecks.resolvedInfo.ResolvedField;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.Optional;

// It implements fieldResolvable not because it will ALWAYS resolve
// to a field, but rather, if it's not found in the environment,
// it has the potential to.

// TODO: One imagines that if it's a local, it needs to know which local.
// That is, in nested scopes, it must be aware of which local it is.
// I'm not sure to what extent DECAF allows shadowing though, as regular Java
// is pretty strict on when it's possible to shadow already
public class Identifier extends Expression implements FieldResolvable, LValue {
    private final String identifier;
    private String fromClass;
    private Integer index;

    public String getFromClass() {
        return fromClass;
    }

    public Identifier(String identifier) {
        this.identifier = identifier;
    }

    public Optional<ResolvedType> typeCheckSoft(StaticState s) {
        Optional<LocalVariableInfo> info = s.getLocalVariableTable().findVariable(identifier);
        if (info.isPresent()) {
            index = info.get().getIndex();
            return Optional.of(info.get().getType());
        }
        Optional<ResolvedField> field =
                StaticChecksHelper.optionallyResolveField(this,
                                                          s.getCurrentClass(),
                                                          s);
        if (field.isPresent()) {
            return Optional.of(field.get().getType());
        }
        return Optional.empty();
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
       Optional<ResolvedType> resolvedType = typeCheckSoft(s);
       if (!resolvedType.isPresent()) {
           throw new RuntimeException("Unbound identifier: " + identifier);
       }
       return resolvedType.get();
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        //TODO: Make it play nicely with super
         if (fromClass != null) {
             String signature = BytecodeCreator.resolvedTypeToBcelType(getType()).getSignature();
             int fieldIndex = state.getConstantPoolGen().lookupFieldref(fromClass, getFieldName(), signature);
             new This().toBytecode(state);
             state.append(new GETFIELD(fieldIndex));
        }
        assert index != null : "Both fromClass and index were null, meaning identifier was not field access or local.";
        state.append(getType().isRef() ? new ALOAD(index) : new ILOAD(index));
    }

    @Override
    public void bind(ByteCodeState state, Expression expr) {
        assert getIndex() != null || getFromClass() != null;
        expr.toBytecode(state);
        //TODO: Only necessary if this is being used as an expression
        state.append(new DUP());
        if (getIndex() != null) {
            state.append(new ISTORE(getIndex()));
            return;
        }
        //TODO: Same logic as the other FieldResolvable. Merge.
        String fieldTypeSig = BytecodeCreator.resolvedTypeToBcelType(getType()).getSignature();
        int fieldIndex = state.getConstantPoolGen().lookupFieldref(getFromClass(),
                                                                   getFieldName(),
                                                                   fieldTypeSig);
        state.append(new PUTFIELD(fieldIndex));
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getFieldName() {
        return identifier;
    }

    @Override
    public void setFromClass(String fromClass) {
        this.fromClass = fromClass;
    }

    public Integer getIndex() {
        return index;
    }
}
