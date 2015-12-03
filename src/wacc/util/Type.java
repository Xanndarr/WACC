package wacc.util;

public enum Type {
	
	BOOL("bool"), CHAR("char"), STRING("string"), INT("int"), ARRAY(""), PAIR(""), NULL("");

	private String type;

	private Type(String op) {
		this.type = type;
	}

	public static Type parse(String type2) {
		for (Type t : Type.values()) {
			if (t.type.equals(type2)) {
				return t;
			}
		}
		return NULL;
	}

}
