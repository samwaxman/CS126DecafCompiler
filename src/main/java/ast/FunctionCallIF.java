package ast;

import org.immutables.value.Value;
import staticchecks.*;
import staticchecks.resolvedInfo.ResolvedMethod;
import staticchecks.resolvedInfo.ResolvedParam;
import staticchecks.resolvedInfo.ResolvedType;
import styles.ImmutableStyle;

import java.util.List;
import java.util.stream.Collectors;

@Value.Immutable
@ImmutableStyle
public interface FunctionCallIF extends Expression {
    List<Expression> getArgs();
    String getFunctionName();

    @Override
    default ResolvedType typeCheck(StaticState s) {
        //TODO: what if the method is private and in a superclass?
        ResolvedMethod m = StaticChecksHelper.resolveMethod(getFunctionName(), s.getCurrentClass(), s);
        List<ResolvedType> argumentTypes = getArgs().stream()
                                                         .map(e -> e.typeCheck(s))
                                                         .collect(Collectors.toList());
        List<ResolvedType> expectedArgumentTypes = m.getArguments().stream()
                                                    .map(ResolvedParam::getType)
                                                    .collect(Collectors.toList());

        StaticChecksHelper.checkIfValidArguments(argumentTypes, expectedArgumentTypes, s);
        //Shouldn't re-resolve per call. Should make a table.
        return m.getReturnType();
}
}
