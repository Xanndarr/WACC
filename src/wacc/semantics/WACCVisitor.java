package wacc.semantics;

import java.util.Collection;
import java.util.Iterator;

import wacc.antlr.WACCParser.*;
import wacc.symbolTable.FunctionHandler;
import wacc.symbolTable.ScopeHandler;
import wacc.ErrorReporter;
import wacc.antlr.WACCParserBaseVisitor;

public class WACCVisitor extends WACCParserBaseVisitor<Void> {

	private ErrorReporter err = null;
	private ScopeHandler scopeHandler = new ScopeHandler();
	private FunctionHandler functionHandler = new FunctionHandler();

	private String nodeType = "null";
	private String function = "null";
	private boolean hasReturn = false;

	public WACCVisitor(ErrorReporter err) {
		this.err = err;
	}

	@Override
	public Void visitProgram(ProgramContext ctx) {
		for (FuncContext func : ctx.func()) {
			String functionIdent = func.ident().getText();
			String functionType = func.type().getText();

			if (!functionHandler.exists(functionIdent)) {
				functionHandler.add(functionIdent, functionType);
			} else {
				err.println("Function '" + functionIdent + "' already exists.", func.ident());
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
						err.println("Parameter with name '" + paramIdent
								+ "' alerady exists within this function definition.", param.ident());
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
				err.printlnSyntax("A function must always be able to return.", func);
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

				Pair_elemContext rhsPair = null;
				if (ctx.assign_rhs() instanceof PairElemRHSContext) {
					rhsPair = ((PairElemRHSContext) ctx.assign_rhs()).pair_elem();
				}
				if (rhsPair != null) {
					String pairIdent = rhsPair.exp().getText();
					String pairPointer;
					if (rhsPair.getChild(0).getText().equals("fst")) {
						pairPointer = scopeHandler.get(pairIdent, "fst");
					} else {
						pairPointer = scopeHandler.get(pairIdent, "snd");
					}
					rhs = pairPointer;
				}

				NewPairRHSContext newPairRHS = null;
				if (ctx.assign_rhs() instanceof NewPairRHSContext) {
					newPairRHS = (NewPairRHSContext) ctx.assign_rhs();
				}
				if (rhs.contains("newpair")) {
					if (fstType.equals("pair")) {
						fstRef = newPairRHS.exp(0).getText();
					}
					if (sndType.equals("pair")) {
						sndRef = newPairRHS.exp(1).getText();
					}
				}

				scopeHandler.add(ident, type, fstRef, sndRef);
			} else {
				scopeHandler.add(ident, type);
			}
		} else {
			err.println("The variable '" + ident + "' already exists.", ctx.ident());
		}

		visit(ctx.assign_rhs());
		// will give you types...then do "pair(" + type1 +","+ type2 + ")"
		if (!nodeType.equals("null") && !type.contains(nodeType)) {
			err.println("Incompatible type while initialising '" + ident + "' (Expected: " + type + ", Actual: "
					+ nodeType + ")", ctx.ident());
		}

		return null;
	}

	@Override
	public Void visitAssignment(AssignmentContext ctx) {
		// DONE Check LHS type = RHS type
		// DONE Check that idents exist

		// LHS
		Assign_lhsContext lhs = ctx.assign_lhs();
		String lhsType = "";

		// Array elem case
		Array_elemContext array_elem = lhs.array_elem();
		if (array_elem != null) {
			if (!scopeHandler.exists(array_elem.ident().getText())) {
				err.println("Variable " + array_elem.ident().getText() + " does not exist in the current scope",
						array_elem.ident());
			} else {
				lhsType = scopeHandler.get(array_elem.ident().getText()).replace("[]", "");
			}
		}

		// Pair elem case
		Pair_elemContext pair_elem = lhs.pair_elem();
		if (pair_elem != null) {
			if (!scopeHandler.exists(pair_elem.exp().getText())) {
				err.println("Variable " + pair_elem.exp().getText() + " does not exist in the current scope",
						pair_elem.exp());
			} else {
				visit(pair_elem);
				lhsType = nodeType;
			}
		}

		// Ident case
		IdentContext ident = lhs.ident();
		if (ident != null) {
			if (!scopeHandler.exists(ident.getText())) {
				err.println("Variable " + ident.getText() + " does not exist in the current scope", ident);
			} else {
				lhsType = scopeHandler.get(ident.getText());
			}
		}

		// RHS
		visit(ctx.assign_rhs());
		String rhsType = nodeType;
		if (rhsType.equals("null")) {
			rhsType = lhsType;
		}
		if (!(lhsType.equals("string") && rhsType.equals("char")) && !rhsType.equals(lhsType)) {
			err.println("Incompatible type at '" + ctx.assign_rhs().getText() + "' (Expected: " + lhsType + ", Actual: "
					+ rhsType + ")", ctx.assign_rhs());
		}
		return null;
	}

