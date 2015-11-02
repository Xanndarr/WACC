lexer grammar WACCLexer;

//identifiers
ID: ( ' ' | 'a'-'z' | 'A'-'Z' ) ( ' ' | 'a'-'z' | 'A'-'Z' | '0'-'9' )* ;

//numbers
fragment DIGIT: [0-9] ;
INT: DIGIT+ ;
INT_LIT: INT_SIGN? INT ;

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
    | BACKSLASH escaped-char
    ;
ESCAPED_CHAR: '0' | 'b' | 't' | 'n' | 'f' | 'r' | '"' | ''' | `\' ;

//misc
NEWLINE:'\r'? '\n' ; 
WS: [ \t ]+ -> skip ;

//base types
INT_TYPE: 'int' ;
BOOL_TYPE: 'bool' ;
CHAR_TYPE: 'char' ;
STRING_TYPE: 'string' ;
PAIR_TYPE: 'pair' ;

//unary operators
NOT: '!' ;
ORD: 'ord' ;
CHR: 'chr' ;
LEN: 'len' ;

//binary operators
ADD: '+' ;
SUB: '-' ;
MULT: '*' ;
DIV: '/' ;
MOD: '%' ;
AND: '&&' ;
OR: '||' ;
GT: '>' ;
GTE '>=' ;
LT: '<' ;
LTE: '<=' ;
EQ: '==' ;
NEQ: '!=' ;

//stat nonterminals
SKIP: 'skip' ;
ASSIGNMENT: '=' ;
READ: 'read' ;
FREE: 'free' ;
RETURN: 'return' ;
EXIT: 'exit' ;
PRINT: 'print' ;
PRINTLN: 'println' ;
IF: 'if' ;
THEN: 'then' ;
ELSE: 'else' ;
FI: 'fi' ;
WHILE: 'while' ;
DO: 'do' ;
DONE: 'done' ;
BEGIN: 'begin' ;
END: 'end' ;
CALL: 'call' ;
NEWPAIR: 'newpair' ;
FST: 'fst' ;
SND: 'snd' ;
IS: 'is' ;

//brackets
OPEN_PARENTHESES: '(' ;
CLOSE_PARENTHESES: ')' ;
OPEN_SQUARE_BRACKET: '[' ;
CLOSE_SQUARE_BRACKET: ']' ;

//punctuation
COMMA: ',' ;
APOSTROPHE: ''' ;
DOUBLEQUOTE: '"' ;
BACKSLASH: '/' ;
SEMICOLON: ';' ;
HASH: '#' ;
NULL: 'null' ;

