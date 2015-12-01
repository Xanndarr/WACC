package wacc.semantics;

import java.util.Collection;
import java.util.Iterator;

import wacc.ErrorReporter;
import wacc.antlr.WACCParser.*;

class MiscVisitor extends Visitor {

	public MiscVisitor(ErrorReporter err) {
		super(err);
	}
	
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
	public Void visitAssign_rhs(Assign_rhsContext ctx) {
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
			return null;
		} else if (ctx.getChild(0).equals(ctx.NEWPAIR())) {
			nodeType = "pair";
			return null;
		}
		visitChildren(ctx);
		return null;
	}

}
