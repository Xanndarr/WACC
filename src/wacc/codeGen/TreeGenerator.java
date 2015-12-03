package wacc.codeGen;

import wacc.antlr.WACCParser.*;
import wacc.antlr.WACCParserBaseVisitor;
import wacc.tree.nodeInterfaces.ExpNode;
import wacc.tree.nodeInterfaces.Node;
import wacc.tree.nodeInterfaces.StatNode;
import wacc.tree.nodes.*;
import wacc.util.Type;

public class TreeGenerator extends WACCParserBaseVisitor<Node>{

	//TODO
	@Override
	public ArrayElemNode visitArrayElem(ArrayElemContext ctx) {
		// TODO Auto-generated method stub
		return new ArrayElemNode();
	}

	@Override
	public IdentNode visitIdent(IdentContext ctx) {
		return new IdentNode(ctx.toString());
	}

	@Override
	public ProgramNode visitProgram(ProgramContext ctx) {
        return new ProgramNode();
	}

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
		};
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
		String ident = ctx.assign_lhs().ident().getText();
		String type = ctx.assign_lhs().getChild(0).getText();
		return new AssignmentNode(ident, Type.parse(type));
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
	public ParamListNode visitParam_list(Param_listContext ctx) {
		// TODO Auto-generated method stub
		return new ParamListNode();
	}

	//TODO
	@Override
	public PrintNode visitPrint(PrintContext ctx) {
		// TODO Auto-generated method stub
		return new PrintNode();
	}

	@Override
	public FunctionNode visitFunc(FuncContext ctx) {
		// TODO Auto-generated method stub
		return new FunctionNode(ctx.ident().getText());
	}

	@Override
	public PairElemNode visitPair_elem(Pair_elemContext ctx) {
		// TODO Auto-generated method stub
		return new PairElemNode();
	}

	@Override
	public CharNode visitChar(CharContext ctx) {
		// TODO Auto-generated method stub
		return new CharNode(ctx.getText().charAt(0));
	}

	@Override
	public ReturnNode visitReturn(ReturnContext ctx) {
		// TODO Auto-generated method stub
		return new ReturnNode();
	}

}
