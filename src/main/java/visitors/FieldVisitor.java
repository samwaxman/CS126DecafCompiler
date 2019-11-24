package visitors;

import ast.*;
import grammar.DecafParser;
import grammar.DecafParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FieldVisitor extends DecafParserBaseVisitor<List<Field>> {

    @Override public List<Field> visitField(DecafParser.FieldContext ctx) {
        Type type = new TypeVisitor().visitType(ctx.type());
        DecafParser.VarDeclarationListContext varListContext = ctx.varDeclarationList();
        List<Field> fields = new ArrayList<>();
        List<Modifier> modifiers = ctx.modifier().stream()
                                      .map(m -> Modifier.valueOf(m.getText().toUpperCase()))
                                      .collect(Collectors.toList());
        while (varListContext != null) {
            if (varListContext.varDeclarator().BIND() != null) {
                throw new RuntimeException("Attempt to give a field an initial value. " +
                                                   "Fields must be initialized via constructor.");
            }
            Param param = ParamIF.createParam(type, varListContext.varDeclarator().varDeclaratorId());
            fields.add(Field.builder()
                            .setModifiers(modifiers)
                            .setParam(param)
                            .build());
            varListContext = varListContext.varDeclarationList();
        }
        return fields;
    }
}
