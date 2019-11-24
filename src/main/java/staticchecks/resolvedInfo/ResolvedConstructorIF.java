package staticchecks.resolvedInfo;

import ast.Modifier;
import astPojos.BlockStatement;
import astPojos.ReturnStatement;
import astPojos.SuperConstructorCall;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Value.Immutable
@ImmutableStyle
public interface ResolvedConstructorIF {
    List<ResolvedParam> getArguments();
    BlockStatement getBody();
    Set<Modifier> getModifiers();

    ResolvedConstructor defaultConstructor =
            ResolvedConstructor.builder()
                               .setBody(new BlockStatement(
                                       Lists.newArrayList(new SuperConstructorCall(new ArrayList<>()),
                                       new ReturnStatement())))
                               .setModifiers(ImmutableSet.of(Modifier.PUBLIC))
                               .build();

}
