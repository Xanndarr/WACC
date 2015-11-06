parser grammar tempParser;

options {
      tokenVocab=tempLexer;
}

program: BEGIN stat END;

stat: SKIP
    | EXIT INT_LIT
    | PRINT exp
    | PRINTLN exp
    | FREE exp
    | RETURN exp
    | IF exp THEN stat ELSE stat FI
    | stat SEMICOLON stat
    ;

exp: INT_LIT
   | BOOL_LIT
   | CHAR_LIT
   | STRING_LIT
   ;

