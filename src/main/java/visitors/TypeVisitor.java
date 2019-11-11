package visitors;

import ast.Method;
import ast.Type;
import grammar.DecafParser;
import grammar.DecafParserBaseVisitor;

public class TypeVisitor extends DecafParserBaseVisitor<Type> {
    @Override
    public Type visitType(DecafParser.TypeContext ctx) {
        int arrayLevel = 0;
        DecafParser.TypeContext nestedTypeContext = ctx;
        while (nestedTypeContext.type() != null) {
            nestedTypeContext = nestedTypeContext.type();
            arrayLevel++;
        }
        String typeName;
        if (nestedTypeContext.IDENTIFIER() != null) {
            typeName = nestedTypeContext.IDENTIFIER().getText();
        } else {
            typeName = nestedTypeContext.primitiveType().getText();
        }

        return Type.builder()
                .setArrayLevel(arrayLevel)
                .setTypeIdentifier(typeName)
                .build();
    }
}
