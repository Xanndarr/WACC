lexer grammar tempLexer;

BEGIN: 'begin' ;
END: 'end' ;
SKIP: 'skip' ;
EXIT: 'exit' ;
PRINT: 'print' ;
PRINTLN: 'println' ;
FREE: 'free' ;
RETURN: 'return' ;
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

//punctuation
SEMICOLON: ';' ;
OPEN_PAR: '(' ;
CLOSE_PAR: ')' ;
OPEN_SQ_BRACK: '[' ;
CLOSE_SQ_BRACK: ']' ;
COMMA: ',' ;
ASSIGN: '=' ;

WS: [ \n\t]+ -> skip ;
fragment NEWLINE: '\n' ;
fragment HASH: '#' ;
COMMENTS: HASH ~[\n]* NEWLINE -> skip ;

fragment DIGIT: [0-9] ;
fragment SIGN: NEG | ADD ;
INT_LIT: SIGN? DIGIT+ ;

fragment FALSE: 'false' ;
fragment TRUE: 'true' ;
BOOL_LIT: TRUE | FALSE ;

fragment ESC_CHAR: '0' | 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\'' | '\\' ;
fragment CHARACTER: ~[\\\-\"] | '\\' ESC_CHAR ;
CHAR_LIT: '\'' CHARACTER '\'' ;
STRING_LIT: '"' CHARACTER* '"' ;

fragment NULL: 'null' ;
PAIR_LIT: NULL ;

fragment NOT: '!' ;
fragment NEG: '-' ;
fragment LEN: 'len' ;
fragment ORD: 'ord' ;
fragment CHR: 'chr' ;
UNARY_OP: NOT | NEG | LEN | ORD | CHR ;

fragment MULT: '*' ;
fragment DIV: '/' ;
fragment MOD: '%' ;
fragment ADD: '+' ;
fragment SUB: '-' ;
fragment GT: '>' ;
fragment GTE: '>=' ;
fragment LT: '<' ;
fragment LTE: '<=' ;
fragment EQ: '==' ;
fragment NEQ: '!=' ;
fragment AND: '&&' ;
fragment OR: '||' ;
BINARY_OP: MULT | DIV | MOD | ADD | SUB
         | GT | GTE | LT | LTE 
         | EQ | NEQ | AND | OR
         ;

//base types
INT: 'int' ;
CHAR: 'char' ;
STRING: 'string' ;
BOOL: 'bool' ;

fragment ALPHABET: [A-z] ;
ID: ( '_' | ALPHABET ) ( '_' | ALPHABET | DIGIT )* ;

