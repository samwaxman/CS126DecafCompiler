package astPojos;

import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
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
public class Identifier extends Expression implements FieldResolvable {
    private final String identifier;
    private String fromClass;

    public String getFromClass() {
        return fromClass;
    }

    public Identifier(String identifier) {
        this.identifier = identifier;
    }

    public Optional<ResolvedType> typeCheckSoft(StaticState s) {
        ResolvedType t = s.getEnvironment().get(identifier);
        if (t != null) {
            // As mentioned in top TODO, we'll likely need to record
            // which exact local this came from
            return Optional.of(t);
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
}
