parser grammar tempParser;

options {
      tokenVocab=tempLexer;
}

program: BEGIN stat END;

stat: SKIP
    | EXIT INT
    | PRINT exp
    | PRINTLN exp
    | FREE exp
    | RETURN exp
    | stat SEMICOLON stat
    ;

exp: INT_LIT
   | BOOL_LIT
   | CHAR_LIT
   | STRING_LIT
   ;

