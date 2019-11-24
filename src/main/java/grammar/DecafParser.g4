parser grammar DecafParser;

options { tokenVocab = DecafLexer; }

start: classRule+;

classRule: CLASS IDENTIFIER superRule? LEFT_BRACE member* RIGHT_BRACE;

superRule: EXTENDS IDENTIFIER;

member: field | method | ctor;

field: modifier* type varDeclarationList SEMICOLON;

method: modifier* type IDENTIFIER formalArgs block;

ctor: modifier* IDENTIFIER formalArgs block;

modifier: STATIC | PUBLIC | PRIVATE | PROTECTED;

formalArgs: LEFT_PAREN formalArgList? RIGHT_PAREN;

formalArgList: formalArg | (formalArg COMMA formalArgList);

formalArg: type varDeclaratorId;

type: primitiveType | IDENTIFIER | type LEFT_BRACKET RIGHT_BRACKET;

primitiveType: BOOLEAN | CHAR | INT | VOID;

varDeclarationList: varDeclarator
| varDeclarator COMMA varDeclarationList;

varDeclarator: varDeclaratorId BIND expression
| varDeclaratorId;

varDeclaratorId: IDENTIFIER |
varDeclaratorId LEFT_BRACKET RIGHT_BRACKET;

block: LEFT_BRACE statement* RIGHT_BRACE;

statement: SEMICOLON |
type varDeclarationList SEMICOLON |
IF LEFT_PAREN expression RIGHT_PAREN statement |
IF LEFT_PAREN expression RIGHT_PAREN statement ELSE statement |
expression SEMICOLON |
WHILE LEFT_PAREN expression RIGHT_PAREN statement |
RETURN expression? SEMICOLON |
CONTINUE SEMICOLON |
BREAK SEMICOLON |
SUPER actualArgs SEMICOLON |
block;



expression:
expression BIND precedence6Op |
precedence6Op;

precedence6Op: precedence6Op OR precedence5Op |
precedence5Op;

precedence5Op: precedence5Op AND precedence4Op |
precedence4Op;

precedence4Op: precedence4Op (EQUAL | NOT_EQUAL) precedence3Op |
precedence3Op;

precedence3Op: precedence3Op (LESS_THAN_OR_EQUAL_TO | GREATER_THAN_OR_EQUAL_TO | LESS_THAN | GREATER_THAN) precedence2Op |
precedence2Op;
precedence2Op: precedence2Op (PLUS | MINUS) precedence1Op |
precedence1Op;
precedence1Op: precedence1Op (MOD | DIVIDE | TIMES) unaryOp |
unaryOp;
unaryOp: (PLUS | MINUS | BANG)unaryOp | primary;

primary: newArrayExpr | nonNewArrayExpr | IDENTIFIER;

newArrayExpr: NEW IDENTIFIER dimension+
| NEW primitiveType dimension+;

dimension: LEFT_BRACKET expression RIGHT_BRACKET;

nonNewArrayExpr: literal |
THIS |
LEFT_PAREN expression RIGHT_PAREN |
NEW IDENTIFIER actualArgs |
IDENTIFIER actualArgs |
nonNewArrayExpr DOT IDENTIFIER actualArgs|
(newArrayExpr | IDENTIFIER) DOT IDENTIFIER actualArgs|
SUPER DOT IDENTIFIER actualArgs |
IDENTIFIER dimension |
nonNewArrayExpr dimension |
SUPER DOT IDENTIFIER |
IDENTIFIER DOT IDENTIFIER |
newArrayExpr DOT IDENTIFIER |
nonNewArrayExpr DOT IDENTIFIER
;


literal: NULL | TRUE | FALSE | INTEGER_LITERAL | CHARACTER_LITERAL | STRING;

actualArgs: LEFT_PAREN exprList? RIGHT_PAREN;

exprList: expression | (expression COMMA exprList);