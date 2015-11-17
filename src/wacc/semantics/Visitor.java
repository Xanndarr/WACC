package wacc.semantics;

import java.util.Collection;
import java.util.Iterator;

import wacc.antlr.WACCParser.*;
import wacc.symbolTable.FunctionHandler;
import wacc.symbolTable.ScopeHandler;

import wacc.antlr.WACCParserBaseVisitor;

public class Visitor extends WACCParserBaseVisitor<Void> {

	private ScopeHandler scopeHandler = new ScopeHandler();
	private FunctionHandler functionHandler = new FunctionHandler();
	private String nodeType = "null";
	private String function = "null";
	private boolean hasReturn = false;
	private int returnCode = 0;
	
	@Override
	public Void visitProgram(ProgramContext ctx) {
		for (FuncContext func : ctx.func()) {
			String functionIdent = func.ident().getText();
			String functionType = func.type().getText();

			if (!functionHandler.exists(functionIdent)) {
				functionHandler.add(functionIdent, functionType);
			} else {
				System.err.println("Error: Function '" + functionIdent + "' already exists.");
				returnCode = 200;
			}
			
			if (func.param_list() != null) {
				for (ParamContext param : func.param_list().param()) {
					String paramIdent = param.ident().getText();
					String paramType = param.type().getText();

					if (!functionHandler.existsParam(functionIdent, paramIdent)) {
						if (paramType.contains("pair")) {
							functionHandler.addParam(functionIdent, paramIdent, paramType, "", "");
						} else {
							functionHandler.addParam(functionIdent, paramIdent, paramType);
						}
					} else {
						System.err.println("Error: Parameter with name '" + paramIdent
								+ "' alerady exists within this function definition. ");
						returnCode = 200;
					}
				}
			}
		}
		visit(ctx.stat());
		for (FuncContext func : ctx.func()) {
			scopeHandler.ascendFun();
			hasReturn = false;
			visit(func);
			if (!hasReturn) {
				System.err.println("Error: A function must always be able to return.");
				returnCode = 100;
			}
			scopeHandler.descendFun();
		}
		return null;
	}

	/*
	 * Visits stats
	 */

	@Override
	public Void visitInitialisation(InitialisationContext ctx) {
		// DONE Add variable to current scope
		// DONE Check RHS type is equal to variable type
		System.out.println("Visiting initialisation: " + ctx.getText());
		String type = ctx.type().getText();
		String ident = ctx.ident().getText();
		if (!scopeHandler.existsCurrentScope(ident)) {
			if (type.contains("pair")) {
				String pairType = type.replace("pair(", "").replace(")", "");
				String fstType = pairType.substring(0, pairType.indexOf(","));
				String sndType = pairType.substring(pairType.indexOf(",") + 1, pairType.length());
				
				String fstRef = "null";
				String sndRef = "null";
				
				String rhs = ctx.assign_rhs().getText();
				if (rhs.equals("null")) {
					scopeHandler.add(ident, type, "null", "null");
					return null;
				}
				
				Pair_elemContext rhsPair = ctx.assign_rhs().pair_elem();
				if (rhsPair != null) {
					String pairIdent = rhsPair.exp().getText();
					String pairPointer;
					if (rhsPair.getChild(0).getText().equals("fst")) {
						pairPointer = scopeHandler.get(pairIdent, "fst");
					} else {
						System.out.println(pairIdent);
						pairPointer = scopeHandler.get(pairIdent, "snd");
					}
					rhs = pairPointer;
				}
				
				if (rhs.contains("newpair")) {
					if (fstType.equals("pair")) {
						fstRef = ctx.assign_rhs().exp(0).getText();
					}
					if (sndType.equals("pair")) {
						sndRef = ctx.assign_rhs().exp(1).getText();
					}
				} 
//				else {
//					if (fstType.equals("pair")) {
//						System.out.println("TESTING HERE NOW: " + fstType);
//						System.out.println("TESTING HERE NOW: " + ctx.assign_rhs().getText());
//						System.out.println("TESTING HERE NOW: " + ctx.assign_rhs().pair_elem().exp().getText());
//						fstType = scopeHandler.get(ctx.assign_rhs().pair_elem().exp().getText(), "fst");
//					}
//					if (sndType.equals("pair")) {
//						sndType = scopeHandler.get(ctx.assign_rhs().pair_elem().exp().getText(), "snd");
//					}
//					//visit(ctx.assign_rhs());
//				}
				
				scopeHandler.add(ident, type, fstRef, sndRef);
			} else {
				scopeHandler.add(ident, type);
			}
		} else {
			System.err.println("Error: The variable '" + ident + "' already exists.");
			returnCode = 200;
		}

		visit(ctx.assign_rhs());
		// if (!nodeType.equals(type)) { // hacked below
		// String rhsType = ctx.assign_rhs().exp(); <-- viting these and they
		// will give you types...then do "pair(" + type1 +","+ type2 + ")"
		if (!nodeType.equals("null") && !type.contains(nodeType)) {
			// TODO Set exit status to 200 ? Not sure how to do this.
			System.err.println("Error: Incompatible type while initialising '" + ctx.ident().getText() + "' (Expected: " + type
					+ ", Actual: " + nodeType + ")");
			returnCode = 200;
		}

		return null;
	}

