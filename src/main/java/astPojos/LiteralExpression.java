package astPojos;

import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.LDC;

public abstract class LiteralExpression extends Expression {
    //TODO: Maybe not needed. Maybe we always put on stack. Coding it up now. Maybe this is deprecated.
    private Integer constantPoolPosition = null;

    protected Integer getConstantPoolPosition() {
        return constantPoolPosition;
    }

    protected void setConstantPoolPosition(Integer constantPoolPosition) {
        this.constantPoolPosition = constantPoolPosition;
    }

    @Override
    //TODO: Maybe deprecated
    public InstructionHandle pushOntoStack(InstructionList instructionList) {
        assert constantPoolPosition != null : "Must call toBytecode before pushing onto stack";
        return instructionList.append(new LDC(getConstantPoolPosition()));
    }
}
