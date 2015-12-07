package wacc.util;


public class ReadCode {
	
	public static String addReadData(Type t) {
		switch (t) {
		case CHAR:
			return ProgramCode.addData(" %c\\0");
		case INT:
			return ProgramCode.addData("%d\\0");
//		case NULL:// not sure if necessary
//			return ProgramCode.addData("\\0");
		default:
			return null;
		}
	}
	
	public static void addRead(Type t, String dataLabel) {
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

}
