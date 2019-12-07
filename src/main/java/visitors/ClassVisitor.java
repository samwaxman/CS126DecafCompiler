package visitors;

import ast.ClassASTNode;
import ast.Constructor;
import ast.Method;
import astPojos.CompileError;
import grammar.DecafParser;
import grammar.DecafParserBaseVisitor;

public class ClassVisitor extends DecafParserBaseVisitor<ClassASTNode> {

    @Override
    public ClassASTNode visitClassRule(DecafParser.ClassRuleContext ctx) {
        ClassASTNode.Builder classBuilder = ClassASTNode.builder();
        classBuilder.setClassName(ctx.IDENTIFIER().getText());
        DecafParser.SuperRuleContext superRuleContext = ctx.superRule();
        if (superRuleContext != null) {
            classBuilder.setSuper(superRuleContext.IDENTIFIER().getText());
        }
        MethodVisitor methodVisitor = new MethodVisitor();
        FieldVisitor fieldVisitor = new FieldVisitor();
        ConstructorVisitor constructorVisitor = new ConstructorVisitor();
        boolean setConstructor = false;
        for (DecafParser.MemberContext member : ctx.member()) {
            if (member.method() != null) {
                Method method = methodVisitor.visitMethod(member.method());
                if (method.getMethodName().equals(ctx.IDENTIFIER().getText())) {
                    throw new CompileError("Method name is identical to class name. " +
                                                   "Method conflicts with constructor. " + "" +
                                                   "If you're attempting to make a constructor, delete the return type.",
                                           ctx.getStart().getLine(),
                                           ctx.getStart().getCharPositionInLine());
                }
                classBuilder.addMethods(methodVisitor.visitMethod(member.method()));
            } else if (member.field() != null) {
                classBuilder.addAllFields(fieldVisitor.visitField(member.field()));
            } else {
                if (setConstructor) {
                    throw new CompileError("Multiple class constructors for " +
                                                   ctx.IDENTIFIER().getText() +
                                                   " Cannot overload constructors.",
                                           ctx.getStart().getLine(),
                                           ctx.getStart().getCharPositionInLine());
                }
                setConstructor = true;
                Constructor constructor = constructorVisitor.visitCtor(member.ctor());
                if (!((member.ctor().IDENTIFIER().getText()).equals(ctx.IDENTIFIER().getText()))) {
                    throw new CompileError("Constructor must have the same name as the class. " +
                                                   "Alternatively, you may have forgotten to write a return type " +
                                                   "for your method.",
                                           ctx.getStart().getLine(),
                                           ctx.getStart().getCharPositionInLine());
                }
                classBuilder.setConstructor(constructor);
            }
        }

        return classBuilder.build();
    }
}
