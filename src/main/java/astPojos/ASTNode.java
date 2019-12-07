package astPojos;

abstract public class ASTNode {
    private Integer line;
    private Integer column;

    protected ASTNode(Integer line, Integer column) {
        this.column = column;
        this.line = line;
    }

    public void throwCompilerError(String message) throws CompileError {
        throw new CompileError(message, line, column);
    }

    protected Integer getLine() {
        return line;
    }

    protected Integer getColumn() {
        return column;
    }
}
