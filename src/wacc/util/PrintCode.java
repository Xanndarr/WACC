package wacc.util;

import java.util.HashMap;
import java.util.Map;

public class PrintCode {

	private static final Map<Type, String> printedTypeLabels = new HashMap<Type, String>();
	
	private static String addPrintData(Type t) {
		switch (t) {
		case STRING:
			return ProgramCode.addData("%.*s\\0");
		case INT:
			return ProgramCode.addData("%d\\0");
		case BOOL:
			String tempRet = ProgramCode.addData("true\\0");
			ProgramCode.addData("false\\0");
			return tempRet;
		case NULL:
			return ProgramCode.addData("\\0");
		default:
			return null;
		}
	}
	
	private static void addPrintFunc(Type t, String dataLabel) {
		if (t == Type.NULL) {
			ProgramCode.addPost("p_print_ln:");
			ProgramCode.setPostIndent(true);
			ProgramCode.addPost("PUSH {lr}");
			addPrintln(dataLabel);
			ProgramCode.addPost("BL puts");
		} else {
			ProgramCode.addPost("p_print_" + t + ":");
			ProgramCode.setPostIndent(true);
			ProgramCode.addPost("PUSH {lr}");
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
			ProgramCode.addPost("BL printf");
		}
		ProgramCode.addPost("MOV r0, #0");
		ProgramCode.addPost("BL fflush");
		ProgramCode.addPost("POP {pc}");
		ProgramCode.setPostIndent(false);
	}
	
	private static void addPrintString(String dataLabel) {
		ProgramCode.addPost("LDR r1, [r0]");
		ProgramCode.addPost("ADD r2, r0, #4");
		ProgramCode.addPost("LDR r0, " + Arm.mem(dataLabel));
		ProgramCode.addPost("ADD r0, r0, #4");
	}
	
	private static void addPrintBool(String trueLabel, String falseLabel) {
		ProgramCode.addPost("CMP r0, #0");
		ProgramCode.addPost("LDRNE r0, " + Arm.mem(trueLabel));
		ProgramCode.addPost("LDREQ r0, " + Arm.mem(falseLabel));
		ProgramCode.addPost("ADD r0, r0, #4");
	}
	
	private static void addPrintInt(String dataLabel) {
		ProgramCode.addPost("MOV r1, r0");
		ProgramCode.addPost("LDR r0, " + Arm.mem(dataLabel));
		ProgramCode.addPost("ADD r0, r0, #4");
	}
	
	private static void addPrintln(String dataLabel) {
		ProgramCode.addPost("LDR r0, " + Arm.mem(dataLabel));
		ProgramCode.addPost("ADD r0, r0, #4");
	}
    
    public static void addPrint(Type t) {
    	if (!printedTypeLabels.containsKey(t)) {
    		String label = addPrintData(t);
            addPrintFunc(t, label);
            printedTypeLabels.put(t, label);
        }
    }

}
