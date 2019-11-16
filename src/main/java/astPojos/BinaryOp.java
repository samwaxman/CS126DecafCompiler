package astPojos;

import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

public class BinaryOp extends Expression {
    private final Expression left;
    private final Expression right;
    private final String operator;

    public BinaryOp(Expression left, Expression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    protected ResolvedType typeCheckCore(StaticState s) {
        ResolvedType leftType = left.typeCheck(s);
        ResolvedType rightType = right.typeCheck(s);

        switch (operator) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                return binaryOpCheck(operator,
                                     PrimitiveType.INT,
                                     PrimitiveType.INT,
                                     PrimitiveType.INT,
                                     leftType,
                                     rightType);
            case ">":
            case "<":
            case ">=":
            case "<=":
                return binaryOpCheck(operator,
                                     PrimitiveType.BOOLEAN,
                                     PrimitiveType.INT,
                                     PrimitiveType.INT,
                                     leftType,
                                     rightType);
            case "&&":
            case "||":
                return binaryOpCheck(operator,
                                     PrimitiveType.BOOLEAN,
                                     PrimitiveType.BOOLEAN,
                                     PrimitiveType.BOOLEAN,
                                     leftType,
                                     rightType);
            case "=":
                if (!StaticChecksHelper.isLValue(left)) {
                    throw new RuntimeException("Attempted to assign to an expression which was not an l-value.");
                }
                if (!(StaticChecksHelper.isSubclass(rightType, leftType, s))) {
                    throw new RuntimeException("Invalid types for assignment. The left hand side was a " + leftType +
                                                       " but the right was a " + rightType + ".");
                }
                return rightType;
            case "==":
            case "!=":
                if (!(StaticChecksHelper.isSubclass(leftType, rightType, s) ||
                        StaticChecksHelper.isSubclass(rightType, leftType, s))) {
                    throw new RuntimeException("Invalid types for operator " + operator + ". Both operands must " +
                                                       "be of equal type or one must be a subclass of the other.");
                }
                return PrimitiveType.BOOLEAN;
        }
        assert false : "Should have returned by now.";
        return null;
    }

    static ResolvedType binaryOpCheck(String operator,
                                      ResolvedType toReturn,
                                      ResolvedType expectedLeftType,
                                      ResolvedType expectedRightType,
                                      ResolvedType leftType,
                                      ResolvedType rightType) {
        if (leftType == expectedLeftType) {
            if (rightType == expectedRightType) {
                return toReturn;
            }
            throwTypeException(operator, expectedRightType, rightType);
        }
        throwTypeException(operator, expectedLeftType, leftType);
        assert false : "Should have thrown an exception.";
        return null;
    }

    // Bad form -- should make this an abstract immutable and make this private
    static void throwTypeException(String operator, ResolvedType expectedType, ResolvedType receivedType) throws RuntimeException {
        throw new RuntimeException("Expected " + expectedType + " for operator " + operator + " but received " + receivedType +".");
    }


    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public String getOperator() {
        return operator;
    }
}
