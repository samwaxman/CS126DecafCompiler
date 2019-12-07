package bytecode;

import org.apache.bcel.generic.*;
import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.Map;
import java.util.Optional;

@Value.Immutable
@ImmutableStyle
public interface ByteCodeStateIF {
    InstructionList getInstructionList();
    Map<String, ClassGen> getClassMap();
    ConstantPoolGen getConstantPoolGen();
    // For where to break to.
    Optional<GOTO> getWhileLoopEnd();
    Optional<GOTO> getWhileLoopStart();


    default ClassGen fetchClassGen(String className) {
        if (className.equals("Object")) {
            return getClassMap().get("java.lang.Object");
        } if (className.equals("String")) {
            return getClassMap().get("java.lang.String");
        }
        return getClassMap().get(className);
    }
    default InstructionHandle append(Instruction i) {
        return getInstructionList().append(i);
    }
    default BranchHandle append(BranchInstruction i) {
        return getInstructionList().append(i);
    }
}
