package astPojos;

public class CompileError extends RuntimeException {
    private Integer column;
    private Integer line;
    private String message;

    public CompileError(String message, int line, int column) {
        this.message = message;
        this.line = line;
        this.column = column;
    }

    @Override
    public String getMessage() {
        if (column == null || line == null) {
            return "Compile error in generated code: " + message;
        }
        return "Compile error on line " + line + " column " + column + ": " + message;
    }

    //User error doesn't need a whole stack trace.
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
