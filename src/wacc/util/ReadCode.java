package wacc.util;


import java.util.HashMap;
import java.util.Map;

public class ReadCode {
	private static final Map<Type, String> printedReadLabels = new HashMap<Type, String>();
	
	private static String addReadData(Type t) {
		switch (t) {
		case CHAR:
			return ProgramCode.addData(" %%c\\0");
		case INT:
			return ProgramCode.addData("%%d\\0");
		default:
			return null;
		}
	}
	
	private static void addReadFunc(Type t, String dataLabel) {
		ProgramCode.addPost("p_read_" + t + ":");
		ProgramCode.setPostIndent(true);
		ProgramCode.addPost("PUSH {lr}");
		ProgramCode.addPost("MOV r1, r0");
		ProgramCode.addPost("LDR r0, " + Arm.mem(dataLabel));
		ProgramCode.addPost("ADD r0, r0, #4");
		ProgramCode.addPost("BL scanf");
		ProgramCode.addPost("POP {pc}");
		ProgramCode.setPostIndent(false);
	}
	
	public static void addRead(Type t) {
		if (!printedReadLabels.containsKey(t)) {
            String label = addReadData(t);
			addReadFunc(t, label);
            printedReadLabels.put(t, label);
		}
	}

}
