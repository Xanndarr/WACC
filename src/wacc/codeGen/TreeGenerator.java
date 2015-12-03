package wacc.codeGen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import wacc.antlr.WACCParser.*;
import wacc.antlr.WACCParserBaseVisitor;
import wacc.tree.Node;
import wacc.tree.nodes.*;

public class TreeGenerator extends WACCParserBaseVisitor<Node>{

	//TODO
	@Override
	public Node visitArray_elem(Array_elemContext ctx) {
		return super.visitArray_elem(ctx);
	}

	//TODO
	@Override
	public Node visitArrayElem(ArrayElemContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArrayElem(ctx);
	}

	//TODO
	@Override
	public Node visitAssign_lhs(Assign_lhsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssign_lhs(ctx);
	}

	@Override
	public IdentNode visitIdent(IdentContext ctx) {
		return new IdentNode(ctx.toString());
	}

	//TODO
	@Override
	public Node visitAssign_rhs(Assign_rhsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssign_rhs(ctx);
	}

	@Override
	public BinaryOpNode visitAnd_op(And_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAnd_op(ctx);
	}

	@Override
	public ProgramNode visitProgram(ProgramContext ctx) {
		Collection<FunctionNode> functions = new ArrayList<FunctionNode>();
		BeginNode stat = visitBegin(ctx);
		ProgramNode program = new ProgramNode(stat, functions);
		return program;
	}

	//TODO
	@Override
	public Node visitType(TypeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitType(ctx);
	}

	@Override
	public WhileNode visitWhile(WhileContext ctx) {
		// TODO Auto-generated method stub
		return super.visitWhile(ctx);
	}

	//TOOD
	@Override
	public Node visitBracketedExp(BracketedExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBracketedExp(ctx);
	}

	//TODO
	@Override
	public Node visitNumber(NumberContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNumber(ctx);
	}

	@Override
	public BinaryOpNode visitAndOpExp(AndOpExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAndOpExp(ctx);
	}

	@Override
	public BinaryOpNode visitDm_arithmetic_op(Dm_arithmetic_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDm_arithmetic_op(ctx);
	}

	@Override
	public IfNode visitIf(IfContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIf(ctx);
	}

	@Override
	public ReadNode visitRead(ReadContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRead(ctx);
	}

	//TODO
	@Override
	public Node visitArray_lit(Array_litContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArray_lit(ctx);
	}

	@Override
	public UnaryOpNode visitUnary_op(Unary_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitUnary_op(ctx);
	}

	@Override
	public BinaryOpNode visitEqualityOpExp(EqualityOpExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEqualityOpExp(ctx);
	}

	@Override
	public PairElemNode visitPair_elem_type(Pair_elem_typeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPair_elem_type(ctx);
	}

	@Override
	public BinaryOpNode visitAs_arithmetic_op(As_arithmetic_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAs_arithmetic_op(ctx);
	}

	@Override
	public BinaryOpNode visitOrOpExp(OrOpExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitOrOpExp(ctx);
	}

	@Override
	public ExitNode visitExit(ExitContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExit(ctx);
	}

	//TODO
	@Override
	public Node visitSequence(SequenceContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSequence(ctx);
	}

	@Override
	public BeginNode visitBegin(BeginContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBegin(ctx);
	}

	@Override
	public InitialisationNode visitInitialisation(InitialisationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitInitialisation(ctx);
	}

	@Override
	public BoolNode visitBool(BoolContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBool(ctx);
	}

	@Override
	public StringNode visitString(StringContext ctx) {
		// TODO Auto-generated method stub
		return new StringNode(ctx.toString());
	}

	@Override
	public BinaryOpNode visitOrderingOpExp(OrderingOpExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitOrderingOpExp(ctx);
	}

	//TODO
	@Override
	public Node visitSkip(SkipContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSkip(ctx);
	}

	@Override
	public BinaryOpNode visitOrdering_op(Ordering_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitOrdering_op(ctx);
	}

	//TODO
	@Override
	public Node visitPrintln(PrintlnContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrintln(ctx);
	}

	//TODO
	@Override
	public Node visitBase_type(Base_typeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBase_type(ctx);
	}

	//TODO
	@Override
	public Node visitPair_type(Pair_typeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPair_type(ctx);
	}

	//TODO
	@Override
	public Node visitUnaryOpExp(UnaryOpExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitUnaryOpExp(ctx);
	}

	//TODO
	@Override
	public Node visitParam(ParamContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParam(ctx);
	}

	//TODO
	@Override
	public Node visitArray_type(Array_typeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArray_type(ctx);
	}

	//TODO
	@Override
	public Node visitAsArithmeticOpExp(AsArithmeticOpExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAsArithmeticOpExp(ctx);
	}

	@Override
	public FreeNode visitFree(FreeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFree(ctx);
	}


	@Override
	public BinaryNode visitEquality_op(Equality_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEquality_op(ctx);
	}

	//TODO
	@Override
	public Node visitDmArithmeticOpExp(DmArithmeticOpExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDmArithmeticOpExp(ctx);
	}

	@Override
	public AssignmentNode visitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssignment(ctx);
	}

	@Override
	public IdentNode visitIdentExp(IdentExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIdentExp(ctx);
	}

	@Override
	public BinaryOpNode visitOr_op(Or_opContext ctx) {
		// TODO Auto-generated method stub
		return super.visitOr_op(ctx);
	}

	@Override
	public IntNode visitInt(IntContext ctx) {
		// TODO Auto-generated method stub
		return super.visitInt(ctx);
	}

	@Override
	public PairNode visitPair(PairContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPair(ctx);
	}

	//TODO
	@Override
	public Node visitArg_list(Arg_listContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArg_list(ctx);
	}

	//TODO
	@Override
	public Node visitParam_list(Param_listContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParam_list(ctx);
	}

	//TODO
	@Override
	public Node visitPrint(PrintContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPrint(ctx);
	}

	@Override
	public FunctionNode visitFunc(FuncContext ctx) {
		// TODO Auto-generated method stub
		return super.visitFunc(ctx);
	}

	//TODO
	@Override
	public Node visitInt_lit(Int_litContext ctx) {
		// TODO Auto-generated method stub
		return super.visitInt_lit(ctx);
	}

	@Override
	public PairElemNode visitPair_elem(Pair_elemContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPair_elem(ctx);
	}

	@Override
	public CharNode visitChar(CharContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChar(ctx);
	}

	@Override
	public ReturnNode visitReturn(ReturnContext ctx) {
		// TODO Auto-generated method stub
		return super.visitReturn(ctx);
	}

}
