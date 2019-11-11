package ast;

import grammar.DecafParser;
import org.immutables.value.Value;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface ParamIF {
    String getName();
    Type getType();

    static Param createParam(Type type, DecafParser.VarDeclaratorIdContext varID) {
        int arrayLevel = 0;
        while (varID.varDeclaratorId() != null) {
            varID = varID.varDeclaratorId();
            arrayLevel++;
        }
        return Param.builder()
                .setName(varID.IDENTIFIER().getText())
                .setType(type.withArrayLevel(type.getArrayLevel() + arrayLevel))
                .build();
    }
}
