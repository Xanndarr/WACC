package wacc.util;

public class PrintCode {
	
	public static String addPrintData(Type t) {
		switch (t) {
		case STRING:
			return addData("%.*s\\0");
		case INT:
			return addData("%d\\0");
		case BOOL:
			String tempRet = addData("true\\0");
			addData("false\\0");
			return tempRet;
		case NULL:
			return addData("\\0");
		default:
			return null;
		}
	}
	
	public static void addPrint(Type t, String dataLabel) {
		if (t == Type.NULL) {
			addPost("p_print_ln:");
			postIndent = true;
			addPost("PUSH {lr}");
			addPrintln(dataLabel);
			addPost("BL puts");
		} else {
			addPost("p_print_" + t + ":");
			postIndent = true;
			addPost("PUSH {lr}");
			switch (t) {
			case STRING:
				addPrintString(dataLabel);
				break;
			case INT:
				addPrintInt(dataLabel);
				break;
			case BOOL:
				String[] parts = dataLabel.split("_");
				addPrintBool(dataLabel, parts[0] + "_" + (Integer.parseInt(parts[1]) + 1));
				break;			
			default:
				break;
			}
			addPost("BL printf");
		}
		addPost("MOV r0, #0");
		addPost("BL fflush");
		addPost("POP {pc}");
		postIndent = false;
	}
	
	private static void addPrintString(String dataLabel) {
		addPost("LDR r1, [r0]");
		addPost("ADD r2, r0, #4");
		addPost("LDR r0, " + Arm.mem(dataLabel));
		addPost("ADD r0, r0, #4");
	}
	
	private static void addPrintBool(String trueLabel, String falseLabel) {
		addPost("CMP r0, #0");
		addPost("LDRNE r0, " + Arm.mem(trueLabel));
		addPost("LDREQ r0, " + Arm.mem(falseLabel));
		addPost("ADD r0, r0, #4");
	}
	
	private static void addPrintInt(String dataLabel) {
		addPost("MOV r1, r0");
		addPost("LDR r0, " + Arm.mem(dataLabel));
		addPost("ADD r0, r0, #4");		
	}
	
	private static void addPrintln(String dataLabel) {
		addPost("LDR r0, " + Arm.mem(dataLabel));
		addPost("ADD r0, r0, #4");
	}

}