	@Override
	public Void visitAssignment(AssignmentContext ctx) {
		// DONE Check LHS type = RHS type
		// DONE Check that idents exist
		System.out.println("Visiting assignment: " + ctx.getText());

		// LHS
		Assign_lhsContext lhs = ctx.assign_lhs();
		String lhsType = "";
		
		Array_elemContext array_elem = lhs.array_elem();
		if (array_elem != null) {
			if (!scopeHandler.exists(array_elem.ident().getText())) {
				System.err.println(
						"Error: Variable " + array_elem.ident().getText() + " does not exist in the current scope");
				returnCode = 200;
			} else {
				lhsType = scopeHandler.get(array_elem.ident().getText()).replace("[]", "");
			}
		}

		Pair_elemContext pair_elem = lhs.pair_elem();
		if (pair_elem != null) {
			if (!scopeHandler.exists(pair_elem.exp().getText())) {
				System.err.println(
						"Error: Variable " + pair_elem.exp().getText() + " does not exist in the current scope");
				returnCode = 200;
			} else {
				visit(pair_elem);
				lhsType = nodeType;
			}
		}

		IdentContext ident = lhs.ident();
		if (ident != null) {
			if (!scopeHandler.exists(ident.getText())) {
				System.err.println("Error: Variable " + ident.getText() + " does not exist in the current scope");
				returnCode = 200;
			} else {
				System.out.println("Context: " + ident.getText());
				lhsType = scopeHandler.get(ident.getText());
				System.out.println("Type: " + lhsType);
			}
		}

		// RHS
		visit(ctx.assign_rhs());
		String rhsType = nodeType;
		if (rhsType.equals("null")) {
			rhsType = lhsType;
		}
		if (!(lhsType.equals("string") && rhsType.equals("char")) && !rhsType.equals(lhsType)) {
			System.err.println("Error: Incompatible type at '" + ctx.assign_rhs().getText() + "' (Expected: "
					+ lhsType + ", Actual: " + rhsType + ")");
			returnCode = 200;
		}
		return null;
	}

	@Override
	public Void visitRead(ReadContext ctx) {
		// DONE Check type is = program variable | pair elem | array elem
		// DONE Type must be either int, string(?) or char().getText());
		System.out.println("READING : " + ctx.assign_lhs().getText());
		String lhsAssign = ctx.assign_lhs().getText();
		lhsAssign = lhsAssign.replace("fst", "").replace("snd", "");
		if (scopeHandler.exists(lhsAssign)) {
			String lhsType = scopeHandler.get(lhsAssign);
			if (lhsType.contains("pair") && ctx.assign_lhs().pair_elem() == null) {
				System.err.println("Error: Pair element did not make use of the necessary 'fst' or 'snd' keywords");
				returnCode = 200;
			}
			boolean validReadType = lhsType.equals("int") 
					|| lhsType.equals("string") 
					|| lhsType.equals("char")
					|| lhsType.contains("pair");

			if (!(lhsType.contains("[]") || validReadType)) {
				System.err.println("Error: Type given to read ' " + lhsType + " ' is not a compatible type with read");
				returnCode = 200;
			}
		} else {
			System.err.println("Error: Variable input for read, ' " + lhsAssign + " ' does not exist in scope");
			returnCode = 200;
		}

		return super.visitRead(ctx);
	}

