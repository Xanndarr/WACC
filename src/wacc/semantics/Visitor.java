package wacc.semantics;

import wacc.antlr.WACCParser.*;
import wacc.antlr.WACCParserBaseVisitor;

public class Visitor extends WACCParserBaseVisitor<Void> {
	
	private String nodeType = "null";
	
	/*
	 * Visits stats
	 */

	@Override
	public Void visitInitialisation(InitialisationContext ctx) {
		// TODO Add variable to current scope
		// TODO Check RHS type is equal to variable type
		return super.visitInitialisation(ctx);
	}

	@Override
	public Void visitAssignment(AssignmentContext ctx) {
		// TODO Check LHS type = RHS type
		return super.visitAssignment(ctx);
	}

	@Override
	public Void visitRead(ReadContext ctx) {
		// TODO Check type is = program variable | pair elem | array elem
		// TODO Type must be either int, string(?) or char
		return super.visitRead(ctx);
	}

	@Override
	public Void visitFree(FreeContext ctx) {
		// TODO Type must be either array or pair
		// TODO Type must not be an array of an array or an array of a pair or a pair of arrays etc.
		return super.visitFree(ctx);
	}
	
	@Override
	public Void visitExit(ExitContext ctx) {
		// TODO Expression must evaluate to an int
		return super.visitExit(ctx);
	}

	@Override
	public Void visitIf(IfContext ctx) {
		// TODO Check condition is a valid boolean or evaluates to one
		// TODO Increase symtab scope before visiting EACH child individually
		// TODO Reduce symtab scope after visiting EACH child individually
		return super.visitIf(ctx);
	}

	@Override
	public Void visitWhile(WhileContext ctx) {
		// TODO Check condition is a valid boolean or evaluates to one
		// TODO Increase symtab scope before visiting child
		// TODO Reduce symtab scope afterwards
		return super.visitWhile(ctx);
	}
	
	@Override
	public Void visitReturn(ReturnContext ctx) {
		// TODO Expression must be same type as function return type
		return super.visitReturn(ctx);
	}
	
	/*
	 * Visits expressions
	 */
	
	@Override
	public Void visitInt(IntContext ctx) {
		nodeType = "int";
		return super.visitInt(ctx);
	}
	
	@Override
	public Void visitBool(BoolContext ctx) {
		nodeType = "bool";
		return super.visitBool(ctx);
	}
	
	@Override
	public Void visitChar(CharContext ctx) {
		nodeType = "char";
		return super.visitChar(ctx);
	}

	@Override
	public Void visitString(StringContext ctx) {
		nodeType = "string";
		return super.visitString(ctx);
	}

	@Override
	public Void visitPair(PairContext ctx) {
		nodeType = "pair";
		return super.visitPair(ctx);
	}

	@Override
	public Void visitArrayElem(ArrayElemContext ctx) {
		// TODO check exp evaluates to a positive int
		return super.visitArrayElem(ctx);
	}

	@Override
	public Void visitIdentExp(IdentExpContext ctx) {
		// TODO Make sure identifier exists in current scope or higher
		return super.visitIdentExp(ctx);
	}
	
	@Override
	public Void visitUnaryOpExp(UnaryOpExpContext ctx) {
		// TODO Check expressions match types allowed by specified unary operator
		// TODO set nodeType = return type
		// '!' 		allows bool		returns bool
		// '-' 		allows int		returns int
		// 'len' 	allows arrays	returns int
		// 'ord' 	allows char		returns int
		// 'chr' 	allows int		returns char
		return super.visitUnaryOpExp(ctx);
	}

	@Override
	public Void visitBinaryOpExp(BinaryOpExpContext ctx) {
		// TODO Check LHS and RHS have same types
		// TODO set nodeType = return type
		// *, /, %, +, - take int return int
		// >, >=, <, <= take int/char return bool
		// ==, != take anything return bool
		// &&, || take bool return bool
		return super.visitBinaryOpExp(ctx);
	}
	
	/*
	 * Visit other rules
	 */

	@Override
	public Void visitFunc(FuncContext ctx) {
		// TODO Increase symtab scope, visit children, then decrease symtab scope
		// TODO Possibly add parameters to a global function signature tracker
		// TODO Check every path of execut1ion contains a return statement
		return super.visitFunc(ctx);
	}

	@Override
	public Void visitParam(ParamContext ctx) {
		// TODO Add param to current scope
		return super.visitParam(ctx);
	}
	
	@Override
	public Void visitArray_lit(Array_litContext ctx) {
		// TODO Check all children have same type
		// TODO nodeType = CHILDTYPE + "[]"
		return super.visitArray_lit(ctx);
	}
	
	@Override
	public Void visitPair_elem(Pair_elemContext ctx) {
		// TODO Visit child and obtain type
		// nodeType = CHILDTYPE
		return super.visitPair_elem(ctx);
	}

	@Override
	public Void visitAssign_rhs(Assign_rhsContext ctx) {
		// TODO When calling functions, check arg types are equal function signature types
		return super.visitAssign_rhs(ctx);
	}

}