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
		if (!scopeHandler.exists(ident)) {
			scopeHandler.add(ident, type);
		} else {
			System.err.println("Error: The variable '" + ident + "' already exists.");
		}

		visit(ctx.assign_rhs());
		// if (!nodeType.equals(type)) { // hacked below
		// String rhsType = ctx.assign_rhs().exp(); <-- viting these and they
		// will give you types...then do "pair(" + type1 +","+ type2 + ")"
		if (!type.contains(nodeType)) {
			// TODO Set exit status to 200 ? Not sure how to do this.
			System.err.println("Error: Incompatible type at ' " + ctx.assign_rhs().getText() + " ' (Expected: " + type
					+ ", Actual: " + nodeType + ")");
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
			// boolean exists = scopeHandler.exists(ident.getText());
			if (!scopeHandler.exists(ident.getText())) {
				System.err.println("Error: Variable " + ident.getText() + " does not exist in the current scope");
			} else {
				// visit(ident);
				System.out.println("Context: " + lhs.getText());
				lhsType = nodeType;
				System.out.println("Type: " + lhsType);
			}
		}

		Array_elemContext array_elem = lhs.array_elem();
		if (array_elem != null) {
			// System.out.println("Context: " + lhs.getText());
			boolean exists = scopeHandler.exists(array_elem.ident().getText());
			if (!exists) {
				System.err.println(
						"Error: Variable " + array_elem.ident().getText() + " does not exist in the current scope");
			} else {
				visit(array_elem);
				lhsType = nodeType;
			}
		}

		Pair_elemContext pair_elem = lhs.pair_elem();
		if (pair_elem != null) {
			boolean exists = scopeHandler.exists(pair_elem.exp().getText());
			if (!exists) {
				System.err.println(
						"Error: Variable " + pair_elem.exp().getText() + " does not exist in the current scope");
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
				System.err.println("Error: Incompatible type at ' " + ctx.assign_rhs().getText() + " ' (Expected: "
						+ lhsType + ", Actual: " + rhsType + ")");
			}
		}
		return super.visitAssignment(ctx);
	}

	@Override
	public Void visitRead(ReadContext ctx) {
		// DONE Check type is = program variable | pair elem | array elem
		// DONE Type must be either int, string(?) or char().getText());
		System.out.println("READING : " + ctx.assign_lhs().getText());
		String lhsAssign = ctx.assign_lhs().getText();
		if (scopeHandler.exists(lhsAssign)) {
			String lhsType = scopeHandler.get(lhsAssign);
			if (lhsType.contains("pair") && ctx.assign_lhs().pair_elem() == null) {
				System.err.println("Error: Pair element did not make use of the necessary 'fst' or 'snd' keywords");
			}
			boolean validReadType = lhsType.equals("int") 
					|| lhsType.equals("string") 
					|| lhsType.equals("char")
					|| lhsType.contains("pair");

			if (!(lhsType.contains("[]") || validReadType)) {
				System.err.println("Error: Type given to read ' " + lhsType + " ' is not a compatible type with read");
			}
		} else {
			System.err.println("Error: Variable input for read, ' " + lhsAssign + " ' does not exist in scope");
		}

		return super.visitRead(ctx);
	}

	@Override
	public Void visitFree(FreeContext ctx) {
		// DONE Type must be either array or pair
		// DONE Type must not be an array of an array or an array of a pair or a
		// pair of arrays etc.
		System.out.println("FREEING : " + ctx.exp().getText());
		if (nodeType.contains("pair")) {
			if (nodeType.replace("pair", "").length() != nodeType.length() - "pair".length()) {
				System.out.println("Error: Free can't free nested pairs.");
			}
		} else if (nodeType.contains("[]")) {
			if (nodeType.replace("[]", "").length() != nodeType.length() - "[]".length()) {
				System.out.println("Error: Free can't free nested arrays.");
			}
		} else {
			System.out.println("Error: Free can only free arrays and pairs.");
		}
		return super.visitFree(ctx);
	}

	@Override
	public Void visitExit(ExitContext ctx) {
		// DONE Expression must evaluate to an int
		visit(ctx.exp());
		if (!nodeType.equals("int")) {
			System.err.println("Error: Exit statements expressions must evaluate to an int.");
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
		// System.out.println("visiting while");
		// System.out.println(ctx.exp().getText());
		visit(ctx.exp());
		if (!nodeType.equals("bool")) {
			// System.out.println(nodeType);
			System.err.println("Error: While condition expressions must evaluate to bool type.");
		}
		scopeHandler.descend();
		visit(ctx.stat());
		scopeHandler.ascend();
		return super.visitWhile(ctx);
	}

//	@Override
//	public Void visitReturn(ReturnContext ctx) {
//		// TODO Expression must be same type as function return type
//		System.out.println("Visiting return");
//		visit(ctx.exp());
//		String returnType = nodeType;
//		String functionType = functionHandler.getReturnType(ctx.exp().getText());
//		if (!returnType.equals(functionType)) {
//			System.err.println("Error: Incompatible type at '" + ctx.getText() + "' (Expected: " + functionType
//					+ ", Actual: " + returnType + ")");
//		}
//		return super.visitReturn(ctx);
//	}

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

	// This method is visited when a lookup into an array is being done
	@Override
	public Void visitArray_elem(Array_elemContext ctx) {
		// DONE check exp evaluates to a (positive) int
		visit(ctx.exp(0));
		if (!nodeType.equals("int")) {
			System.err.println("Error: Arrays must be accessed using an int index.");
		}
		return super.visitArray_elem(ctx);
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
			System.err.println("Error: Identifier '" + ctx.getText() + "' does not exist.");
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
			if (!nodeType.equals("bool"))
				System.err.println("Error: The '!' operator only works for boolean types.");
			nodeType = "bool";
			break;
		case "-":
			if (!nodeType.equals("int"))
				System.err.println("Error: The '-' operator only works for integer types.");
			nodeType = "int";
			break;
		case "len":
			// TODO check node type is of array
			if (!nodeType.equals("ARRAYS?!?!"))
				System.err.println("Error: The 'len' operator only works for array types.");
			nodeType = "int";
			break;
		case "ord":
			if (!nodeType.equals("char"))
				System.err.println("Error: The 'ord' operator only works for char types.");
			nodeType = "int";
			break;
		case "chr":
			if (!nodeType.equals("int"))
				System.err.println("Error: The 'chr' operator only works for int types.");
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
		ExpContext lhs = ctx.exp(0);
		ExpContext rhs = ctx.exp(1);
		if (!scopeHandler.exists(lhs.getText()) || !scopeHandler.exists(rhs.getText())) {
			System.err.println("Error: Undeclared variable: '" + lhs.getText() + "'." + rhs.getText());
		}
		visit(lhs);
		String lhsType = nodeType;
		visit(rhs);
		String rhsType = nodeType;

		if (!lhsType.equals(rhsType)) {
			System.err.println("Error: Both sides of a binary operator must have the same type.");
		}

		switch (ctx.binary_op().getText()) {
		case "*":
		case "/":
		case "%":
		case "+":
		case "-":
			if (!lhs.equals("int"))
				System.err.println("Error: *, /, %, +, - require ints.");
			nodeType = "int";
			break;
		case ">":
		case ">=":
		case "<":
		case "<=":
			if (!lhs.equals("int") && !lhs.equals("char"))
				System.err.println("Error: >, >=, <, <= require ints or chars.");
			nodeType = "bool";
			break;
		case "==":
		case "!=":
			nodeType = "bool";
			break;
		case "&&":
		case "||":
			if (!lhs.equals("bool"))
				System.err.println("Error: &&, || require bools.");
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
		// DONE Increase symtab scope, visit children, then decrease symtab
		// scope
		// DONE Possibly add parameters to a global function signature tracker
		// TODO Check every path of execution contains a return statement
		System.out.println("VISITING FUNCTION");
		String functionIdent = ctx.ident().getText();
		String functionType = ctx.type().getText();

		if (!functionHandler.exists(functionIdent)) {
			functionHandler.add(functionIdent, functionType);
		} else {
			System.err.println("Error: Function '" + functionIdent + "' already exists.");
		}

		scopeHandler.descend();

		if (ctx.param_list() != null) {
			for (ParamContext param : ctx.param_list().param()) {
				String paramIdent = param.ident().getText();
				String paramType = param.type().getText();

				if (!functionHandler.existsParam(functionIdent, paramIdent)) {
					functionHandler.addParam(functionIdent, paramIdent, paramType);
				} else {
					System.err.println("Error: Parameter with name '" + paramIdent
							+ "' alerady exists within this function definition. ");
				}
				scopeHandler.add(paramIdent, paramType);
			}
		}
		
//		for (ParseTree s : ctx.stat().children) {
//			System.out.println(s.getText());
//			System.out.println("==");
//		}

		visit(ctx.stat());
		scopeHandler.ascend();
		System.out.println("VISITING FUNCTION DONE");

		return super.visitFunc(ctx);
	}

	@Override
	public Void visitArray_lit(Array_litContext ctx) {
		// TODO Check all children have same type
		// TODO nodeType = CHILDTYPE + "[]"
		if (ctx.exp().size() > 0) {
			visit(ctx.exp(0));
			String type = nodeType;
			System.out.println("Type: " + type);
			for (int i = 1; i < ctx.exp().size(); i++) {
				visit(ctx.exp(i));
				if (!nodeType.equals(type)) {
					System.err.println("Error: Array element types must be the same, at '" + ctx.exp(i).getText()
							+ "' Expected: " + type + ", Actual: " + nodeType);
				}
			}
			nodeType = type + "[]";
		}
		System.out.println("Final node tpye at array_lit; " + nodeType);
		return super.visitArray_lit(ctx);
	}

	@Override
	public Void visitPair_elem(Pair_elemContext ctx) {
		// DONE Visit child and obtain type
		// nodeType = CHILDTYPE
		String pairType = scopeHandler.get(ctx.exp().getText());
		pairType = pairType.replace("pair(", "").replace(")", "");
		int commaPos = pairType.indexOf(",");

		if (ctx.getChild(0).getText().equals("fst")) {
			nodeType = pairType.substring(0, commaPos);
		} else {
			nodeType = pairType.substring(commaPos + 1, pairType.length());
		}

		return super.visitPair_elem(ctx);
	}

	@Override
	public Void visitAssign_rhs(Assign_rhsContext ctx) {
		// TODO When calling functions, check arg types are equal to function signature types
		
		if (ctx.CALL() != null) {
			String functionName = ctx.ident().getText();
			if (ctx.arg_list() != null) {
				Collection<String> paramTypes = functionHandler.getParamList(functionName);
				Iterator<String> it = paramTypes.iterator();
				// First argument is function return type so skip
				it.next();
				for (int i = 0; i < ctx.arg_list().exp().size(); i++) {
					visit(ctx.arg_list().exp(i));
					String actualType = nodeType;
					String expectedType = it.next();
					if (!actualType.equals(expectedType)) {
						System.err.println("Error: Incompatible type at ' " + ctx.arg_list().exp(i).getText() +
								" ' (Expected: " + expectedType + ", Actual: " + actualType + ")");
					}
				}
			}
		}
		return super.visitAssign_rhs(ctx);
	}

}