	@Override
	public Void visitFree(FreeContext ctx) {
		// DONE Type must be either array or pair
		// DONE Type must not be an array of an array or an array of a pair or a
		// pair of arrays etc.
		System.out.println("FREEING : " + ctx.exp().getText());
		visit(ctx.exp());
		if (nodeType.contains("pair")) {
			if (!scopeHandler.get(ctx.exp().getText(), "fst").equals("null") && !scopeHandler.get(ctx.exp().getText(), "snd").equals("null")) {
				System.err.println("Error: Free can't free nested pairs.");
				returnCode = 200;
			}
		} else if (nodeType.contains("[]")) {
			if (nodeType.replace("[]", "").length() != nodeType.length() - "[]".length()) {
				System.err.println("Error: Free can't free nested arrays.");
				returnCode = 200;
			}
		} else {
			System.err.println("Error: Free can only free arrays and pairs.");
			returnCode = 200;
		}
		return super.visitFree(ctx);
	}

	@Override
	public Void visitExit(ExitContext ctx) {
		// DONE Expression must evaluate to an int
		visit(ctx.exp());
		if (!nodeType.equals("int")) {
			System.err.println("Error: Exit statements expressions must evaluate to an int.");
			returnCode = 200;
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
			System.err.println("Error: If statement expressions must evaluate to bool type.");
			returnCode = 200;
		}
		boolean ifHasReturn = true;
		for (StatContext stat : ctx.stat()) {
			scopeHandler.descend();
			hasReturn = false;
			visit(stat);
			ifHasReturn = ifHasReturn && hasReturn;
			scopeHandler.ascend();
		}
		hasReturn = ifHasReturn;
		return null;
	}

	@Override
	public Void visitWhile(WhileContext ctx) {
		// DONE Check condition is a valid boolean or evaluates to one
		// DONE Increase symtab scope before visiting child
		// DONE Reduce symtab scope afterwards
		// System.out.println("visiting while");
		// System.out.println(ctx.exp().getText());
		visit(ctx.exp());
		if (!nodeType.equals("bool")) {
			// System.out.println(nodeType);
			System.err.println("Error: While condition expressions must evaluate to bool type.");
			returnCode = 200;
		}
		scopeHandler.descend();
		boolean tempHasReturn = hasReturn;
		visit(ctx.stat());
		hasReturn = tempHasReturn;
		scopeHandler.ascend();
		return null;
	}
	
	@Override
	public Void visitBegin(BeginContext ctx) {
		System.out.println("WE BEGINNIN");
		scopeHandler.descend();
		System.out.println(ctx.stat().getText());
		visit(ctx.stat());
		scopeHandler.ascend();
		System.out.println("WE BEGINNIN DONE");
		return null;
	}

	@Override
	public Void visitReturn(ReturnContext ctx) {
		// DONE Expression must be same type as function return type
		System.out.println("Visiting return");
		hasReturn = true;
		if (function.equals("null")) {
			System.err.println("Error: Can't 'return' from the main program body.");
			returnCode = 200;
			return null;
		}
		visit(ctx.exp());
		String returnType = nodeType;
		String functionType = functionHandler.getReturnType(function);
		if (!returnType.equals(functionType)) {
			System.err.println("Error: Incompatible type at '" + ctx.getText() + "' (Expected: " + functionType
					+ ", Actual: " + returnType + ")");
			returnCode = 200;
		}
		return null;
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
		nodeType = "null";
		return super.visitPair(ctx);
	}

	// This method is visited when a lookup into an array is being done
	@Override
	public Void visitArray_elem(Array_elemContext ctx) {
		// DONE check exp evaluates to a (positive) int
		visit(ctx.exp(0));
		if (!nodeType.equals("int")) {
			System.err.println("Error: Arrays must be accessed using an int index.");
			returnCode = 200;
		}
		visit(ctx.ident());
		nodeType = nodeType.replace("[]", "");
		return null;
	}

