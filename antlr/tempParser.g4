parser grammar tempParser;

options {
      tokenVocab=tempLexer;
}

program: BEGIN func* stat END;

type: (base_type | pair_type) (array_type)* ;
//    | array_type
//    | pair_type
//    ;
//        base_type array_type*
//      | pair_type array_type*
//      ;

stat: SKIP
    | type ident ASSIGN assign_rhs
    | assign_lhs ASSIGN assign_rhs
    | READ assign_lhs
    | FREE exp
    | EXIT exp
    | PRINT exp
    | PRINTLN exp
    | IF exp THEN stat ELSE stat FI
    | WHILE exp DO stat DONE
    | BEGIN stat END
    | stat SEMICOLON stat
    | RETURN exp
    ;

base_type: INT | CHAR | STRING | BOOL ;

array_type : OPEN_SQ_BRACK CLOSE_SQ_BRACK ; 
//             base_type OPEN_SQ_BRACK CLOSE_SQ_BRACK
//           | pair_type OPEN_SQ_BRACK CLOSE_SQ_BRACK
//           | array_type OPEN_SQ_BRACK CLOSE_SQ_BRACK 
//           ;

array_elem: ident (OPEN_SQ_BRACK exp CLOSE_SQ_BRACK)+ ;

array_lit: OPEN_SQ_BRACK ( exp (COMMA exp )* )? CLOSE_SQ_BRACK ;

pair_elem_type: type
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
   | array_elem
   | ident
   | unary_op exp
   | exp binary_op exp
   | OPEN_PAR exp CLOSE_PAR
   ;

unary_op: NOT | SUB | LEN | ORD | CHR ;

binary_op: MULT | DIV | MOD | ADD | SUB
         | GT | GTE | LT | LTE 
         | EQ | NEQ | AND | OR
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
