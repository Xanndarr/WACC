package wacc.codeGen;

import java.util.LinkedList;
import java.util.List;

import wacc.antlr.WACCParser.*;
import wacc.antlr.WACCParserBaseVisitor;
import wacc.tree.nodeInterfaces.AssignLHSNode;
import wacc.tree.nodeInterfaces.AssignRHSNode;
import wacc.tree.nodeInterfaces.ExpNode;
import wacc.tree.nodeInterfaces.Node;
import wacc.tree.nodeInterfaces.StatNode;
import wacc.tree.nodes.*;
import wacc.tree.nodes.PairElemNode.PairPos;
import wacc.util.Type;

public class TreeGenerator extends WACCParserBaseVisitor<Node>{

	@Override
	public ArrayElemNode visitArrayElem(ArrayElemContext ctx) {
		ArrayElemNode arrayElem = new ArrayElemNode();
		IdentNode ident = visitIdent(ctx.array_elem().ident());
		arrayElem.addChild(ident);
		for (ExpContext exp : ctx.array_elem().exp()) {
			arrayElem.addChild((ExpNode) visit(exp));
		}
		return arrayElem;
	}

	@Override
	public IdentNode visitIdent(IdentContext ctx) {
		return new IdentNode(ctx.toString());
	}

	@Override
	public ProgramNode visitProgram(ProgramContext ctx) {
		ProgramNode prog = new ProgramNode();
		for (FuncContext func : ctx.func()) {
			prog.addChild(visit(func));
		}
		StatNode stat = (StatNode) visit(ctx.stat());
		prog.addChild(stat);
        return prog;
	}

	@Override
	public TypeNode visitType(TypeContext ctx) {
		// TODO Auto-generated method stub
		return new TypeNode();
	}

	@Override
	public WhileNode visitWhile(WhileContext ctx) {
		WhileNode whileNode = new WhileNode();
		ExpNode exp = (ExpNode) visit(ctx.exp());
		whileNode.addChild(exp);
		StatNode stat = (StatNode) visit(ctx.stat());
		whileNode.addChild(stat);
		return whileNode;
	}

	@Override
	public BinaryOpNode visitAndOpExp(AndOpExpContext ctx) {
        BinaryOpNode op = new BinaryOpNode();
        ExpNode exp1 = (ExpNode) visit(ctx.exp().get(0));
        ExpNode exp2 = (ExpNode) visit(ctx.exp().get(1));
        op.addChild(exp1);
        op.addChild(exp2);
        return op;
	}

	@Override
	public IfNode visitIf(IfContext ctx) {
		IfNode ifNode = new IfNode();
		ExpNode exp = (ExpNode) visit(ctx.exp());
		ifNode.addChild(exp);
		for (StatContext stat : ctx.stat()) {
			ifNode.addChild(visit(stat));
		}
		return ifNode;
	}

	@Override
	public ReadNode visitRead(ReadContext ctx) {
		ReadNode read = new ReadNode();
        AssignLHSNode lhs = (AssignLHSNode) visit(ctx.assign_lhs());
        read.addChild(lhs);
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
		return new ExitNode();
	}

	//TODO
	@Override
	public SequenceNode visitSequence(SequenceContext ctx) {
		SequenceNode seq = new SequenceNode();
		StatNode fst = (StatNode) visit(ctx.stat(0));
		StatNode rest = (StatNode) visit(ctx.stat(1));
		
		seq.addChild(fst);
		seq.addChild(rest);
		return seq;
	}

	@Override
	public BeginNode visitBegin(BeginContext ctx) {
		return new BeginNode();
	}

	@Override
	public InitialisationNode visitInitialisation(InitialisationContext ctx) {
		InitialisationNode initNode = new InitialisationNode(ctx.ident().getText(), Type.parse(ctx.type().getText()));
		AssignRHSNode rhs = (AssignRHSNode) visit(ctx.assign_rhs());
		initNode.addChild(rhs);
		return initNode;
	}

	@Override
	public BoolNode visitBool(BoolContext ctx) {
		return new BoolNode(Boolean.parseBoolean(ctx.getText()));
	}

	@Override
	public StringNode visitString(StringContext ctx) {
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
	public PrintlnNode visitPrintln(PrintlnContext ctx) {
		PrintlnNode printlnNode = new PrintlnNode();
		ExpNode printExp = (ExpNode) visit(ctx.exp());
		printlnNode.addChild(printExp);
		return printlnNode;
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
		return new ParamNode(Type.parse(ctx.type().getText()), ctx.ident().getText());
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
		AssignLHSNode lhs = (AssignLHSNode) visit(ctx.assign_lhs());
		AssignRHSNode rhs = (AssignRHSNode) visit(ctx.assign_rhs());
		AssignmentNode assign = new AssignmentNode();
		assign.addChild(lhs);
		assign.addChild(rhs);
		return assign;
	}

	@Override
	public IntNode visitInt(IntContext ctx) {
		return new IntNode(Integer.parseInt(ctx.getText()));
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
