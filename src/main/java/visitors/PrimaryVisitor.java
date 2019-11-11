package visitors;

import ast.*;
import grammar.DecafParser;
import grammar.DecafParserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimaryVisitor extends DecafParserBaseVisitor<Expression> {

    @Override
    public Expression visitPrimary(DecafParser.PrimaryContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            return Identifier.builder().setIdentifier(ctx.IDENTIFIER().getText()).build();
        }
        if (ctx.newArrayExpr() != null) {
            return visitNewArrayExpr(ctx.newArrayExpr());
        }
        if (ctx.nonNewArrayExpr() != null) {
            return visitNonNewArrayExpr(ctx.nonNewArrayExpr());
        }
        assert(false);
        return null;
    }

    @Override
    public Expression visitNewArrayExpr(DecafParser.NewArrayExprContext ctx) {
        String baseType = ctx.primitiveType() != null ?
                ctx.primitiveType().getText() :
                ctx.IDENTIFIER().getText();

        List<DecafParser.DimensionContext> dimensions = ctx.dimension();
        ExpressionVisitor expressionVisitor = new ExpressionVisitor();
        return NewArrayExpression.builder()
                                 .setBaseType(baseType)
                                 .setDimensions(dimensions.stream()
                                                          .map(d -> expressionVisitor.visitExpression(d.expression()))
                                                          .collect(Collectors.toList()))
                                 .build();
    }
    @Override
    public Expression visitNonNewArrayExpr(DecafParser.NonNewArrayExprContext ctx) {
        if (ctx.literal() != null) {
            DecafParser.LiteralContext literalContext = ctx.literal();
            if (literalContext.CHARACTER_LITERAL() != null) {
                //   return
            }
            if (literalContext.NULL() != null) {
                return Null.builder().build();
            }
            if (literalContext.TRUE() != null) {
                return True.builder().build();
            }
            if (literalContext.FALSE() != null) {
                return False.builder().build();
            }
            if (literalContext.INTEGER_LITERAL() != null) {
                // If Decaf has a different integer precision than Java (doubtful) we'll want to store as
                // a string or some other data type.
                return IntegerLiteral.builder()
                              .setInt(Integer.parseInt(literalContext.INTEGER_LITERAL().getText(), 10))
                              .build();
            }
            if (literalContext.STRING() != null) {
                // Will need to normalize
                return StringLiteral.builder()
                                    .setString(literalContext.STRING().getText())
                                    .build();
            }
        }
        if (ctx.THIS() != null) {
            // I don't see a reason to not just treat this as a variable as of yet
            return Identifier.builder().setIdentifier(ctx.THIS().getText()).build();
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
                return ConstructorCall.builder()
                        .setClassName(ctx.IDENTIFIER(0).getText())
                        .setArguments(expressions)
                        .build();
            }

            // Simple function call
            // Gets its own node because prior to
            // resolving the function name,
            // we don't know if it's a static call or not,
            // thus we can't just prepend this to it
            if (ctx.getChildCount() == 2) {
                return FunctionCall.builder()
                        .addAllArgs(expressions)
                        .setFunctionName(ctx.IDENTIFIER(0).getText())
                        .build();
            }

            Expression object = null;
            String methodName = ctx.IDENTIFIER(0).getText();;
            if (ctx.SUPER() != null) {
                object = Identifier.builder().setIdentifier("super").build();
            }
            if (ctx.nonNewArrayExpr() != null) {
                object = visitNonNewArrayExpr(ctx.nonNewArrayExpr());
            } else if (ctx.newArrayExpr() != null) {
                object = visitNewArrayExpr(ctx.newArrayExpr());
            } else if (ctx.IDENTIFIER(1) != null) {
                object = Identifier.builder().setIdentifier(ctx.IDENTIFIER(0).getText()).build();
                methodName = ctx.IDENTIFIER(1).getText();
            }
            assert(object != null);
            return MethodCall.builder()
                    .setArguments(expressions)
                    .setObject(object)
                    .setMethodName(methodName)
                    .build();
        }

        if (ctx.dimension() != null) {
            Expression array;
            if (ctx.IDENTIFIER(0) != null) {
                array = Identifier.builder().setIdentifier(ctx.IDENTIFIER(0).getText()).build();
            } else {
                array = visitNonNewArrayExpr(ctx.nonNewArrayExpr());
            }
            ArrayAccess.builder()
                       .setExpr(array)
                       .setIndex(expressionVisitor.visitExpression(ctx.dimension().expression()))
                       .build();
        }

        Expression object;
        String fieldName = ctx.IDENTIFIER(0).getText();
        if (ctx.SUPER() != null) {
            object = Identifier.builder().setIdentifier("super").build();
        } else if (ctx.nonNewArrayExpr() != null) {
            object = visitNonNewArrayExpr(ctx.nonNewArrayExpr());
        } else if (ctx.newArrayExpr() != null) {
            object = visitNewArrayExpr(ctx.newArrayExpr());
        } else {
            object = Identifier.builder().setIdentifier(ctx.IDENTIFIER(0).getText()).build();
            fieldName = ctx.IDENTIFIER(1).getText();
        }
        return FieldAccess.builder()
                .setObject(object)
                .setFieldName(fieldName)
                .build();
    }
}
