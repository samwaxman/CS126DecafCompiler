package astPojos;

import org.apache.bcel.generic.*;
import staticchecks.StaticChecksHelper;
import staticchecks.StaticState;
import staticchecks.resolvedInfo.ArrayType;
import staticchecks.resolvedInfo.ClassType;
import staticchecks.resolvedInfo.PrimitiveType;
import staticchecks.resolvedInfo.ResolvedType;

import java.util.Map;

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
        throw new RuntimeException("Expected " + expectedType + " for operator " + operator + " but received " + receivedType + ".");
    }

    @Override
    public InstructionHandle toBytecode(Map<String, ClassGen> javaClassMap, InstructionList il, ConstantPoolGen cp) {
        InstructionHandle start = left.toBytecode(javaClassMap, il, cp);
        right.toBytecode(javaClassMap, il, cp);
        Instruction op = null;
        switch (operator) {
            case "+":
                op = new IADD();
                break;
            case "-":
                op = new ISUB();
                break;
            case "*":
                op = new IMUL();
                break;
            case "/":
                op = new IDIV();
                break;
            case "%":
                op = new IREM();
                break;
            case "&&":
                //TODO: This isn't okay :( needs to short circuit
                op = new IAND();
                break;
            case "||":
                op = new IOR();
                break;

            // default:
            //   throw new RuntimeException("Not yet implemented");
        }
        if (op != null) {
            il.append(op);
            return start;
        }
        boolean negate = false;
        IfInstruction branch = null;
        switch (operator) {
            case "!=":
                negate = true;
            case "==":
                if (left.getType() instanceof ClassType || left.getType() instanceof ArrayType) {
                    branch = new IF_ACMPEQ(null);
                } else {
                    branch = new IF_ICMPEQ(null);
                }
                break;
            case "<":
                negate = true;
            case ">":
                branch = new IF_ICMPGT(null);
                break;
            case "<=":
                negate = true;
            case ">=":
                branch = new IF_ICMPGE(null);
                break;
            default:
                throw new RuntimeException("Unsupported operator");
        }
        if (negate) {
            branch = branch.negate();
        }
        il.append(branch);
        il.append(new ICONST(0));
        GOTO gotoIns = new GOTO(null);
        il.append(gotoIns);
        InstructionHandle trueHandle = il.append(new ICONST(1));
        //TODO: A touch dirty. We need it to point to after the other branch
        //but it can't because there is nothing after the other branch right now
        il.append(new NOP());
        gotoIns.setTarget(trueHandle.getNext());
        branch.setTarget(trueHandle);
        return start;
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
