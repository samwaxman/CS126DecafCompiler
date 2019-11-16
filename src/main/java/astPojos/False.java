package astPojos;

import org.apache.bcel.generic.*;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.Map;

public class False extends LiteralExpression {

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        return PrimitiveType.BOOLEAN;
    }

    @Override
    public InstructionHandle toBytecode(Map<String, ClassGen> javaClassMap, InstructionList il, ConstantPoolGen cp) {
        return il.append(new ICONST(0));
    }
}

