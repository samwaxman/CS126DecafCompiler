package visitors;

import ast.*;
import grammar.DecafParser;
import grammar.DecafParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StatementVisitor extends DecafParserBaseVisitor<Statement> {

    @Override
    public Statement visitStatement(DecafParser.StatementContext ctx) {
        if (ctx.block() != null) {
            return visitBlock(ctx.block());
        }
        ExpressionVisitor expressionVisitor = new ExpressionVisitor();
        if (ctx.SUPER() != null) {
            DecafParser.ExprListContext exprList = ctx.actualArgs().exprList();
            List<Expression> expressions = new ArrayList<>();
            while (exprList != null) {
                expressions.add(expressionVisitor.visitExpression(exprList.expression()));
                exprList = exprList.exprList();
            }
            return SuperCall.builder()
                    .setArgs(expressions)
                    .build();
        }

        if (ctx.BREAK() != null) {
            return BreakStatement.builder().build();
        }

        if (ctx.RETURN() != null) {
            if (ctx.expression() != null) {
                return ReturnStatement.builder()
                        .setReturnExpression(expressionVisitor.visitExpression(ctx.expression()))
                        .build();
            }
            return ReturnStatement.builder().build();
        }

        if (ctx.CONTINUE() != null) {
            return ContinueStatement.builder().build();
        }

        if (ctx.WHILE() != null) {
            return WhileStatement.builder()
                    .setTestExpression(expressionVisitor.visitExpression(ctx.expression()))
                    .setBody(visitStatement(ctx.statement(0)))
                    .build();
        }

        if (ctx.getChildCount() == 2 && ctx.expression() != null) {
            return expressionVisitor.visitExpression(ctx.expression());
        }

        if (ctx.IF() != null) {
            IfStatement.Builder ifBuilder = IfStatement.builder()
                    .setCondition(expressionVisitor.visitExpression(ctx.expression()))
                    .setConsequence(visitStatement(ctx.statement(0)));
            if (ctx.ELSE() != null) {
                ifBuilder.setAltern(visitStatement(ctx.statement(1)));
            }
            return ifBuilder.build();
        }

        if (ctx.type() != null) {
            Type type = new TypeVisitor().visitType(ctx.type());
            DecafParser.VarDeclarationListContext varListContext = ctx.varDeclarationList();
            VariableDeclarationList.Builder declarations = VariableDeclarationList.builder();
            while (varListContext != null) {
                VariableDeclarationStatement.Builder declaration = VariableDeclarationStatement.builder();
                DecafParser.VarDeclaratorContext varDeclarator = varListContext.varDeclarator();
                if (varListContext.varDeclarator().BIND() != null) {
                    declaration.setInitialVal(expressionVisitor.visitExpression(varDeclarator.expression()));
                }
                Param param = ParamIF.createParam(type, varDeclarator.varDeclaratorId());
                declarations.addDeclarations(declaration.setVar(param).build());
                varListContext = varListContext.varDeclarationList();
            }
            return declarations.build();
        }

        assert (ctx.getChildCount() == 1 && ctx.SEMICOLON() != null);
        return EmptyStatement.builder().build();
    }

    @Override
    public BlockStatement visitBlock(DecafParser.BlockContext ctx) {
        return BlockStatement.builder()
        .setStatements(ctx.statement().stream().map(this::visitStatement).collect(Collectors.toList()))
        .build();
    }
}
