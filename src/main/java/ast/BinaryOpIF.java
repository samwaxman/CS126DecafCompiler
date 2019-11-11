package ast;

import org.immutables.value.Value;
import staticchecks.*;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;
import styles.ImmutableStyle;

@Value.Immutable
@ImmutableStyle
public interface BinaryOpIF extends Expression {
    Expression getLeft();
    Expression getRight();
    String getOperator();

    @Override
    default ResolvedType typeCheck(StaticState s) {
        ResolvedType leftType = getLeft().typeCheck(s);
        ResolvedType rightType = getRight().typeCheck(s);

        switch (getOperator()) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                return binaryOpCheck(getOperator(),
                                     PrimitiveType.num,
                                     PrimitiveType.num,
                                     PrimitiveType.num,
                                     leftType,
                                     rightType);
            case ">":
            case "<":
            case ">=":
            case "<=":
                return binaryOpCheck(getOperator(),
                                     PrimitiveType.bool,
                                     PrimitiveType.num,
                                     PrimitiveType.num,
                                     leftType,
                                     rightType);
            case "&&":
            case "||":
                return binaryOpCheck(getOperator(),
                                     PrimitiveType.bool,
                                     PrimitiveType.bool,
                                     PrimitiveType.bool,
                                     leftType,
                                     rightType);
            case "=":
                if (!StaticChecksHelper.isLValue(getLeft())) {
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
                    throw new RuntimeException("Invalid types for operator " + getOperator() + ". Both operands must " +
                    "be of equal type or one must be a subclass of the other.");
                }
                return PrimitiveType.bool;
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
}
