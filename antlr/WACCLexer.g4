lexer grammar WACCLexer;

//ignore
//EOL: '\r'? '\n' ;
WS: [ \n\t]+ -> skip ;
COMMENTS: '#' ~[\n]* '\n' -> skip ;

//stat nonterminals
BEGIN: 'begin' ;
END: 'end' ;
SKIP: 'skip' ;
EXIT: 'exit' ;
IS: 'is' ;
ASSIGNMENT: '=' ;
READ: 'read' ;
FREE: 'free' ;
RETURN: 'return' ;
PRINT: 'print' ;
PRINTLN: 'println' ;
IF: 'if' ;
THEN: 'then' ;
ELSE: 'else' ;
FI: 'fi' ;
WHILE: 'while' ;
DO: 'do' ;
DONE: 'done' ;
CALL: 'call' ;
NEWPAIR: 'newpair' ;
FST: 'fst' ;
SND: 'snd' ;
NULL: 'null' ;

//identifiers
ID: ( '_' | 'a'..'z' | 'A'..'Z' ) ( '_' | 'a'..'z' | 'A'..'Z' | '0'..'9' )* ;

//numbers
fragment DIGIT: [0-9] ;
INT: DIGIT+ ;

//signs
fragment POS: '+' ;
fragment NEG: '-' ;
INT_SIGN: POS | NEG ;

//booleans
fragment TRUE: 'true' ;
fragment FALSE: 'false' ;
BOOL : TRUE | FALSE ;

//char & string
CHAR: ~[ BACKSLASH | APOSTROPHE | DOUBLEQUOTE ]
    | BACKSLASH ESCAPED_CHAR
    ;
ESCAPED_CHAR: '0' | 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\'' | '\\' ;

//base types
INT_TYPE: 'int' ;
BOOL_TYPE: 'bool' ;
CHAR_TYPE: 'char' ;
STRING_TYPE: 'string' ;
PAIR_TYPE: 'pair' ;

//binary operators
ADD: '+' ;
SUB: '-' ;
MULT: '*' ;
DIV: '/' ;
MOD: '%' ;
AND: '&&' ;
OR: '||' ;
GT: '>' ;
GTE: '>=' ;
LT: '<' ;
LTE: '<=' ;
EQ: '==' ;
NEQ: '!=' ;

//unary operators
NOT: '!' ;
MINUS: '-' ;
ORD: 'ord' ;
CHR: 'chr' ;
LEN: 'len' ;

//brackets
OPEN_PARENTHESES: '(' ;
CLOSE_PARENTHESES: ')' ;
OPEN_SQUARE_BRACKET: '[' ;
CLOSE_SQUARE_BRACKET: ']' ;

//punctuation
COMMA: ',' ;
APOSTROPHE: '\'' ;
DOUBLEQUOTE: '\"' ;
BACKSLASH: '\\' ;
SEMICOLON: ';' ;
