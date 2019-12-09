Decaf Compiler for CS126. Written in java and compiled to Java Bytecode.

No major optimizations done -- just a debugging compiler (S/NC).
The main class is MainClass. Main takes in a single argument which is the path to the file you'd like to compile. The compiler will output a .class file in the same directroy as the original, which can then be run with the standard `java` command. The compiler will also copy IO.class into the directory if it's not aleady there so you can immediately run the compiled file.

Uses ANTLR4 for the lexer/parser and BCEL for java bytecode manipulation.

Tests are in the resources folder, and the compiler passes them all.

