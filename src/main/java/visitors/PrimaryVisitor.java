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
                return new CharacterLiteral(toChar(literalContext.CHARACTER_LITERAL().getText()));
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
                return new StringLiteral(normalizeString(literalContext.STRING().getText()));
            }
        }
        if (ctx.THIS() != null) {
            return new This();
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

            if (ctx.SUPER() != null) {
                object = new Super();
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
            object = new Super();
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

    private static String normalizeString(String str) {
        StringBuilder builder = new StringBuilder();
        boolean escaped = false;
        // Trim off the double quotes.
        assert str.length() >= 2;
        String trimmed = str.substring(1, str.length() - 1);
        for (Character character : trimmed.toCharArray()) {
            if (escaped && character == 't') {
                escaped = false;
                builder.append('\t');
                continue;
            }
            if (escaped && character == 'n') {
                escaped = false;
                builder.append('\n');
                continue;
            }
            if (escaped && character == 'r') {
                escaped = false;
                builder.append('\r');
                continue;
            }
            if (escaped) {
                escaped = false;
                builder.append(character);
                continue;
            }
            if (character == '\\') {
                escaped = true;
                continue;
            }

            builder.append(character);
        }
        return builder.toString();
    }

    private static char toChar(String c) {
        assert c.length() >= 3;
        // trim off single quotes
        c = c.substring(1, c.length() - 1);
        if (c.length() == 1) {
            return c.charAt(0);
        }
        // Either a single char or an escaped char
        assert c.length() == 2 && c.charAt(0) == '\\';
        if (c.charAt(1) == 't') {
            return '\t';
        }
        if (c.charAt(1) == 'n') {
            return '\n';
        }
        //TODO: Not in the decaf spec, so maybe remove later
        if (c.charAt(1) == 'r') {
            return '\r';
        }
        return c.charAt(1);
    }
}
