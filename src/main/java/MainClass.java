import ast.Program;
import bytecode.BytecodeCreator;
import grammar.DecafLexer;
import grammar.DecafParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import visitors.ProgramVisitor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainClass {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            throw new RuntimeException("Please input the filepath of " +
                                       "the decaf program you wish to compile" +
                                       "as the first command line argument.");
        }

        Path parentDir = FileSystems.getDefault().getPath(args[0]).getParent();
        Path moveTo = FileSystems.getDefault().getPath(parentDir.toString() + "/IO.class");
        if (!moveTo.toFile().exists()) {
            System.out.println("Copying IO.class into directory.");
            Files.copy(FileSystems.getDefault().getPath("io/IO.class"), moveTo);
        }

        CharStream in = CharStreams.fromFileName(args[0]);
        DecafLexer lexer = new DecafLexer(in);
        TokenStream stream = new CommonTokenStream(lexer);
        DecafParser parser = new DecafParser(stream);
        Program p = new ProgramVisitor().visitStart(parser.start());
        BytecodeCreator.toBytecode(p, args[0]);
    }
}
