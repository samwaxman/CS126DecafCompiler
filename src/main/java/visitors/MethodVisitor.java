package visitors;


import ast.*;
import grammar.DecafParser;
import grammar.DecafParserBaseVisitor;

import java.util.List;
import java.util.stream.Collectors;

public class MethodVisitor extends DecafParserBaseVisitor<Method> {

    @Override
    public Method visitMethod(DecafParser.MethodContext ctx) {
        Method.Builder methodBuilder = Method.builder();
        methodBuilder.setMethodName(ctx.IDENTIFIER().getText());
        DecafParser.FormalArgListContext argList = ctx.formalArgs().formalArgList();
        TypeVisitor typeVisitor = new TypeVisitor();
        while (argList != null) {
            DecafParser.FormalArgContext formalArgContext = argList.formalArg();
            Type argType = typeVisitor.visitType(formalArgContext.type());
            Param param = ParamIF.createParam(argType, formalArgContext.varDeclaratorId());
            methodBuilder.addParams(param);
            argList = argList.formalArgList();
        }
        List<DecafParser.ModifierContext> modifiers = ctx.modifier();
        methodBuilder.setModifiers(modifiers.stream()
                                            .map(m -> Modifier.valueOf(m.getText().toUpperCase()))
                                            .collect(Collectors.toList()));
        methodBuilder.setReturnType(new TypeVisitor().visitType(ctx.type()));
        methodBuilder.setBody(new StatementVisitor().visitBlock(ctx.block()));
        return methodBuilder.build();
    }
}
