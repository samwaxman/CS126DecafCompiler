// Generated from C:/Users/Sam/Downloads/langtools-65bfdabaab9c/decafcompiler/src/main/java/grammar\DecafParser.g4 by ANTLR 4.7.2
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DecafParser}.
 */
public interface DecafParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DecafParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(DecafParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(DecafParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#classRule}.
	 * @param ctx the parse tree
	 */
	void enterClassRule(DecafParser.ClassRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#classRule}.
	 * @param ctx the parse tree
	 */
	void exitClassRule(DecafParser.ClassRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#superRule}.
	 * @param ctx the parse tree
	 */
	void enterSuperRule(DecafParser.SuperRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#superRule}.
	 * @param ctx the parse tree
	 */
	void exitSuperRule(DecafParser.SuperRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#member}.
	 * @param ctx the parse tree
	 */
	void enterMember(DecafParser.MemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#member}.
	 * @param ctx the parse tree
	 */
	void exitMember(DecafParser.MemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(DecafParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(DecafParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(DecafParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(DecafParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#ctor}.
	 * @param ctx the parse tree
	 */
	void enterCtor(DecafParser.CtorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#ctor}.
	 * @param ctx the parse tree
	 */
	void exitCtor(DecafParser.CtorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(DecafParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(DecafParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#formalArgs}.
	 * @param ctx the parse tree
	 */
	void enterFormalArgs(DecafParser.FormalArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#formalArgs}.
	 * @param ctx the parse tree
	 */
	void exitFormalArgs(DecafParser.FormalArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#formalArgList}.
	 * @param ctx the parse tree
	 */
	void enterFormalArgList(DecafParser.FormalArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#formalArgList}.
	 * @param ctx the parse tree
	 */
	void exitFormalArgList(DecafParser.FormalArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#formalArg}.
	 * @param ctx the parse tree
	 */
	void enterFormalArg(DecafParser.FormalArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#formalArg}.
	 * @param ctx the parse tree
	 */
	void exitFormalArg(DecafParser.FormalArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(DecafParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(DecafParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(DecafParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(DecafParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#varDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclarationList(DecafParser.VarDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#varDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclarationList(DecafParser.VarDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#varDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclarator(DecafParser.VarDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#varDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclarator(DecafParser.VarDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#varDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaratorId(DecafParser.VarDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#varDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaratorId(DecafParser.VarDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(DecafParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(DecafParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DecafParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DecafParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(DecafParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(DecafParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#precedence6Op}.
	 * @param ctx the parse tree
	 */
	void enterPrecedence6Op(DecafParser.Precedence6OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#precedence6Op}.
	 * @param ctx the parse tree
	 */
	void exitPrecedence6Op(DecafParser.Precedence6OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#precedence5Op}.
	 * @param ctx the parse tree
	 */
	void enterPrecedence5Op(DecafParser.Precedence5OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#precedence5Op}.
	 * @param ctx the parse tree
	 */
	void exitPrecedence5Op(DecafParser.Precedence5OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#precedence4Op}.
	 * @param ctx the parse tree
	 */
	void enterPrecedence4Op(DecafParser.Precedence4OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#precedence4Op}.
	 * @param ctx the parse tree
	 */
	void exitPrecedence4Op(DecafParser.Precedence4OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#precedence3Op}.
	 * @param ctx the parse tree
	 */
	void enterPrecedence3Op(DecafParser.Precedence3OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#precedence3Op}.
	 * @param ctx the parse tree
	 */
	void exitPrecedence3Op(DecafParser.Precedence3OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#precedence2Op}.
	 * @param ctx the parse tree
	 */
	void enterPrecedence2Op(DecafParser.Precedence2OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#precedence2Op}.
	 * @param ctx the parse tree
	 */
	void exitPrecedence2Op(DecafParser.Precedence2OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#precedence1Op}.
	 * @param ctx the parse tree
	 */
	void enterPrecedence1Op(DecafParser.Precedence1OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#precedence1Op}.
	 * @param ctx the parse tree
	 */
	void exitPrecedence1Op(DecafParser.Precedence1OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(DecafParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(DecafParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(DecafParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(DecafParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#newArrayExpr}.
	 * @param ctx the parse tree
	 */
	void enterNewArrayExpr(DecafParser.NewArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#newArrayExpr}.
	 * @param ctx the parse tree
	 */
	void exitNewArrayExpr(DecafParser.NewArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#dimension}.
	 * @param ctx the parse tree
	 */
	void enterDimension(DecafParser.DimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#dimension}.
	 * @param ctx the parse tree
	 */
	void exitDimension(DecafParser.DimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#nonNewArrayExpr}.
	 * @param ctx the parse tree
	 */
	void enterNonNewArrayExpr(DecafParser.NonNewArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#nonNewArrayExpr}.
	 * @param ctx the parse tree
	 */
	void exitNonNewArrayExpr(DecafParser.NonNewArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(DecafParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(DecafParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#actualArgs}.
	 * @param ctx the parse tree
	 */
	void enterActualArgs(DecafParser.ActualArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#actualArgs}.
	 * @param ctx the parse tree
	 */
	void exitActualArgs(DecafParser.ActualArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DecafParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(DecafParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DecafParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(DecafParser.ExprListContext ctx);
}