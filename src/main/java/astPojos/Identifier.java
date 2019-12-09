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

public class Identifier extends Expression implements FieldResolvable, LValue {
    private final String identifier;
    private String fromClass;
    private Integer index;

    public String getFromClass() {
        return fromClass;
    }

    public Identifier(String identifier, int line, int column) {
        super(line, column);
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
            StaticChecksHelper.checkPrivacy(field.get().getModifiers(),
                                            s.getCurrentClass(),
                                            fromClass,
                                            identifier,
                                            "field",
                                            s,
                                            this);
            return Optional.of(field.get().getType());
        }
        return Optional.empty();
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
       Optional<ResolvedType> resolvedType = typeCheckSoft(s);
       if (!resolvedType.isPresent()) {
           this.throwCompilerError("Unbound identifier: " + identifier);
       }
       return resolvedType.get();
    }

    @Override
    public void toBytecode(ByteCodeState state) {
         if (fromClass != null) {
             String signature = BytecodeCreator.resolvedTypeToBcelType(getType()).getSignature();
             int fieldIndex = state.getConstantPoolGen().addFieldref(fromClass, getFieldName(), signature);
             new This(this.getLine(), this.getColumn()).toBytecode(state);
             state.append(new GETFIELD(fieldIndex));
             return;
        }
        assert index != null : "Both fromClass and index were null, meaning identifier was not field access or local.";
        state.append(getType().isRef() ? new ALOAD(index) : new ILOAD(index));
    }

    @Override
    public void bind(ByteCodeState state, Expression expr) {
        assert getIndex() != null || getFromClass() != null;
        if (fromClass != null) {
            new This(this.getLine(), this.getColumn()).toBytecode(state);
        }
        expr.toBytecode(state);
        if (getIndex() != null) {
            //TODO: Only necessary if this is being used as an expression
            state.append(new DUP());
            if (expr.getType().isRef()) {
                state.append(new ASTORE(getIndex()));
            } else {
                state.append(new ISTORE(getIndex()));
            }
            return;
        }
        //TODO: Same logic as the other FieldResolvable. Merge.
        state.append(new DUP_X1());
        String fieldTypeSig = BytecodeCreator.resolvedTypeToBcelType(getType()).getSignature();
        int fieldIndex = state.getConstantPoolGen().addFieldref(getFromClass(),
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
