package wacc.util;

public enum BinaryOp {
	
	MULT("*"), DIV("/"), MOD("%"),
	ADD("+"), SUB("-"),
	GT(">"), GTE(">="), LT("<"), LTE("<="),
	EQ("=="), NEQ("!="),
	AND("&&"), OR("||"),
	INVALID_OP("");
	
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

}
