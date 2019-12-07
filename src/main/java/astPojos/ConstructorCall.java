package astPojos;

import bytecode.ByteCodeState;
import bytecode.BytecodeCreator;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.*;
import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ClassInfo;
import staticchecks.resolvedInfo.ClassType;
import staticchecks.resolvedInfo.ResolvedParam;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.List;
import java.util.stream.Collectors;

public class ConstructorCall extends Expression {
    private final String className;
    private final List<Expression> arguments;

    public ConstructorCall(String className, List<Expression> arguments, int line, int column) {
        super(line, column);
        this.className = className;
        this.arguments = arguments;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        ClassInfo clazz = s.getClasses().get(className);
        if (clazz == null) {
            this.throwCompilerError("Cannot call constructor for " + className + ". Unknown class.");
        }
        List<ResolvedType> argumentTypes = arguments.stream()
                                                         .map(e -> e.typeCheck(s))
                                                         .collect(Collectors.toList());
        List<ResolvedType> expectedArgumentTypes = clazz.getConstructor().getArguments().stream()
                                                        .map(ResolvedParam::getType)
                                                        .collect(Collectors.toList());
        StaticChecksHelper.checkIfValidArguments(argumentTypes, expectedArgumentTypes, s);
        StaticChecksHelper.checkPrivacy(clazz.getConstructor().getModifiers(),
                                        s.getCurrentClass(),
                                        className,
                                        className,
                                        "constructor",
                                        s,
                                        this);
        return ClassType.builder().setClassName(className).build();
    }

    @Override
    public void toBytecode(ByteCodeState state) {
        ClassGen classGen = state.getClassMap().get(className);
        String methodSignature = null;
        //Unlike in real java, there's only one init
        for (Method m : classGen.getMethods()) {
            if (m.getName().equals("<init>")) {
                methodSignature = Type.getMethodSignature(m.getReturnType(), m.getArgumentTypes());
                break;
            }
        }
        assert methodSignature != null;
        Integer initIndex = state.getConstantPoolGen().addMethodref(BytecodeCreator.classNameToBcelName(className),
                                                                    "<init>",
                                                                    methodSignature);
        assert initIndex != -1 : "Class must have constructor";
        state.append(new NEW(state.getConstantPoolGen().lookupClass(BytecodeCreator.classNameToBcelName(className))));
        state.append(new DUP());
        for (Expression a : arguments) {
            a.toBytecode(state);
        }
        state.append(new INVOKESPECIAL(initIndex));
    }

    public String getClassName() {
        return className;
    }

    public List<Expression> getArguments() {
        return arguments;
    }
}
