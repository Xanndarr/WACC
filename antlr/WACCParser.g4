parser grammar WACCParser;

options {
      tokenVocab=WACCLexer;
}

program: BEGIN func* stat END EOF;

type: (base_type | pair_type) (array_type)* ;
//    | array_type
//    | pair_type
//    ;
//        base_type array_type*
//      | pair_type array_type*
//      ;

stat: SKIP 								#skip
    | type ident ASSIGN assign_rhs 		#initialisation
    | assign_lhs ASSIGN assign_rhs 		#assignment
    | READ assign_lhs 					#read
    | FREE exp 							#free
    | EXIT exp 							#exit
    | PRINT exp 						#print
    | PRINTLN exp 						#println
    | IF exp THEN stat ELSE stat FI 	#if
    | WHILE exp DO stat DONE 			#while
    | BEGIN stat END 					#begin
    | stat SEMICOLON stat 				#sequence
    | RETURN exp 						#return 
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

exp: int_lit                #int
   | BOOL_LIT               #bool
   | CHAR_LIT               #char
   | STRING_LIT             #string
   | PAIR_LIT               #pair
   | array_elem             #arrayElem
   | ident                  #identExp
   | unary_op exp           #unaryOpExp
   | exp binary_op exp      #binaryOpExp
   | OPEN_PAR exp CLOSE_PAR #bracketedExp
   ;

int_lit: number 
  {
    Long.valueOf($number.text) <= Integer.MAX_VALUE && Long.valueOf($number.text) >= (Integer.MIN_VALUE)
  }?<fail={"Integer value not valid"}> ;

number: INT_LIT ;

unary_op: NOT | SUB | LEN | ORD | CHR ;

binary_op: MULT | DIV | MOD | ADD | SUB
         | GT | GTE | LT | LTE 
         | EQ | NEQ | AND | OR
         ;

arg_list: exp (COMMA exp )* ;

param: type ident ;

param_list: param ( COMMA param )* ;

func: type ident OPEN_PAR param_list? CLOSE_PAR IS stat END 
  {
    $stat.text.contains("return") || $stat.text.contains("exit")
  }?<fail={"Function may not return anything"}> ;

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
