package astPojos;

import bytecode.ByteCodeState;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;

import java.util.Collections;
import java.util.List;

public class BlockStatement extends Statement {
    private final List<Statement> statements;

    public BlockStatement(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public void typeCheck(StaticState s) {
        //TODO: this is a wasteful way of passing the firstInConstructorCall information on.
        // optimize it.
        s.getLocalVariableTable().enterBlock();
        boolean missingReturn = s.isTopLevelBlock();
        boolean missingSuper = s.isFirstStatementInConstructorCall();
        StaticState newState = s.withFirstStatementInConstructorCall(false)
                                .withTopLevelBlock(false);
        if (!statements.isEmpty()) {
            missingReturn = s.isTopLevelBlock() &&
                    !(statements.get(statements.size() - 1) instanceof ReturnStatement);
            missingSuper = s.isFirstStatementInConstructorCall() &&
                    !(statements.get(0) instanceof SuperConstructorCall);
            statements.get(0).typeCheck(s.withTopLevelBlock(false));
            for (int i = 1; i < statements.size(); i++) {
                statements.get(i).typeCheck(newState);
            }
        }
        if (missingSuper) {
            SuperConstructorCall superCall =  new SuperConstructorCall(Collections.emptyList());
            superCall.typeCheck(s);
            statements.add(0, superCall);
        }
        if (missingReturn) {
            assert s.getReturnType().isPresent();
            if (s.getReturnType().get() != PrimitiveType.VOID) {
                throw new RuntimeException("Expected return statement at end of method.");
            }
            ReturnStatement returnStatement = new ReturnStatement();
            //Does nothing, but better to be safe in case new stuff gets added.
            returnStatement.typeCheck(newState);
            statements.add(returnStatement);
        }
        s.getLocalVariableTable().exitBlock();
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        for (Statement s : statements) {
            s.toBytecode(state);
        }
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
