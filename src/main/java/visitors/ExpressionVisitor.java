package visitors;


import astPojos.BinaryOp;
import astPojos.Expression;
import astPojos.UnaryOp;
import grammar.DecafParser;
import grammar.DecafParserBaseVisitor;

public class ExpressionVisitor extends DecafParserBaseVisitor<Expression> {

    public Expression visitExpression(DecafParser.ExpressionContext ctx) {
        if (ctx.expression() != null) {
            Expression left = visitExpression(ctx.expression());
            Expression right = visitPrecedence6Op(ctx.precedence6Op());
            return new BinaryOp(left, right, ctx.BIND().getText());
        }
        return visitPrecedence6Op(ctx.precedence6Op());
    }

    public Expression visitPrecedence6Op(DecafParser.Precedence6OpContext ctx) {
        if (ctx.precedence6Op() != null) {
            Expression left = visitPrecedence6Op(ctx.precedence6Op());
            Expression right = visitPrecedence5Op(ctx.precedence5Op());
            return new BinaryOp(left, right, ctx.OR().getText());
        }
        return visitPrecedence5Op(ctx.precedence5Op());
    }

    public Expression visitPrecedence5Op(DecafParser.Precedence5OpContext ctx) {
        if (ctx.precedence5Op() != null) {
            Expression left = visitPrecedence5Op(ctx.precedence5Op());
            Expression right = visitPrecedence4Op(ctx.precedence4Op());
            return new BinaryOp(left, right, ctx.AND().getText());
        }
        return visitPrecedence4Op(ctx.precedence4Op());
    }

    public Expression visitPrecedence4Op(DecafParser.Precedence4OpContext ctx) {
        if (ctx.precedence4Op() != null) {
            Expression left = visitPrecedence4Op(ctx.precedence4Op());
            Expression right = visitPrecedence3Op(ctx.precedence3Op());
            String operator = null;
            // should really use enums and also rule numbers
            if (ctx.EQUAL() != null) {
                operator = ctx.EQUAL().getText();
            } else if (ctx.NOT_EQUAL() != null) {
                operator = ctx.NOT_EQUAL().getText();
            }
            assert operator != null : "Must be equal or not equal operator";
            return new BinaryOp(left, right, operator);
        }
        return visitPrecedence3Op(ctx.precedence3Op());
    }

    public Expression visitPrecedence3Op(DecafParser.Precedence3OpContext ctx) {
        if (ctx.precedence3Op() != null) {
            Expression left = visitPrecedence3Op(ctx.precedence3Op());
            Expression right = visitPrecedence2Op(ctx.precedence2Op());
            String operator = null;
            // should really use enums and also rule numbers
            if (ctx.GREATER_THAN() != null) {
                operator = ctx.GREATER_THAN().getText();
            } else if (ctx.GREATER_THAN_OR_EQUAL_TO() != null) {
                operator = ctx.GREATER_THAN_OR_EQUAL_TO().getText();
            } else if (ctx.LESS_THAN() != null) {
                operator = ctx.LESS_THAN().getText();
            } else if (ctx.LESS_THAN_OR_EQUAL_TO() != null) {
                operator = ctx.LESS_THAN_OR_EQUAL_TO().getText();
            }
            assert operator != null : "Operator should not be null";
            return new BinaryOp(left, right, operator);
        }
        return visitPrecedence2Op(ctx.precedence2Op());
    }

    public Expression visitPrecedence2Op(DecafParser.Precedence2OpContext ctx) {
        if (ctx.precedence2Op() != null) {
            Expression left = visitPrecedence2Op(ctx.precedence2Op());
            Expression right = visitPrecedence1Op(ctx.precedence1Op());
            return new BinaryOp(left,
                                right,
                                ctx.MINUS() != null ? ctx.MINUS().getText() : ctx.PLUS().getText());
        }
        return visitPrecedence1Op(ctx.precedence1Op());
    }

    public Expression visitPrecedence1Op(DecafParser.Precedence1OpContext ctx) {
        if (ctx.precedence1Op() != null) {
            Expression left = visitPrecedence1Op(ctx.precedence1Op());
            Expression right = visitUnaryOp(ctx.unaryOp());
            String operator = null;

            if (ctx.DIVIDE() != null) {
                operator = ctx.DIVIDE().getText();
            } else if (ctx.TIMES() != null) {
                operator = ctx.TIMES().getText();
            } else if (ctx.MOD() != null) {
                operator = ctx.MOD().getText();
            }
            assert operator != null : "Operator should not be null";
            return new BinaryOp(left, right, operator);
        }
        return visitUnaryOp(ctx.unaryOp());
    }

    public Expression visitUnaryOp(DecafParser.UnaryOpContext ctx) {
        if (ctx.unaryOp() != null) {
            Expression arg = visitUnaryOp(ctx.unaryOp());
            String operator = null;

            if (ctx.BANG() != null) {
                operator = ctx.BANG().getText();
            } else if (ctx.PLUS() != null) {
                operator = ctx.PLUS().getText();
            } else if (ctx.MINUS() != null) {
                operator = ctx.MINUS().getText();
            }
            assert operator != null : "Operator should not be null";
            return new UnaryOp(arg, operator);
        }

        return new PrimaryVisitor().visitPrimary(ctx.primary());
    }
}
