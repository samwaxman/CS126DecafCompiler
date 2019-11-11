package ast;

import org.immutables.value.Value;
import staticchecks.*;
import staticchecks.resolvedInfo.ClassInfo;
import staticchecks.resolvedInfo.ResolvedMethod;
import staticchecks.resolvedInfo.ResolvedParam;
import staticchecks.resolvedInfo.ResolvedType;
import styles.ImmutableStyle;

import java.util.List;
import java.util.stream.Collectors;

@Value.Immutable
@ImmutableStyle
public interface ConstructorCallIF extends Expression {
    String getClassName();
    List<Expression> getArguments();

    //A constructor technically returns void, but
    //when used with 'new', the initialized object is returned
    @Override
    default ResolvedType typeCheck(StaticState s) {
        ClassInfo clazz = s.getClasses().get(getClassName());
        if (clazz == null) {
            throw new RuntimeException("Cannot call constructor for " + getClassName() + ". Unknown class.");
        }
        List<ResolvedType> argumentTypes = getArguments().stream()
                                                         .map(e -> e.typeCheck(s))
                                                         .collect(Collectors.toList());
        List<ResolvedType> expectedArgumentTypes = clazz.getConstructor().getArguments().stream()
                                                    .map(ResolvedParam::getType)
                                                    .collect(Collectors.toList());
        StaticChecksHelper.checkIfValidArguments(argumentTypes, expectedArgumentTypes, s);
        return ClassType.builder().setClassName(getClassName()).build();
    }
}
