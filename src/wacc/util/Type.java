package wacc.util;

public enum Type {
	
	BOOL("bool"), CHAR("char"), STRING("string"), INT("int"), ARRAY("[]"), PAIR("pair"), NULL("NULL");

	private String sType;

	private Type(String sType) {
		this.sType = sType;
	}

	public static Type parse(String s) {
		for (Type t : Type.values()) {
			if (t.sType.equals(s)) {
				return t;
			}
		}
		if (s.contains(ARRAY.sType)) {
			return ARRAY;
		}
		if (s.contains(PAIR.sType)) {
			return PAIR;
		}
		return NULL;
	}

}
