// Generated from C:/Users/Sam/Downloads/langtools-65bfdabaab9c/decafcompiler/src/main/java/grammar\DecafParser.g4 by ANTLR 4.7.2
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DecafParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DecafParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DecafParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(DecafParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#classRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassRule(DecafParser.ClassRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#superRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperRule(DecafParser.SuperRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember(DecafParser.MemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(DecafParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(DecafParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#ctor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtor(DecafParser.CtorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(DecafParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#formalArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalArgs(DecafParser.FormalArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#formalArgList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalArgList(DecafParser.FormalArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#formalArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalArg(DecafParser.FormalArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(DecafParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#primitiveType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveType(DecafParser.PrimitiveTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#varDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclarationList(DecafParser.VarDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#varDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclarator(DecafParser.VarDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#varDeclaratorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaratorId(DecafParser.VarDeclaratorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(DecafParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(DecafParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(DecafParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#precedence6Op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence6Op(DecafParser.Precedence6OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#precedence5Op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence5Op(DecafParser.Precedence5OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#precedence4Op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence4Op(DecafParser.Precedence4OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#precedence3Op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence3Op(DecafParser.Precedence3OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#precedence2Op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence2Op(DecafParser.Precedence2OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#precedence1Op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecedence1Op(DecafParser.Precedence1OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(DecafParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(DecafParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#newArrayExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewArrayExpr(DecafParser.NewArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#dimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimension(DecafParser.DimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#nonNewArrayExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonNewArrayExpr(DecafParser.NonNewArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(DecafParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#actualArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActualArgs(DecafParser.ActualArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DecafParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(DecafParser.ExprListContext ctx);
}