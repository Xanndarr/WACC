lexer grammar WACCLexer;

ID : [a-zA-Z]+ ; // match identifiers
INT : [0-9]+ ; // match integers
NEWLINE:'\r'? '\n' ; // return newlines to parser
WS : [ \t]+ -> skip ; //white space




