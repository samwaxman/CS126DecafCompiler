package staticchecks.resolvedInfo;

import ast.BlockStatement;
import ast.Modifier;
import ast.SuperCall;
import com.google.common.collect.ImmutableSet;
import org.immutables.value.Value;
import styles.ImmutableStyle;

import java.util.HashSet;
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
                               .setBody(BlockStatement.builder()
                                                      .addStatements(SuperCall.builder().build())
                                                      .build())
                               .setModifiers(ImmutableSet.of(Modifier.PUBLIC))
                               .build();

}
