package wacc.semantics;

import wacc.antlr.WACCParser.*;
import wacc.symbolTable.ScopeHandler;
import wacc.antlr.WACCParserBaseVisitor;

public class Visitor extends WACCParserBaseVisitor<Void> {
	
	private ScopeHandler scopeHandler = new ScopeHandler();
	private String nodeType = "null";
	private boolean identExists = false;
	
	/*
	 * Visits stats
	 */

	@Override
	public Void visitInitialisation(InitialisationContext ctx) {
		// TODO Add variable to current scope
		// TODO Check RHS type is equal to variable type
		System.out.println("Visiting initialisation: " + ctx.getText());
		String type = ctx.type().getText();
		String ident = ctx.ident().getText();
		try {
			scopeHandler.add(ident, type);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		visit(ctx.assign_rhs());
		//if (!nodeType.equals(type)) { // hacked below
		if (!type.contains(nodeType)) {
			// Set exit status to 200 ? Not sure how to do this.
			System.err.println("Error: Incompatible type at ' " + ctx.assign_rhs().getText() +
			" ' (Expected: " + type + ", Actual: " + nodeType + ")");
		}

		return super.visitInitialisation(ctx);
	}

	@Override
	public Void visitAssignment(AssignmentContext ctx) {
		// TODO Check LHS type = RHS type
		// TODO Check that idents exist
		System.out.println("Visiting assignment: " + ctx.getText());
		
		
		// LHS
		Assign_lhsContext lhs = ctx.assign_lhs();
		String lhsType = "";
		
		IdentContext ident = lhs.ident();
		if (ident != null) {
			visit(ident);
//			boolean exists = scopeHandler.exists(ident.getText());
			if (!identExists) {
				System.err.println("Error: Variable " + ident.getText() +
						" does not exist in the current scope");
			} else {
//				visit(ident);
				System.out.println("Context: " + lhs.getText());
				lhsType = nodeType;
				System.out.println("Type: " + lhsType);
			}
		}
		
		Array_elemContext array_elem = lhs.array_elem();
		if (array_elem != null) {
			//System.out.println("Context: " + lhs.getText());
			boolean exists = scopeHandler.exists(array_elem.ident().getText());
			if (!exists) {
				System.err.println("Error: Variable " + array_elem.ident().getText() +
						" does not exist in the current scope");
			} else {
				visit(array_elem);
				lhsType = nodeType;
			}
		}
		
		Pair_elemContext pair_elem = lhs.pair_elem();
		if (pair_elem != null) {
			boolean exists = scopeHandler.exists(pair_elem.exp().getText());
			if (!exists) {
				System.err.println("Error: Variable " + pair_elem.exp().getText() +
						" does not exist in the current scope");
			} else {
				visit(pair_elem);
				lhsType = nodeType;
			}
		}
		
		
		// RHS
		visit(ctx.assign_rhs());
		String rhsType = nodeType;
		if (!lhs.isEmpty()) {
			if (!rhsType.equals(lhsType)) {
				System.err.println("Error: Incompatible type at ' " + ctx.assign_rhs().getText() +
						" ' (Expected: " + lhsType + ", Actual: " + rhsType + ")");
			}
		}
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
		// DONE Expression must evaluate to an int
		visit(ctx.exp());
		if (!nodeType.equals("int")) {
			System.err.println("Exit statements expressions must evaluate to an int.");
		}
		return super.visitExit(ctx);
	}

	@Override
	public Void visitIf(IfContext ctx) {
		// DONE Check condition is a valid boolean or evaluates to one
		// DONE Increase symtab scope before visiting EACH child individually
		// DONE Reduce symtab scope after visiting EACH child individually
		visit(ctx.exp());
		if (!nodeType.equals("bool")) {
			System.err.println("If statement expressions must evaluate to bool type.");
		}
		for (StatContext stat : ctx.stat()) {
			scopeHandler.descend();
			visit(stat);
			scopeHandler.ascend();
		}
		return super.visitIf(ctx);
	}

	@Override
	public Void visitWhile(WhileContext ctx) {
		// DONE Check condition is a valid boolean or evaluates to one
		// DONE Increase symtab scope before visiting child
		// DONE Reduce symtab scope afterwards
		//System.out.println("visiting while");
		//System.out.println(ctx.exp().getText());
		visit(ctx.exp());
		if (!nodeType.equals("bool")) {
			//System.out.println(nodeType);
			System.err.println("While condition expressions must evaluate to bool type.");
		}
		scopeHandler.descend();
		visit(ctx.stat());
		scopeHandler.ascend();
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
	
	//This method is visited when a lookup into an array is being done
	@Override
	public Void visitArray_elem(Array_elemContext ctx) {
		// DONE check exp evaluates to a (positive) int
		visit(ctx.exp(0));
		if (!nodeType.equals("int")) {
			System.err.println("Arrays must be accessed using an int index.");
		}
		return super.visitArray_elem(ctx);
	}

	@Override
	public Void visitIdent(IdentContext ctx) {
		// DONE Set identExists to correct value if ident exists
		identExists = scopeHandler.exists(ctx.getText());
		return super.visitIdent(ctx);
	}
	
	@Override
	public Void visitUnaryOpExp(UnaryOpExpContext ctx) {
		// DONE Check expressions match types allowed by specified unary operator
		// DONE set nodeType = return type
		// '!' 		allows bool		returns bool
		// '-' 		allows int		returns int
		// 'len' 	allows arrays	returns int
		// 'ord' 	allows char		returns int
		// 'chr' 	allows int		returns char
		visit(ctx.exp());
		switch (ctx.unary_op().getText()) {
		case "!":
			if (!nodeType.equals("bool")) System.err.println("The '!' operator only works for boolean types.");
			nodeType = "bool";
			break;
		case "-":
			if (!nodeType.equals("int")) System.err.println("The '-' operator only works for integer types.");
			nodeType = "int";
			break;
		case "len":
			// TODO check node type is of array
			if (!nodeType.equals("ARRAYS?!?!")) System.err.println("The 'len' operator only works for array types.");
			nodeType = "int";
			break;
		case "ord":
			if (!nodeType.equals("char")) System.err.println("The 'ord' operator only works for char types.");
			nodeType = "int";
			break;
		case "chr":
			if (!nodeType.equals("int")) System.err.println("The 'chr' operator only works for int types.");
			nodeType = "char";
			break;
		default:
			nodeType = null;
			break;
		}
		return super.visitUnaryOpExp(ctx);
	}

	 @Override
	  public Void visitBinaryOpExp(BinaryOpExpContext ctx) {
	    // DONE Check LHS and RHS have same types
	    // DONE set nodeType = return type
	    // *, /, %, +, - take int return int
	    // >, >=, <, <= take int/char return bool
	    // ==, != take anything return bool
	    // &&, || take bool return bool
	    visit(ctx.exp(0));
	    if (!identExists) {
	      System.err.println("Error: undeclared variable");
	    }
	    String firstType = nodeType;
	    visit(ctx.exp(1));
	    if (!identExists) {
	      System.err.println("Error: undeclared variable");
	    }
	    String secondType = nodeType;

	    if (!firstType.equals(secondType)) {
	      System.err
	          .println("Both sides of a binary operator must have the same type.");
	    }

	    switch (ctx.binary_op().getText()) {
	    case "*":
	    case "/":
	    case "%":
	    case "+":
	    case "-":
	      if (!firstType.equals("int"))
	        System.err.println("*, /, %, +, - require ints.");
	      nodeType = "int";
	      break;
	    case ">":
	    case ">=":
	    case "<":
	    case "<=":
	      if (!firstType.equals("int") && !firstType.equals("char"))
	        System.err.println(">, >=, <, <= require ints or chars.");
	      nodeType = "bool";
	      break;
	    case "==":
	    case "!=":
	      nodeType = "bool";
	      break;
	    case "&&":
	    case "||":
	      if (!firstType.equals("bool"))
	        System.err.println("&&, || require bools.");
	      nodeType = "bool";
	      break;
	    default:
	      nodeType = "null";
	      break;
	    }
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
		// DONE Add param to current scope
		try {
			scopeHandler.add(ctx.ident().getText(), ctx.type().getText());
		} catch (Exception e) {
			System.err.println("Identifier already exists.");
		}
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