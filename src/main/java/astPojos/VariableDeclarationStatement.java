package astPojos;

import ast.Type;
import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.Optional;

public class VariableDeclarationStatement extends Statement {
    private final String variableName;
    private final Optional<Expression> initialValue;
    private final Type type;

    public VariableDeclarationStatement(String variableName,
                                        Optional<Expression> initialValue,
                                        Type type) {
        this.variableName = variableName;
        this.initialValue = initialValue;
        this.type = type;
    }

    @Override
    public void typeCheck(StaticState s) {
        //TODO: Probably need to rethink the enivornment
        //This isn't like Racket where the AST node for a binding
        //explictly has its scope built into it.
        //Will need to push and pop current scopes onto and off off the
        //static state
        ResolvedType variableType = StaticChecksHelper.resolveType(type, s);
        if (initialValue.isPresent()) {
            ResolvedType initialValueType = initialValue.get().typeCheck(s);
            if (!StaticChecksHelper.isSubclass(initialValueType, variableType, s)) {
                throw new RuntimeException("Invalid assignment. Attempted to assign a " +
                                                   initialValueType + " to a " +
                                                   variableType + ".");
            }
        }
      //TODO: store in environment
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
}
