package astPojos;

import staticchecks.StaticState;
import staticchecks.resolvedInfo.ClassType;
import staticchecks.resolvedInfo.ResolvedType;

public class Null extends Expression {
    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        //I should probs annotate the immutable style to give one
        //parameter immutables Constructor syntax instead of builder syntax

        //TODO: It's not just that it's an Object. It's an object
        //that can be assigned to any class type variable.
        //It'll need special cases.
        return ClassType.builder().setClassName("Object").build();
    }
}
