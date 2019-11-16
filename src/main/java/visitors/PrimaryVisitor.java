package visitors;

import ast.Type;
import astPojos.*;
import grammar.DecafParser;
import grammar.DecafParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimaryVisitor extends DecafParserBaseVisitor<Expression> {

    @Override
    public Expression visitPrimary(DecafParser.PrimaryContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            return new Identifier(ctx.IDENTIFIER().getText());
        }
        if (ctx.newArrayExpr() != null) {
            return visitNewArrayExpr(ctx.newArrayExpr());
        }
        if (ctx.nonNewArrayExpr() != null) {
            return visitNonNewArrayExpr(ctx.nonNewArrayExpr());
        }
        assert (false);
        return null;
    }

    @Override
    public Expression visitNewArrayExpr(DecafParser.NewArrayExprContext ctx) {
        //TODO: Not a raw string. Use a type visitor.
        String baseTypeId = ctx.primitiveType() != null ?
                ctx.primitiveType().getText() :
                ctx.IDENTIFIER().getText();

        Type baseType = Type.builder()
                            .setTypeIdentifier(baseTypeId)
                            .build();

        List<DecafParser.DimensionContext> dimensions = ctx.dimension();
        ExpressionVisitor expressionVisitor = new ExpressionVisitor();
        List<Expression> dimensionExpressions = dimensions.stream()
                                                          .map(d -> expressionVisitor.visitExpression(d.expression()))
                                                          .collect(Collectors.toList());
        return new NewArrayExpression(baseType, dimensionExpressions);
    }

    @Override
    public Expression visitNonNewArrayExpr(DecafParser.NonNewArrayExprContext ctx) {
        if (ctx.literal() != null) {
            DecafParser.LiteralContext literalContext = ctx.literal();
            if (literalContext.CHARACTER_LITERAL() != null) {
                //TODO: Extract character from text
                return new CharacterLiteral('a');
            }
            if (literalContext.NULL() != null) {
                return new Null();
            }
            if (literalContext.TRUE() != null) {
                return new True();
            }
            if (literalContext.FALSE() != null) {
                return new False();
            }
            if (literalContext.INTEGER_LITERAL() != null) {
                // If Decaf has a different integer precision than Java (doubtful) we'll want to store as
                // a string or some other data type.
                return new IntegerLiteral(Integer.parseInt(literalContext.INTEGER_LITERAL().getText(), 10));
            }
            if (literalContext.STRING() != null) {
                //TODO: Will need to normalize
                return new StringLiteral(literalContext.STRING().getText());
            }
        }
        if (ctx.THIS() != null) {
            // I don't see a reason to not just treat this as a variable as of yet
            return new Identifier(ctx.THIS().getText());
        }

        ExpressionVisitor expressionVisitor = new ExpressionVisitor();
        //A weak way to check for this if things were extended
        if (ctx.LEFT_PAREN() != null) {
            return expressionVisitor.visitExpression(ctx.expression());
        }

        if (ctx.actualArgs() != null) {
            DecafParser.ExprListContext exprList = ctx.actualArgs().exprList();
            List<Expression> expressions = new ArrayList<>();
            while (exprList != null) {
                expressions.add(expressionVisitor.visitExpression(exprList.expression()));
                exprList = exprList.exprList();
            }

            if (ctx.NEW() != null) {
                return new ConstructorCall(ctx.IDENTIFIER(0).getText(), expressions);
            }

            // Simple function call
            // Gets its own node because prior to
            // resolving the function name,
            // we don't know if it's a static call or not,
            // thus we can't just prepend this to it
            if (ctx.getChildCount() == 2) {
                return new FunctionCall(expressions, ctx.IDENTIFIER(0).getText());
            }

            Expression object = null;
            String methodName = ctx.IDENTIFIER(0).getText();
            ;
            if (ctx.SUPER() != null) {
                object = new Identifier("super");
            }
            if (ctx.nonNewArrayExpr() != null) {
                object = visitNonNewArrayExpr(ctx.nonNewArrayExpr());
            } else if (ctx.newArrayExpr() != null) {
                object = visitNewArrayExpr(ctx.newArrayExpr());
            } else if (ctx.IDENTIFIER(1) != null) {
                object = new Identifier(ctx.IDENTIFIER(0).getText());
                methodName = ctx.IDENTIFIER(1).getText();
            }
            assert (object != null);
            return new MethodCall(object, methodName, expressions);
        }

        if (ctx.dimension() != null) {
            Expression array;
            if (ctx.IDENTIFIER(0) != null) {
                array = new Identifier(ctx.IDENTIFIER(0).getText());
            } else {
                array = visitNonNewArrayExpr(ctx.nonNewArrayExpr());
            }
            return new ArrayAccess(array, expressionVisitor.visitExpression(ctx.dimension().expression()));
        }

        Expression object;
        String fieldName = ctx.IDENTIFIER(0).getText();
        if (ctx.SUPER() != null) {
            object = new Identifier("super");
        } else if (ctx.nonNewArrayExpr() != null) {
            object = visitNonNewArrayExpr(ctx.nonNewArrayExpr());
        } else if (ctx.newArrayExpr() != null) {
            object = visitNewArrayExpr(ctx.newArrayExpr());
        } else {
            object = new Identifier(ctx.IDENTIFIER(0).getText());
            fieldName = ctx.IDENTIFIER(1).getText();
        }
        return new FieldAccess(object, fieldName);
    }
}
