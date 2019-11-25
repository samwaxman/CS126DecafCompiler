lexer grammar DecafLexer;

WHITESPACE: (' ' | '\t' | '\n' | '\r') -> skip;

//KEYWORDS
BREAK: 'break' ;
CLASS: 'class' ;
CONTINUE: 'continue' ;
ELSE: 'else' ;
EXTENDS: 'extends' ;
IF: 'if' ;
NEW: 'new' ;
PRIVATE: 'private' ;
PROTECTED: 'protected' ;
PUBLIC: 'public' ;
RETURN: 'return' ;
STATIC: 'static' ;
SUPER: 'super' ;
THIS: 'this' ;
WHILE: 'while' ;

//TYPES
BOOLEAN: 'boolean' ;
CHAR: 'char' ;
INT: 'int' ;
VOID: 'void' ;

//FORBIDDEN

ABSTRACT: 'abstract' ;
BYTE: 'byte' ;
CASE: 'case' ;
CATCH: 'catch' ;
CONST: 'const' ;
DEFAULT: 'default' ;
DO: 'do' ;
DOUBLE: 'double' ;
FINAL: 'final' ;
FINALLY: 'finally' ;
FOR: 'for' ;
IMPLEMENTS: 'implements' ;
IMPORT: 'import' ;
INSTANCEOF: 'instanceof' ;
INTERFACE: 'interface' ;
LONG: 'long' ;
NATIVE: 'native' ;
GOTO: 'goto' ;
PACKAGE: 'package' ;
SHORT: 'short' ;
SWITCH: 'switch' ;
SYNCRHONIZED: 'synchronized' ;
THROW: 'throw' ;
THROWS: 'throws' ;
TRANSIENT: 'transient' ;
TRY: 'try' ;
VOLATILE: 'volatile' ;
BYVALUE: 'byvalue' ;
CAST: 'cast' ;
FUTURE: 'future' ;
GENERIC: 'generic' ;
INNER: 'inner' ;
NONE: 'none' ;
OPERATOR: 'operator' ;
OUTER: 'outer' ;
REST: 'rest' ;
VAR: 'var' ;

//Literals
TRUE: 'true' ;
FALSE: 'false' ;
NULL: 'null' ;

fragment IdentifierStart
  : '_'
  | [a-zA-Z] ;//FOR NOW WE USE BASIC LETTERS
fragment IdentifierContinue
  : IdentifierStart
  | [0-9] ;

IDENTIFIER: IdentifierStart (IdentifierContinue)* ;

fragment MultiLineCommentStart: '/*';
fragment MultilineCommentEnd: '*/';
fragment MultiLineComment: MultiLineCommentStart .*? MultilineCommentEnd; // WILL MATCH /* .. */ ... */ ( I think)/

COMMENT: (MultiLineComment | ('//' .*? '\n')) -> skip;

INTEGER_LITERAL: '0' | (('1'..'9') ('0'..'9')*) ;


fragment ESCAPED_CHAR: '\'\\' . '\'' ;
fragment REGULAR_CHAR: '\'' ~('\'') '\'' ; //RESEARCH ! Is the ASCII newline different from \n? If so, this needs to exclude it
CHARACTER_LITERAL: ESCAPED_CHAR | REGULAR_CHAR;

fragment EscapedDoubleQuote: ('\\\\')* '\\"' ;
STRING: '"' (~('\n' | '"') | EscapedDoubleQuote)* '"';

//Punctuation

LEFT_PAREN: '(' ;
RIGHT_PAREN: ')' ;
LEFT_BRACE: '{' ;
RIGHT_BRACE: '}' ;
LEFT_BRACKET: '[' ;
RIGHT_BRACKET: ']' ;
SEMICOLON: ';' ;
COMMA: ',' ;
DOT: '.' ;

//Operators

BIND: '=' ;
GREATER_THAN: '>' ;
LESS_THAN: '<' ;
BANG: '!' ;
EQUAL: '==' ;
GREATER_THAN_OR_EQUAL_TO: '>=' ;
LESS_THAN_OR_EQUAL_TO: '<=' ;
NOT_EQUAL: '!=' ;
PLUS: '+' ;
MINUS: '-' ;
TIMES: '*' ;
DIVIDE: '/' ;
AND: '&&' ;
OR: '||' ;
MOD: '%' ;

//FORBIDDEN OPERATORS
TILDE: '~' ;
QUESTION_MARK: '?' ;
COLON: ':' ;
PLUS_PLUS: '++';
MINUS_MINUS: '--';
AMPERSAND: '&';
VERTICAL_BAR: '|';
CARET: '^';
SHIFT_LEFT: '<<' ;
SHIFT_RIGHT: '>>' ;
SHIFT_RIGHT_FILL: '>>>' ;
PLUS_EQUALS: '+=';
MINUS_EQUALS: '-=';
TIMES_EQUALS: '*=' ;
DIVIDE_EQUALS: '/=';
AMPERSAND_EQUALS: '&=';
VERTICAL_BAR_EQUALS: '|=';
CARET_EQUALS: '^=';
PERCENT_EQUALS: '%=';
SHIFT_LEFT_EQUALS: '<<=';
SHIFT_RIGHT_EQUALS: '>>=';
SHIFT_RIGHT_FILL_EQUALS: '>>>=';