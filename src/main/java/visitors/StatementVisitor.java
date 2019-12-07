package visitors;


import ast.Type;
import astPojos.*;
import grammar.DecafParser;
import grammar.DecafParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
            return new SuperConstructorCall(expressions,
                                            ctx.getStart().getLine(),
                                            ctx.getStart().getCharPositionInLine());
        }

        if (ctx.BREAK() != null) {
            return new BreakStatement(ctx.getStart().getLine(),
                                      ctx.getStart().getCharPositionInLine());
        }

        if (ctx.RETURN() != null) {
            if (ctx.expression() != null) {
                return new ReturnStatement(expressionVisitor.visitExpression(ctx.expression()),
                                           ctx.getStart().getLine(),
                                           ctx.getStart().getCharPositionInLine());
            }
            return new ReturnStatement(ctx.getStart().getLine(),
                                       ctx.getStart().getCharPositionInLine());
        }

        if (ctx.CONTINUE() != null) {
            return new ContinueStatement(ctx.getStart().getLine(),
                                         ctx.getStart().getCharPositionInLine());
        }

        if (ctx.WHILE() != null) {
            return new WhileStatement(expressionVisitor.visitExpression(ctx.expression()),
                                      visitStatement(ctx.statement(0)),
                                      ctx.getStart().getLine(),
                                      ctx.getStart().getCharPositionInLine());
        }

        if (ctx.getChildCount() == 2 && ctx.expression() != null) {
            return new ExpressionStatement(expressionVisitor.visitExpression(ctx.expression()),
                                           ctx.getStart().getLine(),
                                           ctx.getStart().getCharPositionInLine());
        }

        if (ctx.IF() != null) {
            Expression condition = expressionVisitor.visitExpression(ctx.expression());
            Statement consequence = visitStatement(ctx.statement(0));
            Optional<Statement> alternate = Optional.empty();
            if (ctx.ELSE() != null) {
                alternate = Optional.of(visitStatement(ctx.statement(1)));
            }
            return new IfStatement(condition, consequence, alternate,
                                   ctx.getStart().getLine(),
                                   ctx.getStart().getCharPositionInLine());
        }

        if (ctx.type() != null) {
            Type type = new TypeVisitor().visitType(ctx.type());
            DecafParser.VarDeclarationListContext varListContext = ctx.varDeclarationList();
            List<VariableDeclarationStatement> declarations = new ArrayList<>();
            while (varListContext != null) {
                DecafParser.VarDeclaratorContext varDeclarator = varListContext.varDeclarator();
                Optional<Expression> initialValue = Optional.empty();
                if (varListContext.varDeclarator().BIND() != null) {
                    initialValue = Optional.of(expressionVisitor.visitExpression(varDeclarator.expression()));
                }
                declarations.add(new VariableDeclarationStatement(varDeclarator.varDeclaratorId().getText(),
                                                                  initialValue,
                                                                  type,
                                                                  ctx.getStart().getLine(),
                                                                  ctx.getStart().getCharPositionInLine()));
                varListContext = varListContext.varDeclarationList();
            }
            return new VariableDeclaratorList(declarations,
                                              ctx.getStart().getLine(),
                                              ctx.getStart().getCharPositionInLine());
        }

        assert (ctx.getChildCount() == 1 && ctx.SEMICOLON() != null);
        return new EmptyStatement(ctx.getStart().getLine(),
                                  ctx.getStart().getCharPositionInLine());
    }

    @Override
    public BlockStatement visitBlock(DecafParser.BlockContext ctx) {
        List<Statement> statements = ctx.statement().stream()
                                        .map(this::visitStatement)
                                        .collect(Collectors.toList());
        return new BlockStatement(statements,
                                  ctx.getStart().getLine(),
                                  ctx.getStart().getCharPositionInLine());
    }
}
