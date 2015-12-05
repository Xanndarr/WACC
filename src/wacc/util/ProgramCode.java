package wacc.util;

import java.util.LinkedList;
import java.util.List;

public class ProgramCode {
	
	private static ProgramCode instance;
	private static List<String> data;
	private static List<String> main;
	private static List<String> post;
	private static boolean indent = false;
	private static boolean postIndent = false;
	private static boolean hasData = false;
	
	private ProgramCode() {
		data = new LinkedList<String>();
		main = new LinkedList<String>();
		post = new LinkedList<String>();
	}
	
	public static void add(String instruction) {
		if (instance == null) {
			instance = new ProgramCode();
		}
		if (indent) {
			main.add("\t" + instruction);
		} else {
			main.add(instruction);
		}
	}
	
	public static String addData(String s, int size) {
		hasData = true;
		int datPos = data.size();
		data.add("msg_" + datPos + ":");
		data.add("\t.word " + size);
		data.add("\t.ascii \"" + s + "\"");
		return "msg_" + datPos;
	}
	
	private static void addPost(String instruction) {
		if (postIndent) {
			post.add("\t" + instruction);
		} else {
			post.add(instruction);
		}
	}
	
	public static void addPrint(Type t, String dataLabel) {
		if (t == null) {
			addPost("p_print_ln:");
			postIndent = true;
			addPrintln(dataLabel);
			addPost("BL puts");
		} else {
			addPost("p_print_" + t + ":");
			postIndent = true;
			addPost("PUSH {lr}");
			switch (t) {
			case CHAR:
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

	public static void setIndent(boolean newIndent) {
		indent = newIndent;
	}
	
	public static String getCode() {
		if (main == null) {
			return "null";
		}
		StringBuilder out = new StringBuilder();
		if (hasData) {
			out.append(".data\n\n");
			for (String line : data) {
				out.append(line + "\n");
			}
		}
		for (String instr : main) {
			out.append(instr + "\n");
		}
		return out.toString();
	}

}
