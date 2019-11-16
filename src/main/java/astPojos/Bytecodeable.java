package astPojos;

import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;

import java.util.Map;

public interface Bytecodeable {

    default InstructionHandle toBytecode(Map<String, ClassGen> javaClassMap,
                                         InstructionList il,
                                         ConstantPoolGen cp) {
        throw new RuntimeException("toBytecode not implemented");
    }

}
