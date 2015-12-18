package wacc.util;

public enum BinaryOp {

	MULT("*"), DIV("/"), MOD("%"), ADD("+"), SUB("-"), GT(">"), GTE(">="), LT("<"), LTE("<="), EQ("=="), NEQ("!="), AND(
			"&&"), OR("||"), INVALID_OP("");

	private String op;

	private BinaryOp(String op) {
		this.op = op;
	}

	public static BinaryOp parse(String op) {
		for (BinaryOp bop : BinaryOp.values()) {
			if (bop.op.equals(op)) {
				return bop;
			}
		}
		return INVALID_OP;
	}

	public static BinaryOp swap(String op) {
		switch (op) {
		case "++":
			return ADD;
		case "--":
			return SUB;
		case "+=":
			return ADD;
		case "-=":
			return SUB;
		case "*=":
			return MULT;
		case "/=":
			return DIV;
		case "%=":
			return MOD;
		default:
			return INVALID_OP;
		}
	}

}
