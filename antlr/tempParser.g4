parser grammar tempParser;

options {
      tokenVocab=tempLexer;
}

program: BEGIN func* stat END; 

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
    | type ident ASSIGN assign_rhs
    | assign_lhs ASSIGN assign_rhs
    ;

base_type: INT | CHAR | STRING | BOOL ;

type: base_type
    | array_type
    | pair_type
    ;

array_type: base_type OPEN_SQ_BRACK CLOSE_SQ_BRACK
          | pair_type OPEN_SQ_BRACK CLOSE_SQ_BRACK
          | array_type OPEN_SQ_BRACK CLOSE_SQ_BRACK 
          ;

array_elem: ident (OPEN_SQ_BRACK INT_LIT CLOSE_SQ_BRACK)+ ;

array_lit: OPEN_SQ_BRACK ( exp (COMMA exp )* )? CLOSE_SQ_BRACK ;

pair_elem_type: base_type
              | array_type
              | PAIR
              ;

pair_elem: FST exp
         | SND exp
         ;

pair_type: PAIR OPEN_PAR pair_elem_type COMMA pair_elem_type CLOSE_PAR;

exp: INT_LIT
   | BOOL_LIT
   | CHAR_LIT
   | STRING_LIT
   | PAIR_LIT
   | array_lit
   | ident
   | UNARY_OP exp
   | exp BINARY_OP exp
   | OPEN_PAR exp CLOSE_PAR
   ;

arg_list: exp (COMMA exp )* ;

param: type ident ;

param_list: param ( COMMA param )* ;

func: type ident OPEN_PAR param_list? CLOSE_PAR IS stat END ;

assign_lhs: ident
          | array_elem
          | pair_elem
          ;

assign_rhs: exp
          | array_lit
          | NEWPAIR OPEN_PAR exp COMMA exp CLOSE_PAR
          | pair_elem
          | CALL ident OPEN_PAR arg_list? CLOSE_PAR
          ;

ident: ID ;
