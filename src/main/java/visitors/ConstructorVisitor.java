package visitors;

import ast.*;
import grammar.DecafParser;
import grammar.DecafParserBaseVisitor;

import java.util.List;
import java.util.stream.Collectors;

public class ConstructorVisitor extends DecafParserBaseVisitor<Constructor> {

    @Override
    public Constructor visitCtor(DecafParser.CtorContext ctx) {
        Constructor.Builder constructorBuilder = Constructor.builder();
        DecafParser.FormalArgListContext argList = ctx.formalArgs().formalArgList();
        TypeVisitor typeVisitor = new TypeVisitor();
        while (argList != null) {
            DecafParser.FormalArgContext formalArgContext = argList.formalArg();
            Type argType = typeVisitor.visitType(formalArgContext.type());
            Param param = ParamIF.createParam(argType, formalArgContext.varDeclaratorId());
            constructorBuilder.addParams(param);
            argList = argList.formalArgList();
        }
        List<DecafParser.ModifierContext> modifiers = ctx.modifier();
        constructorBuilder.setModifiers(modifiers.stream()
                                                 .map(m -> Modifier.valueOf(m.getText().toUpperCase()))
                                                 .collect(Collectors.toList()));

        constructorBuilder.setBody(new StatementVisitor().visitBlock(ctx.block()));
        return constructorBuilder.build();
    }
}