	@Override
	public Void visitIdent(IdentContext ctx) {
		// DONE Set identExists to correct value if ident exists
		String ident = ctx.getText();
		if (scopeHandler.exists(ident)) {
			System.out.println("IDENTIFINNGI" + nodeType);
			nodeType = scopeHandler.get(ident);
			System.out.println("IDENTIFINNGI" + nodeType);
		} else if (functionHandler.exists(ident)) {
			nodeType = functionHandler.getReturnType(ident);
		} else {
			System.err.println("Error: Identifier '" + ctx.getText() + "' does not exist.");
			returnCode = 200;
		}
		return super.visitIdent(ctx);
	}

	@Override
	public Void visitUnaryOpExp(UnaryOpExpContext ctx) {
		// DONE Check expressions match types allowed by specified unary
		// operator
		// DONE set nodeType = return type
		// '!' allows bool returns bool
		// '-' allows int returns int
		// 'len' allows arrays returns int
		// 'ord' allows char returns int
		// 'chr' allows int returns char
		visit(ctx.exp());
		switch (ctx.unary_op().getText()) {
		case "!":
			if (!nodeType.equals("bool")) {
				System.err.println("Error: The '!' operator only works for boolean types.");
				returnCode = 200;
			}
			nodeType = "bool";
			break;
		case "-":
			if (!nodeType.equals("int")) {
				System.err.println("Error: The '-' operator only works for integer types.");
				returnCode = 200;
			}
			nodeType = "int";
			break;
		case "len":
			if (!nodeType.contains("[]")) {
				System.err.println("Error: The 'len' operator only works for array types.");
				returnCode = 200;
			}
			nodeType = "int";
			break;
		case "ord":
			if (!nodeType.equals("char")) {
				System.err.println("Error: The 'ord' operator only works for char types.");
				returnCode = 200;
			}
			nodeType = "int";
			break;
		case "chr":
			if (!nodeType.equals("int")) {
				System.err.println("Error: The 'chr' operator only works for int types.");
				returnCode = 200;
			}
			nodeType = "char";
			break;
		default:
			nodeType = null;
			break;
		}
		return null;
	}

//	@Override
//	public Void visitBinaryOpExp(BinaryOpExpContext ctx) {
//		// DONE Check LHS and RHS have same types
//		// DONE set nodeType = return type
//		// *, /, %, +, - take int return int
//		// >, >=, <, <= take int/char return bool
//		// ==, != take anything return bool
//		// &&, || take bool return bool
//		System.out.println("VISITING BINARY OP");
//		ExpContext lhs = ctx.exp(0);
//		ExpContext rhs = ctx.exp(1);
//		System.out.println("WE PRINTING SOEM EXPS");
//		for (ParseTree exp : ctx.exp()) {
//			System.out.println(exp.getText());
//		}
//		System.out.println("BINARY OP: " + ctx.binary_op().getText());
//		System.out.println("WE DONE PRINTING SOME EXPS");
//		System.out.println(ctx.exp(0).getText());
//		System.out.println(ctx.exp(1).getText());
////		System.out.println("lhs: " + lhs.getText() + ", rhs: " + rhs.getText());
////		if (!scopeHandler.exists(lhs.getText()) || !scopeHandler.exists(rhs.getText())) {
////			System.err.println("Error: Undeclared variable: '" + lhs.getText() + "'." + rhs.getText());
////		}
//		visit(lhs);
//		String lhsType = nodeType;
//		System.out.println(lhs.getText() + " ::: " + lhsType);
//		visit(rhs);
//		String rhsType = nodeType;
//		System.out.println(rhs.getText() + " ::: " + rhsType);
//
//		if (!lhsType.equals(rhsType)) {
//			System.err.println("Error: Both sides of a binary operator must have the same type.");
//		}
//
//		switch (ctx.binary_op().getText()) {
//		case "*":
//		case "/":
//		case "%":
//		case "+":
//		case "-":
//			if (!lhsType.equals("int"))
//				System.err.println("Error: *, /, %, +, - require ints.");
//			nodeType = "int";
//			break;
//		case ">":
//		case ">=":
//		case "<":
//		case "<=":
//			if (!lhsType.equals("int") && !lhsType.equals("char"))
//				System.err.println("Error: >, >=, <, <= require ints or chars.");
//			nodeType = "bool";
//			break;
//		case "==":
//		case "!=":
//			nodeType = "bool";
//			break;
//		case "&&":
//		case "||":
//			if (!lhsType.equals("bool"))
//				System.err.println("Error: &&, || require bools.");
//			nodeType = "bool";
//			break;
//		default:
//			nodeType = "null";
//			break;
//		}
//		return null;
//	}
	
