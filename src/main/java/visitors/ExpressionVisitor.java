package visitors;

import ast.BinaryOp;
import ast.Expression;
import ast.UnaryOp;
import grammar.DecafParser;
import grammar.DecafParserBaseVisitor;

public class ExpressionVisitor extends DecafParserBaseVisitor<Expression> {

    public Expression visitExpression(DecafParser.ExpressionContext ctx) {
        if (ctx.expression() != null) {
            return BinaryOp.builder()
                    .setLeft(visitExpression(ctx.expression()))
                    .setRight(visitPrecedence6Op(ctx.precedence6Op()))
                    .setOperator(ctx.BIND().getText())
                    .build();
        }
        return visitPrecedence6Op(ctx.precedence6Op());
    }

    public Expression visitPrecedence6Op(DecafParser.Precedence6OpContext ctx) {
        if (ctx.precedence6Op() != null) {
            return BinaryOp.builder()
                           .setLeft(visitPrecedence6Op(ctx.precedence6Op()))
                           .setRight(visitPrecedence5Op(ctx.precedence5Op()))
                           .setOperator(ctx.OR().getText())
                           .build();
        }
        return visitPrecedence5Op(ctx.precedence5Op());
    }

    public Expression visitPrecedence5Op(DecafParser.Precedence5OpContext ctx) {
        if (ctx.precedence5Op() != null) {
            return BinaryOp.builder()
                           .setLeft(visitPrecedence5Op(ctx.precedence5Op()))
                           .setRight(visitPrecedence4Op(ctx.precedence4Op()))
                           .setOperator(ctx.AND().getText())
                           .build();
        }
        return visitPrecedence4Op(ctx.precedence4Op());
    }

    public Expression visitPrecedence4Op(DecafParser.Precedence4OpContext ctx) {
        if (ctx.precedence4Op() != null) {
            BinaryOp.Builder builder = BinaryOp.builder()
                                               .setLeft(visitPrecedence4Op(ctx.precedence4Op()))
                                               .setRight(visitPrecedence3Op(ctx.precedence3Op()));
            // should really use enums and also rule numbers
            if (ctx.EQUAL() != null) {
                builder.setOperator(ctx.EQUAL().getText());
            } else if (ctx.NOT_EQUAL() != null) {
                builder.setOperator(ctx.NOT_EQUAL().getText());
            }
            return builder.build();
        }
            return visitPrecedence3Op(ctx.precedence3Op());
    }

    public Expression visitPrecedence3Op(DecafParser.Precedence3OpContext ctx) {
        if (ctx.precedence3Op() != null) {
            BinaryOp.Builder builder = BinaryOp.builder()
                           .setLeft(visitPrecedence3Op(ctx.precedence3Op()))
                           .setRight(visitPrecedence2Op(ctx.precedence2Op()));
            // should really use enums and also rule numbers
            if (ctx.GREATER_THAN() != null) {
                builder.setOperator(ctx.GREATER_THAN().getText());
            } else if (ctx.GREATER_THAN_OR_EQUAL_TO() != null) {
                builder.setOperator(ctx.GREATER_THAN_OR_EQUAL_TO().getText());
            } else if (ctx.LESS_THAN() != null) {
                builder.setOperator(ctx.LESS_THAN().getText());
            } else if (ctx.LESS_THAN_OR_EQUAL_TO() != null) {
                builder.setOperator(ctx.LESS_THAN_OR_EQUAL_TO().getText());
            }
            return builder.build();
        }
        return visitPrecedence2Op(ctx.precedence2Op());
    }

    public Expression visitPrecedence2Op(DecafParser.Precedence2OpContext ctx) {
        if (ctx.precedence2Op() != null) {
            return BinaryOp.builder()
                           .setLeft(visitPrecedence2Op(ctx.precedence2Op()))
                           .setRight(visitPrecedence1Op(ctx.precedence1Op()))
                           .setOperator(ctx.MINUS() != null ? ctx.MINUS().getText() : ctx.PLUS().getText())
                           .build();
        }
        return visitPrecedence1Op(ctx.precedence1Op());
    }

    public Expression visitPrecedence1Op(DecafParser.Precedence1OpContext ctx) {
        if (ctx.precedence1Op() != null) {
            BinaryOp.Builder builder = BinaryOp.builder()
                           .setLeft(visitPrecedence1Op(ctx.precedence1Op()))
                           .setRight(visitUnaryOp(ctx.unaryOp()));

            if (ctx.DIVIDE() != null) {
                builder.setOperator(ctx.DIVIDE().getText());
            } else if (ctx.TIMES() != null) {
                builder.setOperator(ctx.TIMES().getText());
            } else if (ctx.MOD() != null) {
                builder.setOperator(ctx.MOD().getText());
            }
            return builder.build();
        }
        return visitUnaryOp(ctx.unaryOp());
    }

    public Expression visitUnaryOp(DecafParser.UnaryOpContext ctx) {
        if (ctx.unaryOp() != null) {
            UnaryOp.Builder builder = UnaryOp.builder()
                   .setExpression(visitUnaryOp(ctx.unaryOp()));

            if (ctx.BANG() != null) {
                builder.setOperator(ctx.BANG().getText());
            } else if (ctx.PLUS() != null) {
                builder.setOperator(ctx.PLUS().getText());
            } else if (ctx.MINUS() != null) {
                builder.setOperator(ctx.MINUS().getText());
            }

            return builder.build();
        }

        return new PrimaryVisitor().visitPrimary(ctx.primary());
    }
}
