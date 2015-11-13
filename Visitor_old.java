package wacc.semantics;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import wacc.antlr.*;
import wacc.antlr.WACCParser.*;
import wacc.symbolTable.ScopeHandler;

public class Visitor_old extends WACCParserBaseVisitor<Void> {

	ScopeHandler scopeHandler = new ScopeHandler();
	
	@Override
	public Void visitProgram(ProgramContext ctx) {
		return visitChildren(ctx);
	}
	
	@Override
	public Void visitFunc(FuncContext ctx) {
		String ident = ctx.getChild(1).getText();
		String type = ctx.getChild(0).getText();
		try {
			scopeHandler.add(ident, type);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return visitChildren(ctx);
	}

	@Override
	public Void visitParam(ParamContext ctx) {
		String ident = ctx.getChild(1).getText();
		String type = ctx.getChild(0).getText();
		try {
			scopeHandler.add(ident, type);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return visitChildren(ctx);
	}

	//unimplemented
	@Override
	public Void visitBinary_op(Binary_opContext ctx) {
		return visitChildren(ctx);
	}

	@Override
	public Void visitArray_lit(Array_litContext ctx) {
		System.out.println("WE PRTINGIN");
		
		ParseTree firstElem = ctx.getChild(1);
		for (int i = 1; i < ctx.children.size(); i += 2) {
			firstElem.getClass(); ctx.getChild(i);
		}
		System.out.println("WE FINISHED");
		return visitChildren(ctx);
	}

	//
	@Override
	public Void visitWhile(WhileContext ctx) {
		return visitChildren(ctx);
	}

	@Override
	public Void visitFree(FreeContext ctx) {
		System.out.println("Visiting 'Free' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitIdent(IdentContext ctx) {
		System.out.println("Visiting 'Ident' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitPrintln(PrintlnContext ctx) {
		System.out.println("Visiting 'Println' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitInitialisation(InitialisationContext ctx) {
		System.out.println("Visiting 'Initialisation' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitIf(IfContext ctx) {
		System.out.println("Visiting 'If' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitRead(ReadContext ctx) {
		System.out.println("Visiting 'Read' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitReturn(ReturnContext ctx) {
		System.out.println("Visiting 'Return' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitBegin(BeginContext ctx) {
		System.out.println("Visiting 'Begin' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitSequence(SequenceContext ctx) {
		System.out.println("Visiting 'Sequence' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitUnary_op(Unary_opContext ctx) {
		System.out.println("Visiting 'Unary Op' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitArray_type(Array_typeContext ctx) {
		System.out.println("Visiting 'Array_type' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitPair_elem(Pair_elemContext ctx) {
		System.out.println("Visiting 'Pair_elem' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitNumber(NumberContext ctx) {
		System.out.println("Visiting 'Number' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitBase_type(Base_typeContext ctx) {
		System.out.println("Visiting 'Base_type' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitPair_type(Pair_typeContext ctx) {
		System.out.println("Visiting 'Pair_type' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitAssign_lhs(Assign_lhsContext ctx) {
		System.out.println("Visiting 'Assign_lhs' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitPrint(PrintContext ctx) {
		System.out.println("Visiting 'Print' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitExit(ExitContext ctx) {
		System.out.println("Visiting 'Exit' node");
		try {
			Integer.parseInt(ctx.getChild(1).getText());
		} catch (NumberFormatException e) {
			
		}
		return visitChildren(ctx);
	}

	@Override
	public Void visitParam_list(Param_listContext ctx) {
		return visitChildren(ctx);
	}

	@Override
	public Void visitInt_lit(Int_litContext ctx) {
		System.out.println("Visiting 'Int Lit' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitArg_list(Arg_listContext ctx) {
		System.out.println("Visiting 'Arg List' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitAssignment(AssignmentContext ctx) {
		System.out.println("Visiting 'Assignment' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitArray_elem(Array_elemContext ctx) {
		System.out.println("Visiting 'Array Elem' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitPair_elem_type(Pair_elem_typeContext ctx) {
		System.out.println("Visiting 'Pair Elem Type' node");
		return visitChildren(ctx);
	}

	@Override
	public Void visitAssign_rhs(Assign_rhsContext ctx) {
		System.out.println("Visiting 'Assign Rhs' node");
		return visitChildren(ctx);
	}
	
	@Override
	public Void visitArrayElem(ArrayElemContext ctx) {
		// TODO Auto-generated method stub
		return super.visitArrayElem(ctx);
	}

	@Override
	public Void visitSkip(SkipContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSkip(ctx);
	}

	@Override
	public Void visitUnaryOp(UnaryOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitUnaryOp(ctx);
	}

	@Override
	public Void visitType(TypeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitType(ctx);
	}

	@Override
	public Void visitBracketedExp(BracketedExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBracketedExp(ctx);
	}

	@Override
	public Void visitBinaryOp(BinaryOpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBinaryOp(ctx);
	}

	@Override
	public Void visitIdentExp(IdentExpContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIdentExp(ctx);
	}

	@Override
	public Void visitPair(PairContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPair(ctx);
	}
	
	/*
	 * Visit base types
	 */
	
	@Override
	public Void visitInt(IntContext ctx) {
		// TODO Auto-generated method stub
		return super.visitInt(ctx);
	}

	@Override
	public Void visitChar(CharContext ctx) {
		// TODO Auto-generated method stub
		return super.visitChar(ctx);
	}
	
	@Override
	public Void visitBool(BoolContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBool(ctx);
	}

	@Override
	public Void visitString(StringContext ctx) {
		// TODO Auto-generated method stub
		return super.visitString(ctx);
	}

}