	private String checkBinaryOpTypes(ExpContext lhs, ExpContext rhs) {
		visit(lhs);
		String lhsType = nodeType;
		System.out.println("UGH 1");
		System.out.println(nodeType);
		System.out.println(lhsType.length());
		visit(rhs);
		String rhsType = nodeType;
		System.out.println("UGH 2");
		System.out.println(rhsType.length());

		System.out.println("UGH 3");
		
		if (!(lhsType.contains("pair") && rhsType.equals("null") || rhsType.contains("pair") && lhsType.equals("null"))) {
			if (!lhsType.equals(rhsType)) {
				System.err.println("Error: Both sides of a binary operator must have the same type.");
				returnCode = 200;
			}
		}
		
		return lhsType;
	}

	@Override
	public Void visitDmArithmeticOpExp(DmArithmeticOpExpContext ctx) {
		String type = checkBinaryOpTypes(ctx.exp(0), ctx.exp(1));
		if (!type.equals("int")) {
			System.err.println("Error: Operator '" + ctx.dm_arithmetic_op().getText() + "' expecting type int");
			returnCode = 200;
		}
		nodeType = "int";
		return null;
	}
	
	@Override
	public Void visitAsArithmeticOpExp(AsArithmeticOpExpContext ctx) {
		String type = checkBinaryOpTypes(ctx.exp(0), ctx.exp(1));
		if (!type.equals("int")) {
			System.err.println("Error: Operator '" + ctx.as_arithmetic_op().getText() + "' expecting type int");
			returnCode = 200;
		}
		nodeType = "int";
		return null;
	}

	@Override
	public Void visitOrderingOpExp(OrderingOpExpContext ctx) {
		System.out.println("Visiting " + ctx.ordering_op().getText());
		System.out.println(ctx.exp(0).getText());
		System.out.println(ctx.exp(1).getText());
		String type = checkBinaryOpTypes(ctx.exp(0), ctx.exp(1));
		System.out.println(type);
		if (!type.equals("int") && !type.equals("char")) {
			System.err.println("Error: Operator '" + ctx.ordering_op().getText() + "' expecting type char or int");
			returnCode = 200;
		}
		nodeType = "bool";
		return null;
	}

	@Override
	public Void visitEqualityOpExp(EqualityOpExpContext ctx) {
		checkBinaryOpTypes(ctx.exp(0), ctx.exp(1));
		nodeType = "bool";
		return null;
	}
	
	@Override
	public Void visitAndOpExp(AndOpExpContext ctx) {
		String type = checkBinaryOpTypes(ctx.exp(0), ctx.exp(1));
		if (!type.equals("bool")) {
			System.err.println("Error: Operator '" + ctx.and_op().getText() + "' expecting type bool");
			returnCode = 200;
		}
		nodeType = "bool";
		return null;
	}

	@Override
	public Void visitOrOpExp(OrOpExpContext ctx) {
		String type = checkBinaryOpTypes(ctx.exp(0), ctx.exp(1));
		if (!type.equals("bool")) {
			System.err.println("Error: Operator '" + ctx.or_op().getText() + "' expecting type bool");
			returnCode = 200;
		}
		nodeType = "bool";
		return null;
	}

	/*
	 * Visit other rules
	 */

