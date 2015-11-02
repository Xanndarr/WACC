lexer grammar WACCLexer;

//identifiers
ID: [a-zA-Z]+ ;

//numbers
fragment DIGIT: [0-9] ;
INTEGER: DIGIT+ ; 

//misc
NEWLINE:'\r'? '\n' ; 
WS: [ \t]+ -> skip ;

//unary operators
POS: '+' ;
NEG: '-' ;
ORD: 'ord' ;
CHR: 'chr' ;
LEN: 'len' ;

//binary operators
PLUS: '+' ;
MINUS: '-' ;
MULT: '*' ;
DIV: '/' ;
AND: '&&' ;
OR: '||' ;
GT: '>' ;
GTE '>=' ;
LT: '<' ;
LTE: '<=' ;
EQ: '==' ;
NEQ: '!=' ;

//brackets
OPEN_PARENTHESES : '(' ;
CLOSE_PARENTHESES : ')' ;






