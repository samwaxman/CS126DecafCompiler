package ast;

//Strictly speaking, it does not. An expression with a semicolon can be a statement.
//For ease of coding, we just lop off the semicolon and re-use the expression classes
public interface Expression extends Statement {
}