	@Override
	public Void visitFunc(FuncContext ctx) {
		// DONE Increase symtab scope, visit children, then decrease symtab
		// scope
		// DONE Possibly add parameters to a global function signature tracker
		// DONE Check every path of execution contains a return statement
		System.out.println("VISITING FUNCTION");
		
		function = ctx.ident().getText();

		scopeHandler.descend();

		if (ctx.param_list() != null) {
			for (ParamContext param : ctx.param_list().param()) {
				String paramIdent = param.ident().getText();
				String paramType = param.type().getText();

				if (paramType.contains("pair")) {
					scopeHandler.add(paramIdent, paramType, "", "");
				} else {
					scopeHandler.add(paramIdent, paramType);
				}
			}
		}
		
//		for (ParseTree s : ctx.stat().children) {
//			System.out.println(s.getText());
//			System.out.println("==");
//		}

		visit(ctx.stat());
		System.out.println("HOLLER: " + ctx.stat().getText());
		scopeHandler.ascend();
		System.out.println("VISITING FUNCTION DONE");

		return null;
	}

	@Override
	public Void visitArray_lit(Array_litContext ctx) {
		// DONE Check all children have same type
		// DONE nodeType = CHILDTYPE + "[]"
		if (ctx.exp().size() > 0) {
			visit(ctx.exp(0));
			String type = nodeType;
			System.out.println("Type: " + type);
			for (int i = 1; i < ctx.exp().size(); i++) {
				visit(ctx.exp(i));
				if (!nodeType.equals(type)) {
					System.err.println("Error: Array element types must be the same, at '" + ctx.exp(i).getText()
							+ "' Expected: " + type + ", Actual: " + nodeType);
					returnCode = 200;
				}
			}
			nodeType = type + "[]";
		}
		System.out.println("Final node tpye at array_lit; " + nodeType);
		return null;
	}

	@Override
	public Void visitPair_elem(Pair_elemContext ctx) {
		// DONE Visit child and obtain type
		// nodeType = CHILDTYPE
		String pairType = scopeHandler.get(ctx.exp().getText());
		pairType = pairType.replace("pair(", "").replace(")", "");
		int commaPos = pairType.indexOf(",");
		
		String fstType = pairType.substring(0, commaPos);
		String sndType = pairType.substring(commaPos + 1, pairType.length());

		if (ctx.getChild(0).getText().equals("fst")) {
			if (fstType.equals("pair")) {
				nodeType = scopeHandler.get(ctx.exp().getText(), "fst");
			} else {
				nodeType = fstType;
			}
		} else {
			if (sndType.equals("pair")) {
				nodeType = scopeHandler.get(ctx.exp().getText(), "snd");
			} else {
				nodeType = sndType;
			}
		}

		return null;
	}

	@Override
	public Void visitAssign_rhs(Assign_rhsContext ctx) {
		// DONE When calling functions, check arg types are equal to function signature types
		System.out.println("Visiting Assign_rhs");
		
		if (ctx.getChild(0).equals(ctx.CALL())) {
			String functionName = ctx.ident().getText();
			System.out.println("HELLO ITS ME: " + functionName);
			if (ctx.arg_list() != null) {
				Collection<String> paramTypes = functionHandler.getParamTypeList(functionName);
				if (paramTypes.size() - 1 == ctx.arg_list().exp().size()) {
					if (paramTypes.size() - 1 > 0) {
						Iterator<String> it = paramTypes.iterator();
						// First argument is function return type so skip
						it.next();
						for (int i = 0; i < ctx.arg_list().exp().size(); i++) {
							visit(ctx.arg_list().exp(i));
							String actualType = nodeType;
							String expectedType = it.next();
							if (!actualType.equals(expectedType)) {
								System.err.println("Error: Incompatible type in function call '" + ctx.arg_list().exp(i).getText() +
										"' (Expected: " + expectedType + ", Actual: " + actualType + ")");
								returnCode = 200;
								// Should make error message more detailed
							}
						}
					}
				} else {
					System.err.println("Error: Number of arguments does not match function definition at ' " + ctx.getText() +
							" ' (Expected number of args: " + (paramTypes.size() - 1) + ")");
					returnCode = 200;
				}
			}
			nodeType = functionHandler.getReturnType(functionName);
			return null;
		} else if (ctx.getChild(0).equals(ctx.NEWPAIR())) {
			nodeType = "pair";
			return null;
		}
		visitChildren(ctx);
		return null;
	}
	
	public int getReturnCode() {
		return returnCode;
	}

}