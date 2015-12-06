package wacc.util;

public enum UnaryOp {
	
	ORD("ord"), CHR("chr"), NOT("!"), LEN("len"), SUB("-"), INVALID_OP("");

	private String op;

	UnaryOp(String op) {
		this.op = op;
	}
	
	public static UnaryOp parse(String op) {
		for (UnaryOp oper : UnaryOp.values()) {
			if (oper.op.equals(op)) {
				return oper;
			}
		}
		return INVALID_OP;
	}

}
