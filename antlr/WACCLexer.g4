lexer grammar WACCLexer;

//identifiers
ID: [a-zA-Z]+ ;

//numbers
INTEGER: DIGIT+ ; 
fragment DIGIT: [0-9] ;

//misc
NEWLINE:'\r'? '\n' ; 
WS: [ \t]+ -> skip ;

//operators
PLUS: '+' ;
MINUS: '-' ;

//brackets
OPEN_PARENTHESES : '(' ;
CLOSE_PARENTHESES : ')' ;






