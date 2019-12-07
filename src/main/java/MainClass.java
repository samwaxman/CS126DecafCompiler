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
import java.nio.file.StandardCopyOption;

public class MainClass {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            throw new RuntimeException("Please input the filepath of " +
                                       "the decaf programs you wish to compile" +
                                       "as the first command line argument.");
        }
        args[0] = "C:\\Users\\Sam\\Documents\\BrownCS\\decafCompiler\\myDecafTests\\WhileTests.decaf";
        System.out.println("Copying IO.class into directory.");
        Path parentDir = FileSystems.getDefault().getPath(args[0]).getParent();
        Path moveTo = FileSystems.getDefault().getPath(parentDir.toString() + "/IO.class");
        //TODO: probably shouldn't replace existing
        Files.copy(FileSystems.getDefault().getPath("io/IO.class"),
                   moveTo,
                   StandardCopyOption.REPLACE_EXISTING);

        CharStream in = CharStreams.fromFileName(args[0]);
        DecafLexer lexer = new DecafLexer(in);
        TokenStream stream = new CommonTokenStream(lexer);
        DecafParser parser = new DecafParser(stream);
        Program p = new ProgramVisitor().visitStart(parser.start());
        BytecodeCreator.toBytecode(p, args[0]);
    }
}
