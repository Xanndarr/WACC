parser grammar WACCParser;

options {
  tokenVocab=WACCLexer;
}

program: BEGIN func* stat END EOF ;

func: type ID OPEN_PARENTHESES param_list? CLOSE_PARENTHESES IS stat END ;

param_list: param (COMMA param )* ;

param: type ID ;

stat: SKIP
    | type ID ASSIGNMENT assign_rhs
    | assign_lhs ASSIGNMENT assign_rhs
    | READ assign_lhs
    | FREE expr
    | RETURN expr
    | EXIT expr
    | PRINT expr
    | PRINTLN expr
    | IF expr THEN stat ELSE stat FI
    | WHILE expr DO stat DONE
    | BEGIN stat END
    | stat SEMICOLON stat
    ;

assign_lhs: ID
          | array_elem
          | pair_elem
          ;

assign_rhs: expr
          | array_liter
          | NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
          | pair_elem
          | CALL ID OPEN_PARENTHESES arg_list? CLOSE_PARENTHESES
          ;

arg_list: expr (COMMA expr )* ;

pair_elem: FST expr
         | SND expr
         ;

type: base_type
    | array_type
    | pair_type
    ;

base_type: INT_TYPE
         | BOOL_TYPE
         | CHAR_TYPE
         | STRING_TYPE
         ;

array_type: base_type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
    | pair_type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
    | array_type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET
    ;

pair_type: PAIR_TYPE OPEN_PARENTHESES pair_elem_type COMMA pair_elem_type CLOSE_PARENTHESES ;

pair_elem_type: base_type
  | array_type
  | PAIR_TYPE
  ;

expr: int_liter
    | bool_liter
    | char_liter
    | str_liter
    | pair_liter
    | ID
    | array_elem
    | unary_oper expr
    | expr binary_oper expr
    | OPEN_PARENTHESES expr CLOSE_PARENTHESES
    ;

unary_oper: NOT | MINUS | LEN | ORD | CHR ;

binary_oper: MULT | DIV | MOD | ADD 
    | SUB | GT | GTE | LT | LTE 
    | EQ | NEQ | AND | OR
    ;

array_elem: ID (OPEN_SQUARE_BRACKET expr CLOSE_SQUARE_BRACKET)+ ;

int_liter: INT_SIGN? INT ;

bool_liter: BOOL ;

char_liter: APOSTROPHE CHAR APOSTROPHE ;

str_liter: DOUBLEQUOTE CHAR* DOUBLEQUOTE ;

array_liter: OPEN_SQUARE_BRACKET ( expr (COMMA expr)* )? CLOSE_SQUARE_BRACKET ;

pair_liter: NULL ;
