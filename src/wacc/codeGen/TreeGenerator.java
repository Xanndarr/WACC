package wacc.codeGen;

import wacc.antlr.WACCParser.*;
import wacc.antlr.WACCParserBaseVisitor;
import wacc.tree.nodeSupers.*;
import wacc.tree.nodes.*;
import wacc.tree.nodes.PairElemNode.PairPos;
import wacc.util.BinaryOp;
import wacc.util.UnaryOp;

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
		return new IdentNode(ctx.getText());
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
	public ForNode visitFor(ForContext ctx) {
		ForNode forNode = new ForNode();
		IdentNode ident = (IdentNode) visit(ctx.ident());
		forNode.addChild(ident);
		ExpNode startBound = (ExpNode) visit(ctx.range().exp(0));
		forNode.addChild(startBound);
		ExpNode endBound = (ExpNode) visit(ctx.range().exp(1));
		forNode.addChild(endBound);
		StatNode stat = (StatNode) visit(ctx.stat());
		forNode.addChild(stat);
		return forNode;
	}

	@Override
	public BinaryOpNode visitAndOpExp(AndOpExpContext ctx) {
        BinaryOpNode op = new BinaryOpNode(BinaryOp.parse(ctx.and_op().getText()));
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
		Node lhs; 
		try {
            try {
                try {
                    lhs = (AssignLHSNode) visit(ctx.assign_lhs());
                } catch (ClassCastException ex) {
                    lhs = (ArrayElemNode) visit(ctx.assign_lhs());
                }
            } catch (ClassCastException e) {
                lhs = (PairElemNode) visit(ctx.assign_lhs());
            }
		} catch (ClassCastException e) {
			lhs = (IdentNode) visit(ctx.assign_lhs());
		}
        read.addChild(lhs);
        return read;
	}

	@Override
	public ArrayNode visitArray_lit(Array_litContext ctx) {
		ArrayNode array = new ArrayNode();
		for (ExpContext exp : ctx.exp()) {
			array.addChild(visit(exp));
		}
		return array;
	}
	
	@Override
	public ArrayElemNode visitArray_elem(Array_elemContext ctx) {
		ArrayElemNode arrayElem = new ArrayElemNode();
		IdentNode ident = (IdentNode) visit(ctx.ident());
		arrayElem.addChild(ident);
		for (ExpContext exp : ctx.exp()) {
			arrayElem.addChild(visit(exp));
		}
		return arrayElem;
	}

	@Override
	public BinaryOpNode visitEqualityOpExp(EqualityOpExpContext ctx) {
        BinaryOpNode ret = new BinaryOpNode(BinaryOp.parse(ctx.equality_op().getText()));
        ExpNode exp1 = (ExpNode) visit(ctx.exp().get(0));
        ExpNode exp2 = (ExpNode) visit(ctx.exp().get(1));
        ret.addChild(exp1);
        ret.addChild(exp2);
        return ret;
	}

	@Override
	public BinaryOpNode visitOrOpExp(OrOpExpContext ctx) {
        BinaryOpNode op = new BinaryOpNode(BinaryOp.parse(ctx.or_op().getText()));
        ExpNode exp1 = (ExpNode) visit(ctx.exp().get(0));
        ExpNode exp2 = (ExpNode) visit(ctx.exp().get(1));
        op.addChild(exp1);
        op.addChild(exp2);
        return op;
	}

	@Override
	public ExitNode visitExit(ExitContext ctx) {
		ExitNode exitNode = new ExitNode();
		ExpNode exitExp = (ExpNode) visit(ctx.exp());
		exitNode.addChild(exitExp);
		return exitNode;
	}

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
		BeginNode begin = new BeginNode();
        StatNode stat = (StatNode) visit(ctx.stat());
        begin.addChild(stat);
        return begin;
	}

	@Override
	public InitialisationNode visitInitialisation(InitialisationContext ctx) {
		InitialisationNode initNode = new InitialisationNode(ctx.type().getText());
		IdentNode ident = (IdentNode) visit(ctx.ident());
		AssignRHSNode rhs = (AssignRHSNode) visit(ctx.assign_rhs());
		initNode.addChild(ident);
		initNode.addChild(rhs);
		return initNode;
	}

	@Override
	public Node visitShortAssign(ShortAssignContext ctx) {
		IdentExpNode lhs = new IdentExpNode(ctx.ident().getText());
		ExpNode binOp = new BinaryOpNode(BinaryOp.swap(ctx.short_assign().getText()));
		ExpNode binOpLhs = (ExpNode) visit(ctx.ident());
		ExpNode binOpRhs = new IntNode(1);
		binOp.addChild(binOpLhs);
		binOp.addChild(binOpRhs);
		AssignmentNode assign = new AssignmentNode();
		assign.addChild(lhs);
		assign.addChild(binOp);
		return assign;
	}

	@Override
	public Node visitSideEffectOp(SideEffectOpContext ctx) {
		IdentExpNode lhs = new IdentExpNode(ctx.ident().getText());
		ExpNode binOp = new BinaryOpNode(BinaryOp.swap(ctx.side_effect_op().getText()));
		ExpNode binOpLhs = (ExpNode) visit(ctx.ident());
		ExpNode binOpRhs = (ExpNode) visit(ctx.exp());
		binOp.addChild(binOpLhs);
		binOp.addChild(binOpRhs);
		AssignmentNode assign = new AssignmentNode();
		assign.addChild(lhs);
		assign.addChild(binOp);
		return assign;	
	}

	@Override
	public BoolNode visitBool(BoolContext ctx) {
		return new BoolNode(Boolean.parseBoolean(ctx.getText()));
	}

	@Override
	public StringNode visitString(StringContext ctx) {
		return new StringNode(ctx.getText().substring(1, ctx.getText().length() - 1));
	}

	@Override
	public BinaryOpNode visitOrderingOpExp(OrderingOpExpContext ctx) {
        BinaryOpNode op = new BinaryOpNode(BinaryOp.parse(ctx.ordering_op().getText()));
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
		return new TypeNode();
	}
	
	@Override
	public PairNode visitPair(PairContext ctx) {
		return new PairNode();
	}

	@Override
	public NewPairNode visitNewPairRHS(NewPairRHSContext ctx) {
		NewPairNode newpair = new NewPairNode();
		for (ExpContext exp : ctx.exp()) {
			newpair.addChild(visit(exp));
		}
		return newpair;
	}

	@Override
	public UnaryOpNode visitUnaryOpExp(UnaryOpExpContext ctx) {
        UnaryOpNode op = new UnaryOpNode(UnaryOp.parse(ctx.unary_op().getText()));
        ExpNode exp1 = (ExpNode) visit(ctx.exp());
        op.addChild(exp1);
        return op;
	}

	@Override
	public ExpNode visitBracketedExp(BracketedExpContext ctx) {
		ExpNode exp = (ExpNode) visit(ctx.exp());
		return exp;
	}

	@Override
	public ParamNode visitParam(ParamContext ctx) {
		return new ParamNode(ctx.ident().getText(), ctx.type().getText());
	}

	@Override
	public BinaryOpNode visitAsArithmeticOpExp(AsArithmeticOpExpContext ctx) {
        BinaryOpNode op = new BinaryOpNode(BinaryOp.parse(ctx.as_arithmetic_op().getText()));
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
        BinaryOpNode op = new BinaryOpNode(BinaryOp.parse(ctx.dm_arithmetic_op().getText()));
        ExpNode exp1 = (ExpNode) visit(ctx.exp().get(0));
        ExpNode exp2 = (ExpNode) visit(ctx.exp().get(1));
        op.addChild(exp1);
        op.addChild(exp2);
        return op;
	}

	@Override
	public AssignmentNode visitAssignment(AssignmentContext ctx) {
		Node lhs;
		try {
			try {
                try {
                    lhs = (AssignLHSNode) visit(ctx.assign_lhs());
                } catch (ClassCastException ex) {
                    lhs = (ArrayElemNode) visit(ctx.assign_lhs());
                }
			} catch (ClassCastException e) {
                lhs = (PairElemNode) visit(ctx.assign_lhs());
			}
		} catch (ClassCastException e) {
			lhs = (IdentNode) visit(ctx.assign_lhs());
		}
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

	@Override
	public IdentExpNode visitIdentExp(IdentExpContext ctx) {
		return new IdentExpNode(ctx.ident().getText());
	}

	@Override
	public ParamListNode visitParam_list(Param_listContext ctx) {
		ParamListNode paramListNode = new ParamListNode();
		for (ParamContext p : ctx.param()) {
			paramListNode.addChild(visitParam(p));
		}
		return paramListNode;
	}

	@Override
	public PrintNode visitPrint(PrintContext ctx) {
		PrintNode printNode = new PrintNode();
		ExpNode printExp = (ExpNode) visit(ctx.exp());
		printNode.addChild(printExp);
		return printNode;
	}

	@Override
	public FunctionNode visitFunc(FuncContext ctx) {
		String ident = ctx.ident().getText();
		String type = ctx.type().getText();
		FunctionNode func = new FunctionNode(ident, type);
		if (ctx.param_list() != null) {
			ParamListNode args = (ParamListNode) visit(ctx.param_list());
			func.addChild(args);
		}
		StatNode stats = (StatNode) visit(ctx.stat());
		func.addChild(stats);
		return func;
	}
	
	@Override
	public FunctionCallNode visitFunCallRHS(FunCallRHSContext ctx) {
		IdentNode ident = (IdentNode) visit(ctx.ident());
		FunctionCallNode func = new FunctionCallNode(ident.getIdent());
		func.addChild(ident);
		if (ctx.arg_list() != null) {
			func.addChild(visit(ctx.arg_list()));
		}
		return func;
	}

	@Override
	public ExpNode visitExpRHS(ExpRHSContext ctx) {
		return (ExpNode) visit(ctx.exp());
	}

	@Override
	public ArrayNode visitArrayLitRHS(ArrayLitRHSContext ctx) {
		return (ArrayNode) visit(ctx.array_lit());
	}

	@Override
	public PairElemNode visitPairElemRHS(PairElemRHSContext ctx) {
		return (PairElemNode) visit(ctx.pair_elem());
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
		if (ctx.getText().contains("\\")) {
			return new CharNode(ctx.getText().charAt(2));
		}
		return new CharNode(ctx.getText().charAt(1));
	}

	@Override
	public ReturnNode visitReturn(ReturnContext ctx) {
		ReturnNode ret = new ReturnNode();
		ExpNode retExp = (ExpNode) visit(ctx.exp());
		ret.addChild(retExp);
		return ret;
	}

	@Override
	public SkipNode visitSkip(SkipContext ctx) {
		return new SkipNode();
	}

	@Override
	public Node visitDoWhile(DoWhileContext ctx) {
		DoWhileNode doWhileNode = new DoWhileNode();
		StatNode stat = (StatNode) visit(ctx.stat());
		doWhileNode.addChild(stat);
		ExpNode exp = (ExpNode) visit(ctx.exp());
		doWhileNode.addChild(exp);
		return doWhileNode;
	}

	@Override
	public Node visitContinue(ContinueContext ctx) {
		return new ContinueNode();
	}

	@Override
	public Node visitBreak(BreakContext ctx) {
		return new BreakNode();
	}

}
