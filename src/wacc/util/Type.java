package wacc.util;

public enum Type {
	
	BOOL("bool", 1), CHAR("char", 1), STRING("string", 4), INT("int", 4), ARRAY("[]", 4), PAIR("pair", 4), NULL("null", 4), LN("ln", 0);

	private String sType;
	private int size;

	private Type(String sType, int size) {
		this.sType = sType;
		this.size = size;
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
	
	public int getSize() {
		return size;
	}
	
	public static int getBaseSize(String type) {
		if (type.contains("[]")) {
			return parse(type.replaceAll("[]", "")).getSize();
		}
		return parse(type).getSize();
	}
	
	@Override
	public String toString() {
		return sType;
	}

}
