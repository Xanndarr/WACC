package wacc.codeGen;

import java.util.LinkedList;
import java.util.List;

import wacc.antlr.WACCParser.*;
import wacc.antlr.WACCParserBaseVisitor;
import wacc.tree.nodeInterfaces.ExpNode;
import wacc.tree.nodeInterfaces.Node;
import wacc.tree.nodeInterfaces.StatNode;
import wacc.tree.nodes.*;
import wacc.tree.nodes.PairElemNode.PairPos;
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
        BinaryOpNode ret = new BinaryOpNode();
        ExpNode exp1 = (ExpNode) visit(ctx.exp().get(0));
        ExpNode exp2 = (ExpNode) visit(ctx.exp().get(1));
        ret.addChild(exp1);
        ret.addChild(exp2);
        return ret;
	}

	@Override
	public PairElemNode visitPair_elem_type(Pair_elem_typeContext ctx) {
		// TODO Auto-generated method stub
		return new PairElemNode();
	}

	@Override
	public BinaryOpNode visitOrOpExp(OrOpExpContext ctx) {
        BinaryOpNode op = new BinaryOpNode();
        ExpNode exp1 = (ExpNode) visit(ctx.exp().get(0));
        ExpNode exp2 = (ExpNode) visit(ctx.exp().get(1));
        op.addChild(exp1);
        op.addChild(exp2);
        return op;
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
        BinaryOpNode op = new BinaryOpNode();
        ExpNode exp1 = (ExpNode) visit(ctx.exp().get(0));
        ExpNode exp2 = (ExpNode) visit(ctx.exp().get(1));
        op.addChild(exp1);
        op.addChild(exp2);
        return op;
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
        UnaryOpNode op = new UnaryOpNode();
        ExpNode exp1 = (ExpNode) visit(ctx.exp());
        op.addChild(exp1);
        return op;
	}

	@Override
	public ParamNode visitParam(ParamContext ctx) {
		// TODO Auto-generated method stub
		return new ParamNode();
	}

	@Override
	public BinaryOpNode visitAsArithmeticOpExp(AsArithmeticOpExpContext ctx) {
        BinaryOpNode op = new BinaryOpNode();
        ExpNode exp1 = (ExpNode) visit(ctx.exp().get(0));
        ExpNode exp2 = (ExpNode) visit(ctx.exp().get(1));
        op.addChild(exp1);
        op.addChild(exp2);
        return op;
	}

	@Override
	public FreeNode visitFree(FreeContext ctx) {
        FreeNode free = new FreeNode();
        ExpNode exp = (ExpNode) visit(ctx.exp());
        free.addChild(exp);
        return free;
	}

	@Override
	public BinaryOpNode visitDmArithmeticOpExp(DmArithmeticOpExpContext ctx) {
        BinaryOpNode op = new BinaryOpNode();
        ExpNode exp1 = (ExpNode) visit(ctx.exp().get(0));
        ExpNode exp2 = (ExpNode) visit(ctx.exp().get(1));
        op.addChild(exp1);
        op.addChild(exp2);
        return op;
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
		ArgListNode args = new ArgListNode();
		for (ExpContext arg : ctx.exp()) {
			args.addChild((ExpNode) visit(arg));
		}
		return new ArgListNode();
	}

	//TODO
	@Override
	public ParamListNode visitParam_list(Param_listContext ctx) {
		ParamListNode paramListNode = new ParamListNode();
		for (ParamContext p : ctx.param()) {
			paramListNode.addChild(visitParam(p));
		}
		return paramListNode;
	}

	//TODO
	@Override
	public PrintNode visitPrint(PrintContext ctx) {
		PrintNode printNode = new PrintNode();
		ExpNode printExp = (ExpNode) visit(ctx.exp());
		printNode.addChild(printExp);
		return printNode;
	}

	@Override
	public FunctionNode visitFunc(FuncContext ctx) {
		FunctionNode func = new FunctionNode(ctx.ident().getText());
		ParamListNode args = (ParamListNode) visit(ctx.param_list());
		StatNode stats = (StatNode) visit(ctx.stat());
		
		func.addChild(args);
		func.addChild(stats);
		return func;
	}

	@Override
	public PairElemNode visitPair_elem(Pair_elemContext ctx) {
		PairPos pos;
		if (ctx.FST() == null) {
			pos = PairPos.SND;
		} else {
			pos = PairPos.FST;
		}
		
		PairElemNode pairElemNode = new PairElemNode(pos);
		ExpNode pairExp = (ExpNode) visit(ctx.exp());
		
		pairElemNode.addChild(pairExp);
		return pairElemNode;
	}

	@Override
	public CharNode visitChar(CharContext ctx) {
		return new CharNode(ctx.getText().charAt(0));
	}

	@Override
	public ReturnNode visitReturn(ReturnContext ctx) {
		ReturnNode ret = new ReturnNode();
		ExpNode retExp = (ExpNode) visit(ctx.exp());
		ret.addChild(retExp);
		return ret;
	}

}