	@Override
	public Void visitRead(ReadContext ctx) {
		// DONE Check type is = program variable | pair elem | array elem
		// DONE Type must be either int, string(?) or char().getText());
		String lhsAssign = ctx.assign_lhs().getText();
		lhsAssign = lhsAssign.replace("fst", "").replace("snd", "");
		if (scopeHandler.exists(lhsAssign)) {
			String lhsType = scopeHandler.get(lhsAssign);
			if (lhsType.contains("pair") && ctx.assign_lhs().pair_elem() == null) {
				err.println("Pair element did not make use of the necessary 'fst' or 'snd' keywords.",
						ctx.assign_lhs());
			}
			boolean validReadType = lhsType.equals("int") || lhsType.equals("string") || lhsType.equals("char")
					|| lhsType.contains("pair");

			if (!(lhsType.contains("[]") || validReadType)) {
				err.println("Type given '" + lhsType + "' is not compatible with read.", ctx.assign_lhs());
			}
		} else {
			err.println("Variable input for read, '" + lhsAssign + "' does not exist in scope.", ctx.assign_lhs());
		}

		return super.visitRead(ctx);
	}

	@Override
	public Void visitFree(FreeContext ctx) {
		// DONE Type must be either array or pair
		// DONE Type must not be an array of an array or an array of a pair or a
		// pair of arrays etc.
		visit(ctx.exp());
		if (nodeType.contains("pair")) {
			if (!scopeHandler.get(ctx.exp().getText(), "fst").equals("null")
					&& !scopeHandler.get(ctx.exp().getText(), "snd").equals("null")) {
				err.println("Free cannot free nested pair types.", ctx.exp());
			}
		} else if (nodeType.contains("[]")) {
			if (nodeType.replace("[]", "").length() != nodeType.length() - "[]".length()) {
				err.println("Free cannot free nested array types.", ctx.exp());
			}
		} else {
			err.println("Free can only free array and pair types.", ctx.exp());
		}
		return super.visitFree(ctx);
	}

