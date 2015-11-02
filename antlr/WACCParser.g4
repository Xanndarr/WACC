parser grammar WACCParser;

options {
    tokenVocab=WACCLexer;
}

program: BEGIN func* stat END ;

func: type ID OPEN_PARENTHESES param-list? CLOSE_PARENTHESES IS stat END ;

param-list: param ( COMMA param )* ;

param: type ID ;

stat: SKIP
    | type ID ASSIGNMENT assign-rhs
    | assign-lhs ASSIGNMENT assign-rhs
    | READ assign-lhs
    | FREE expr
    | RETURN expr
    | EXIT expr
    | PRINT expr
    | PRINTLN expr
    | IF expr THEN stat ELSE stat IF
    | WHILE expr DO stat DONE
    | BEGIN stat END
    | stat SEMICOLON stat
    ;

assign-lhs: ID
    | array-elem
    | pair-elem
    ;

assign-rhs: expr
    | array-elem
    | NEWPAIR OPEN_PARENTHESES expr COMMA expr CLOSE_PARENTHESES
    | pair-elem
    | CALL ID OPEN_PARENTHESES arg-list? CLOSE_PARENTHESES
    ;

arg-list: expr (COMMA expr )* ;

pair-elem: FST expr
    | SND expr
    ;

type: base-type
    | array-type
    | pair-type
    ;

base-type: INT_TYPE
    | BOOL_TYPE
    | CHAR_TYPE
    | STRING_TYPE
    ;

array-type: type OPEN_SQUARE_BRACKET CLOSE_SQUARE_BRACKET ;

pair-type: PAIR_TYPE OPEN_PARENTHESES pair-elem-type COMMA pair-elem-type CLOSE_PARENTHESES ;

pair-elem-type: base-type
    | array-type
    | PAIR_TYPE
    ;

expr: int-liter
    | bool-liter
    | char-liter
    | string-liter
    | pair-liter
    | ID
    | array-elem
    | unary-oper expr
    | expr binary-oper expr
    | OPEN_PARENTHESES expr CLOSE_PARENTHESES
    ;

unary-oper: NOT | NEG | LEN | ORD | CHR ;

binary-oper: MULT | DIV | MOD | ADD 
    | SUB | GT | GTE | LT | LTE 
    | EQ | NEQ | AND | OR
    ;

array-elem: ID (OPEN_SQUARE_BRACKET expr CLOSE_SQUARE_BRACKET)+ ;

array-liter: OPEN_SQUARE_BRACKET ( expr (COMMA expr)* )? CLOSE_SQUARE_BRACKET ;

char-liter: APOSTROPHE CHAR APOSTROPHE ;

string-liter: DOUBLEQUOTE CHAR* DOUBLEQUOTE ;

bool-liter: BOOL ;

pair-liter: NULL ;

comment: HASH (~[EOL])* EOL ;
