package astPojos;

import bytecode.ByteCodeState;
import org.apache.bcel.generic.ARETURN;
import org.apache.bcel.generic.IRETURN;
import org.apache.bcel.generic.RETURN;
import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.Optional;

public class ReturnStatement extends Statement {
    private final Optional<Expression> returnExpression;

    public ReturnStatement(Expression returnExpression) {
        this.returnExpression = Optional.of(returnExpression);
    }

    public ReturnStatement() {
        returnExpression = Optional.empty();
    }

    @Override
    public void typeCheck(StaticState s) {
        // I'm not sure there's a case where this wouldn't be a parse error
        // in DECAF seeing as fields don't have initial values
        if (!s.getReturnType().isPresent()) {
            throw new RuntimeException("Return statement found outside of method body.");
        }
        ResolvedType expectedReturnType = s.getReturnType().get();
        if (!returnExpression.isPresent()) {
            if (expectedReturnType != PrimitiveType.VOID) {
                throw new RuntimeException("Bad return type: Expected " + expectedReturnType +
                                                   " but found void.");
            }
            return;
        }
        ResolvedType returnType = returnExpression.get().typeCheck(s);
        if (!StaticChecksHelper.isSubclass(returnType, expectedReturnType, s)) {
            // of course, should be a static string at the top with string format args
            // but yuck, who wants to do that?
            throw new RuntimeException("Bad return type: Expected " + expectedReturnType +
                                               " but found " + returnType + ".");
        }
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        if (!returnExpression.isPresent()) {
            state.append(new RETURN());
            return;
        }
        returnExpression.get().toBytecode(state);
        state.append(returnExpression.get().getType().isRef() ? new ARETURN() : new IRETURN());
    }

    public Optional<Expression> getReturnExpression() {
        return returnExpression;
    }
}
