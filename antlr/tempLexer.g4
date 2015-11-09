lexer grammar tempLexer;

BEGIN: 'begin' ;
END: 'end' ;
SKIP: 'skip' ;
EXIT: 'exit' ;
PRINT: 'print' ;
PRINTLN: 'println' ;
FREE: 'free' ;
RETURN: 'return' ;
READ: 'read' ;
//pair
PAIR: 'pair' ;
FST: 'fst' ;
SND: 'snd' ;
//if
IF: 'if' ;
THEN: 'then' ;
ELSE: 'else' ;
FI: 'fi' ;
//while
WHILE: 'while' ;
DO: 'do' ;
DONE: 'done' ;
//function
IS: 'is' ;
//assigning
CALL: 'call' ;
NEWPAIR: 'newpair' ;

MULT: '*' ;
DIV: '/' ;
MOD: '%' ;
ADD: '+' ;
SUB: '-' ;
GT: '>' ;
GTE: '>=' ;
LT: '<' ;
LTE: '<=' ;
EQ: '==' ;
NEQ: '!=' ;
AND: '&&' ;
OR: '||' ;

NOT: '!' ;
LEN: 'len' ;
ORD: 'ord' ;
CHR: 'chr' ;

//punctuation
SEMICOLON: ';' ;
OPEN_PAR: '(' ;
CLOSE_PAR: ')' ;
OPEN_SQ_BRACK: '[' ;
CLOSE_SQ_BRACK: ']' ;
COMMA: ',' ;
ASSIGN: '=' ;

fragment DIGIT: [0-9] ;
fragment SIGN: SUB | ADD ;
INT_LIT: SIGN? DIGIT+ ;

fragment FALSE: 'false' ;
fragment TRUE: 'true' ;
BOOL_LIT: TRUE | FALSE ;

WS: [ \n\t\r]+ -> skip ;
fragment NEWLINE: '\n' ;
fragment HASH: '#' ;
COMMENTS: HASH ~[\n]* NEWLINE -> skip ;

fragment ESC_CHAR: '0' | 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\'' | '\\' ;
fragment CHARACTER: ~[\\\'\"] | '\\' ESC_CHAR ;
CHAR_LIT: '\'' CHARACTER '\'' ;
STRING_LIT: '\"' (CHARACTER)* '\"' ;

fragment NULL: 'null' ;
PAIR_LIT: NULL ;

//base types
INT: 'int' ;
CHAR: 'char' ;
STRING: 'string' ;
BOOL: 'bool' ;

fragment ALPHABET: [a-zA-Z] ;
ID: ( '_' | ALPHABET ) ( '_' | ALPHABET | DIGIT )* ;

