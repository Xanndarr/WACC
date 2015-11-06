lexer grammar tempLexer;

WS: [ \n\t]+ -> skip ;
fragment HASH: '#' ;
COMMENTS: HASH ~[\n]* '\n' -> skip ;

fragment DIGIT: [0-9] ;
fragment SIGN: '-' | '+' ;
INT_LIT: SIGN? DIGIT+ ;

fragment FALSE: 'false' ;
fragment TRUE: 'true' ;
BOOL_LIT: TRUE | FALSE ;

fragment ESC_CHAR: '0' | 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\'' | '\\' ;
fragment CHARACTER: ~[\\\-\"] | '\\' ESC_CHAR ;
CHAR_LIT: '\'' CHARACTER '\'' ;
STRING_LIT: '"' CHARACTER* '"' ;

BEGIN: 'begin' ;
END: 'end' ;
SKIP: 'skip' ;
EXIT: 'exit' ;
PRINT: 'print' ;
PRINTLN: 'println' ;
FREE: 'free' ;
RETURN: 'return' ;
SEMICOLON: ';' ;
