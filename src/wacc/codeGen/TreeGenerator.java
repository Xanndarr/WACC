package wacc.codeGen;

import wacc.antlr.WACCParser.*;
import wacc.antlr.WACCParserBaseVisitor;
import wacc.tree.nodes.StringNode;
import wacc.tree.Node;
import wacc.tree.nodes.IdentNode;

public class TreeGenerator extends WACCParserBaseVisitor<Node>{

	@Override
	public Node visitArray_elem(Array_elemContext ctx) {
		return super.visitArray_elem(ctx);
	}

	@Override
	public Node visitArrayElem(ArrayElemContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArrayElem(ctx);
	}

	@Override
	public Node visitAssign_lhs(Assign_lhsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssign_lhs(ctx);
	}

	@Override
	public Node visitIdent(IdentContext ctx) {
		return new IdentNode(ctx.toString());
	}

	@Override
	public Node visitAssign_rhs(Assign_rhsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssign_rhs(ctx);
	}

	@Override
	public Node visitAnd_op(And_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAnd_op(ctx);
	}

	@Override
	public Node visitProgram(ProgramContext ctx) {
		// TODO Auto-generated method stub
		return super.visitProgram(ctx);
	}

	@Override
	public Node visitType(TypeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitType(ctx);
	}

	@Override
	public Node visitWhile(WhileContext ctx) {
		// TODO Auto-generated method stub
		return super.visitWhile(ctx);
	}

	@Override
	public Node visitBracketedExp(BracketedExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBracketedExp(ctx);
	}

	@Override
	public Node visitNumber(NumberContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNumber(ctx);
	}

	@Override
	public Node visitAndOpExp(AndOpExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAndOpExp(ctx);
	}

	@Override
	public Node visitDm_arithmetic_op(Dm_arithmetic_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDm_arithmetic_op(ctx);
	}

	@Override
	public Node visitIf(IfContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIf(ctx);
	}

	@Override
	public Node visitRead(ReadContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRead(ctx);
	}

	@Override
	public Node visitArray_lit(Array_litContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArray_lit(ctx);
	}

	@Override
	public Node visitUnary_op(Unary_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitUnary_op(ctx);
	}

	@Override
	public Node visitEqualityOpExp(EqualityOpExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEqualityOpExp(ctx);
	}

	@Override
	public Node visitPair_elem_type(Pair_elem_typeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPair_elem_type(ctx);
	}

	@Override
	public Node visitAs_arithmetic_op(As_arithmetic_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAs_arithmetic_op(ctx);
	}

	@Override
	public Node visitOrOpExp(OrOpExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitOrOpExp(ctx);
	}

	@Override
	public Node visitExit(ExitContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExit(ctx);
	}

	@Override
	public Node visitSequence(SequenceContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSequence(ctx);
	}

	@Override
	public Node visitBegin(BeginContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBegin(ctx);
	}

	@Override
	public Node visitInitialisation(InitialisationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitInitialisation(ctx);
	}

	@Override
	public Node visitBool(BoolContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBool(ctx);
	}

	@Override
	public Node visitString(StringContext ctx) {
		// TODO Auto-generated method stub
		return new StringNode(ctx.toString());
	}

	@Override
	public Node visitOrderingOpExp(OrderingOpExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitOrderingOpExp(ctx);
	}

	@Override
	public Node visitSkip(SkipContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSkip(ctx);
	}

	@Override
	public Node visitOrdering_op(Ordering_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitOrdering_op(ctx);
	}

	@Override
	public Node visitPrintln(PrintlnContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrintln(ctx);
	}

	@Override
	public Node visitBase_type(Base_typeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBase_type(ctx);
	}

	@Override
	public Node visitPair_type(Pair_typeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPair_type(ctx);
	}

	@Override
	public Node visitUnaryOpExp(UnaryOpExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitUnaryOpExp(ctx);
	}

	@Override
	public Node visitParam(ParamContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParam(ctx);
	}

	@Override
	public Node visitArray_type(Array_typeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArray_type(ctx);
	}

	@Override
	public Node visitAsArithmeticOpExp(AsArithmeticOpExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAsArithmeticOpExp(ctx);
	}

	@Override
	public Node visitFree(FreeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFree(ctx);
	}

	@Override
	public Node visitEquality_op(Equality_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEquality_op(ctx);
	}

	@Override
	public Node visitDmArithmeticOpExp(DmArithmeticOpExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDmArithmeticOpExp(ctx);
	}

	@Override
	public Node visitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssignment(ctx);
	}

	@Override
	public Node visitIdentExp(IdentExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIdentExp(ctx);
	}

	@Override
	public Node visitOr_op(Or_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitOr_op(ctx);
	}

	@Override
	public Node visitInt(IntContext ctx) {
		// TODO Auto-generated method stub
		return super.visitInt(ctx);
	}

	@Override
	public Node visitPair(PairContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPair(ctx);
	}

	@Override
	public Node visitArg_list(Arg_listContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArg_list(ctx);
	}

	@Override
	public Node visitParam_list(Param_listContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParam_list(ctx);
	}

	@Override
	public Node visitPrint(PrintContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrint(ctx);
	}

	@Override
	public Node visitFunc(FuncContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFunc(ctx);
	}

	@Override
	public Node visitInt_lit(Int_litContext ctx) {
		// TODO Auto-generated method stub
		return super.visitInt_lit(ctx);
	}

	@Override
	public Node visitPair_elem(Pair_elemContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPair_elem(ctx);
	}

	@Override
	public Node visitChar(CharContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChar(ctx);
	}

	@Override
	public Node visitReturn(ReturnContext ctx) {
		// TODO Auto-generated method stub
		return super.visitReturn(ctx);
	}

}
