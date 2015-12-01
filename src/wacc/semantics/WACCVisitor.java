package wacc.semantics;

import wacc.antlr.WACCParser.*;
import wacc.symbolTable.FunctionHandler;
import wacc.symbolTable.ScopeHandler;
import wacc.ErrorReporter;
import wacc.antlr.WACCParserBaseVisitor;

public class Visitor extends WACCParserBaseVisitor<Void> {

	protected ErrorReporter err = null;
	protected ScopeHandler scopeHandler = new ScopeHandler();
	protected FunctionHandler functionHandler = new FunctionHandler();

	protected String nodeType = "null";
	protected String function = "null";
	protected boolean hasReturn = false;

	public Visitor(ErrorReporter err) {
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

}