package wacc.codeGen;

import java.util.ArrayList;
import java.util.Collection;

import wacc.antlr.WACCParser.*;
import wacc.antlr.WACCParserBaseVisitor;
import wacc.tree.nodeInterfaces.ExpNode;
import wacc.tree.nodeInterfaces.Node;
import wacc.tree.nodeInterfaces.StatNode;
import wacc.tree.nodes.*;
import wacc.util.BinaryOp;
import wacc.util.Type;
import wacc.util.UnaryOp;

import javax.sound.midi.Sequence;

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
	public TypeNode visitType(TypeContext ctx) {
		// TODO Auto-generated method stub
		return new TypeNode();
	}

	@Override
	public WhileNode visitWhile(WhileContext ctx) {
		// TODO Auto-generated method stub
		return new WhileNode();
	}

	//TOOD
	@Override
	public ExpNode visitBracketedExp(BracketedExpContext ctx) {
		// TODO Auto-generated method stub
		return new ExpNode() {
			@Override
			public void generate() {

			}
		}
	}

	@Override
	public BinaryOpNode visitAndOpExp(AndOpExpContext ctx) {
		// TODO Auto-generated method stub
		return new BinaryOpNode();
	}

	@Override
	public IfNode visitIf(IfContext ctx) {
		// TODO Auto-generated method stub
		return new IfNode();
	}

	@Override
	public ReadNode visitRead(ReadContext ctx) {
		// TODO Auto-generated method stub
		return new ReadNode();
	}

	//TODO
	@Override
	public ArrayNode visitArray_lit(Array_litContext ctx) {
		// TODO Auto-generated method stub
		return new ArrayNode();
	}

	@Override
	public BinaryOpNode visitEqualityOpExp(EqualityOpExpContext ctx) {
		// TODO Auto-generated method stub
		return new BinaryOpNode();
	}

	@Override
	public PairElemNode visitPair_elem_type(Pair_elem_typeContext ctx) {
		// TODO Auto-generated method stub
		return new PairElemNode();
	}

	@Override
	public BinaryOpNode visitOrOpExp(OrOpExpContext ctx) {
		// TODO Auto-generated method stub
		return new BinaryOpNode();
	}

	@Override
	public ExitNode visitExit(ExitContext ctx) {
		// TODO Auto-generated method stub
		return new ExitNode();
	}

	//TODO
	@Override
	public SequenceNode visitSequence(SequenceContext ctx) {
		// TODO Auto-generated method stub
		return new SequenceNode();
	}

	@Override
	public BeginNode visitBegin(BeginContext ctx) {
		// TODO Auto-generated method stub
		return new BeginNode();
	}

	@Override
	public InitialisationNode visitInitialisation(InitialisationContext ctx) {
		// TODO Auto-generated method stub
		return new InitialisationNode(ctx.ident().getText(), Type.parse(ctx.type().getText()));
	}

	@Override
	public BoolNode visitBool(BoolContext ctx) {
		// TODO Auto-generated method stub
		return new BoolNode(Boolean.parseBoolean(ctx.getText()));
	}

	@Override
	public StringNode visitString(StringContext ctx) {
		// TODO Auto-generated method stub
		return new StringNode(ctx.getText());
	}

	@Override
	public BinaryOpNode visitOrderingOpExp(OrderingOpExpContext ctx) {
		// TODO Auto-generated method stub
		return new BinaryOpNode();
	}

	@Override
	public StatNode visitSkip(SkipContext ctx) {
		// TODO Auto-generated method stub
		return new StatNode() {
			@Override
			public void generate() {

			}
		};
	}

	@Override
	public PrintlnNode visitPrintln(PrintlnContext ctx) {
		// TODO Auto-generated method stub
		return new PrintlnNode();
	}

	@Override
	public TypeNode visitPair_type(Pair_typeContext ctx) {
		// TODO Auto-generated method stub
		return new TypeNode();
	}

	@Override
	public UnaryOpNode visitUnaryOpExp(UnaryOpExpContext ctx) {
		// TODO Auto-generated method stub
		return new UnaryOpNode();
	}

	@Override
	public Node visitParam(ParamContext ctx) {
		// TODO Auto-generated method stub
		return new Node() {
			@Override
			public void generate() {

			}
		};
	}

	@Override
	public BinaryOpNode visitAsArithmeticOpExp(AsArithmeticOpExpContext ctx) {
		// TODO Auto-generated method stub
		return new BinaryOpNode();
	}

	@Override
	public FreeNode visitFree(FreeContext ctx) {
		// TODO Auto-generated method stub
		return new FreeNode();
	}

	@Override
	public BinaryOpNode visitDmArithmeticOpExp(DmArithmeticOpExpContext ctx) {
		// TODO Auto-generated method stub
		return new BinaryOpNode();
	}

	@Override
	public AssignmentNode visitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		return new AssignmentNode(Type.parse(ctx.assign_lhs().getChild(0).getText()));
	}

	@Override
	public IdentNode visitIdentExp(IdentExpContext ctx) {
		// TODO Auto-generated method stub
		return new IdentNode(ctx.getText());
	}

	@Override
	public IntNode visitInt(IntContext ctx) {
		// TODO Auto-generated method stub
		return new IntNode(Integer.parseInt(ctx.getText()));
	}

	@Override
	public PairNode visitPair(PairContext ctx) {
		// TODO Auto-generated method stub
		return new PairNode();
	}

	@Override
	public ArgListNode visitArg_list(Arg_listContext ctx) {
		// TODO Auto-generated method stub
		return new ArgListNode();
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
		return super.visitInt_lit();
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