	@Override
	public Void visitExit(ExitContext ctx) {
		// DONE Expression must evaluate to an int
		visit(ctx.exp());
		if (!nodeType.equals("int")) {
			err.println("The expression of exit statments must evaluate to an int type.", ctx.exp());
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
			err.println("If statement expressions must evaluate to bool type.", ctx.exp());
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
		visit(ctx.exp());
		if (!nodeType.equals("bool")) {
			err.println("While condition expressions must evaluate to bool type.", ctx.exp());
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
		scopeHandler.descend();
		visit(ctx.stat());
		scopeHandler.ascend();
		return null;
	}

	@Override
	public Void visitReturn(ReturnContext ctx) {
		// DONE Expression must be same type as function return type
		hasReturn = true;
		if (function.equals("null")) {
			err.println("Cannot 'return' from the main program body.", ctx);
			return null;
		}
		visit(ctx.exp());
		String returnType = nodeType;
		String functionType = functionHandler.getReturnType(function);
		if (!returnType.equals(functionType)) {
			err.println("Incompatible type at '" + ctx.getText() + "' (Expected: " + functionType + ", Actual: "
					+ returnType + ")", ctx);
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
			err.println("Arrays must be accessed using an int index.", ctx.exp(0));
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
			nodeType = scopeHandler.get(ident);
		} else if (functionHandler.exists(ident)) {
			nodeType = functionHandler.getReturnType(ident);
		} else {
			err.println("Identifier '" + ctx.getText() + "' does not exist.", ctx);
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
				err.println("The '!' operator only works for boolean types.", ctx.unary_op());
			}
			nodeType = "bool";
			break;
		case "-":
			if (!nodeType.equals("int")) {
				err.println("The '-' operator only works for integer types.", ctx.unary_op());
			}
			nodeType = "int";
			break;
		case "len":
			if (!nodeType.contains("[]")) {
				err.println("The 'len' operator only works for array types.", ctx.unary_op());
			}
			nodeType = "int";
			break;
		case "ord":
			if (!nodeType.equals("char")) {
				err.println("The 'ord' operator only works for char types.", ctx.unary_op());
			}
			nodeType = "int";
			break;
		case "chr":
			if (!nodeType.equals("int")) {
				err.println("The 'chr' operator only works for int types.", ctx.unary_op());
			}
			nodeType = "char";
			break;
		default:
			nodeType = null;
			break;
		}
		return null;
	}

	private String checkBinaryOpTypes(ExpContext lhs, ExpContext rhs) {
		visit(lhs);
		String lhsType = nodeType;
		visit(rhs);
		String rhsType = nodeType;

		if (!(lhsType.contains("pair") && rhsType.equals("null")
				|| rhsType.contains("pair") && lhsType.equals("null"))) {
			if (!lhsType.equals(rhsType)) {
				err.println("Both sides of a binary operator must have the same type.", lhs);
			}
		}

		return lhsType;
	}

	// Binary ops are in order of precedence
	@Override
	public Void visitDmArithmeticOpExp(DmArithmeticOpExpContext ctx) {
		String type = checkBinaryOpTypes(ctx.exp(0), ctx.exp(1));
		if (!type.equals("int")) {
			err.println("Operator '" + ctx.dm_arithmetic_op().getText() + "' expecting type int",
					ctx.dm_arithmetic_op());
		}
		nodeType = "int";
		return null;
	}

	@Override
	public Void visitAsArithmeticOpExp(AsArithmeticOpExpContext ctx) {
		String type = checkBinaryOpTypes(ctx.exp(0), ctx.exp(1));
		if (!type.equals("int")) {
			err.println("Operator '" + ctx.as_arithmetic_op().getText() + "' expecting type int",
					ctx.as_arithmetic_op());
		}
		nodeType = "int";
		return null;
	}

	@Override
	public Void visitOrderingOpExp(OrderingOpExpContext ctx) {
		String type = checkBinaryOpTypes(ctx.exp(0), ctx.exp(1));
		if (!type.equals("int") && !type.equals("char")) {
			err.println("Operator '" + ctx.ordering_op().getText() + "' expecting type char or int", ctx.ordering_op());
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
			err.println("Operator '" + ctx.and_op().getText() + "' expecting type bool", ctx.and_op());
		}
		nodeType = "bool";
		return null;
	}

	@Override
	public Void visitOrOpExp(OrOpExpContext ctx) {
		String type = checkBinaryOpTypes(ctx.exp(0), ctx.exp(1));
		if (!type.equals("bool")) {
			err.println("Operator '" + ctx.or_op().getText() + "' expecting type bool", ctx.or_op());
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

		visit(ctx.stat());
		scopeHandler.ascend();

		return null;
	}

	@Override
	public Void visitArray_lit(Array_litContext ctx) {
		// DONE Check all children have same type
		// DONE nodeType = CHILDTYPE + "[]"
		if (ctx.exp().size() > 0) {
			visit(ctx.exp(0));
			String type = nodeType;
			for (int i = 1; i < ctx.exp().size(); i++) {
				visit(ctx.exp(i));
				if (!nodeType.equals(type)) {
					err.println("Array element types must be the same, at '" + ctx.exp(i).getText() + "' Expected: "
							+ type + ", Actual: " + nodeType, ctx.exp(i));
				}
			}
			nodeType = type + "[]";
		}
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
	public Void visitNewPairRHS(NewPairRHSContext ctx) {
		if (ctx.getChild(0).equals(ctx.NEWPAIR())) {
			nodeType = "pair";
		}
		return null;
	}

	@Override
	public Void visitFunCallRHS(FunCallRHSContext ctx) {
		// DONE When calling functions, check arg types are equal to function
		// signature types
		if (ctx.getChild(0).equals(ctx.CALL())) {
			String functionName = ctx.ident().getText();
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
								err.println(
										"Incompatible type in function call '" + ctx.arg_list().exp(i).getText()
												+ "' (Expected: " + expectedType + ", Actual: " + actualType + ")",
										ctx.arg_list().exp(i));
							}
						}
					}
				} else {
					err.println("Number of arguments does not match function definition at '" + ctx.getText()
							+ "' (Expected number of args: " + (paramTypes.size() - 1) + ")", ctx);
				}
			}
			nodeType = functionHandler.getReturnType(functionName);
		}
		return null;
	}

}