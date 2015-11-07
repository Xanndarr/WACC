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
    | WHILE exp DO stat DONE
    | BEGIN stat END
    | stat SEMICOLON stat
    ;

array_lit: OPEN_SQ_BRACK ( exp (COMMA exp )* )? CLOSE_SQ_BRACK ;

pair_elem_type: BASE_TYPE
              //| array_type
              | PAIR
              ;

pair_type: PAIR OPEN_PAR pair_elem_type COMMA pair_elem_type CLOSE_PAR;

exp: INT_LIT
   | BOOL_LIT
   | CHAR_LIT
   | STRING_LIT
   | PAIR_LIT
   | array_lit
   //| IDENT
   ;

