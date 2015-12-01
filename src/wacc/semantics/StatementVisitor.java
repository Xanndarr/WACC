package wacc.semantics;

import wacc.ErrorReporter;
import wacc.antlr.WACCParser.*;

class StatementVisitor extends Visitor {

	public StatementVisitor(ErrorReporter err) {
		super(err);
	}
	
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

				Pair_elemContext rhsPair = ctx.assign_rhs().pair_elem();
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

				if (rhs.contains("newpair")) {
					if (fstType.equals("pair")) {
						fstRef = ctx.assign_rhs().exp(0).getText();
					}
					if (sndType.equals("pair")) {
						sndRef = ctx.assign_rhs().exp(1).getText();
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

}
