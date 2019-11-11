package visitors;

import ast.Program;
import grammar.DecafParser;
import grammar.DecafParserBaseVisitor;

public class ProgramVisitor extends DecafParserBaseVisitor<Program> {

    @Override public Program visitStart(DecafParser.StartContext ctx) {
        Program.Builder programBuilder = Program.builder();
        ClassVisitor classVisitor = new ClassVisitor();
        for (DecafParser.ClassRuleContext classRule : ctx.classRule()) {
            programBuilder.addClasses(classVisitor.visitClassRule(classRule));
        }
        return programBuilder.build();
    }
}
