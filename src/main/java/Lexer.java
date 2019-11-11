import ast.Program;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import grammar.DecafLexer;
import grammar.DecafParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.rpgleparser.RpgParser;
import org.rpgleparser.utils.TreePrinterListener;
import org.rpgleparser.utils.TreeUtils;
import visitors.ProgramVisitor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Lexer {
    public static String printTree(ParseTree parseTree, Parser parser) {
        TreePrinterListener listener = new TreePrinterListener(Arrays.asList(parser.getRuleNames()));
        ParseTreeWalker.DEFAULT.walk(listener, parseTree);
        return listener.toString();
    }

    public static void main(String[] args) throws IOException {

        CharStream in = CharStreams.fromFileName("/Users/Sam/Downloads/decaf/short.decaf");
        DecafLexer lexer = new DecafLexer(in);
        //List<? extends Token> tokens = lexer.getAllTokens();
        //System.out.println(tokens);
        TokenStream stream = new CommonTokenStream(lexer);
        DecafParser parser = new DecafParser(stream);
        Program p = new ProgramVisitor().visitStart(parser.start());
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        System.out.println(gson.toJson(p));
        //ParseTree tree = new RuleContext().;
        //System.out.println(parser.start().getRuleContext());
        //System.out.println(printTree(parser.start(), parser));


    }
}
