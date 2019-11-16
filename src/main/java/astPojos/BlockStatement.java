package astPojos;

import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import staticchecks.StaticState;

import java.util.List;
import java.util.Map;

public class BlockStatement extends Statement {
    private final List<Statement> statements;

    public BlockStatement(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public void typeCheck(StaticState s) {
        for (Statement statement : statements) {
            statement.typeCheck(s);
        }
    }

    @Override
    public InstructionHandle toBytecode(Map<String, ClassGen> javaClassMap, InstructionList il, ConstantPoolGen cp) {
        int oldLength = il.getLength();
        for (Statement s : statements) {
            s.toBytecode(javaClassMap, il, cp);
        }
        if (il.getLength() == oldLength) {
            return null;
        }
        return il.getInstructionHandles()[oldLength];
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
