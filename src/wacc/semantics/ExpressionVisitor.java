package wacc.semantics;

import wacc.ErrorReporter;
import wacc.antlr.WACCParser.*;

class ExpressionVisitor extends WACCVisitor {

	public ExpressionVisitor(ErrorReporter err) {
		super(err);
	}
	
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

}
