package wacc.util;

import java.util.LinkedList;
import java.util.List;

public class ProgramCode {
	
	private static ProgramCode instance;
	private static int dataItems = 0;
	private static List<String> data;
	private static List<String> main;
	private static List<String> post;
	private static boolean indent = false;
	private static boolean postIndent = false;
	
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
	
	public static String addData(String s) {
		data.add("msg_" + dataItems + ":");
		data.add("\t.word " + (s.length() - "\\".length()));
		data.add("\t.ascii \"" + s + "\"");
		return "msg_" + dataItems++;
	}
	
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
	
	private static void addPost(String instruction) {
		if (postIndent) {
			post.add("\t" + instruction);
		} else {
			post.add(instruction);
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

	public static void setIndent(boolean newIndent) {
		indent = newIndent;
	}
	
	public static String getCode() {
		if (main == null) {
			return "null";
		}
		StringBuilder out = new StringBuilder();
		if (dataItems > 0) {
			out.append(".data\n\n");
			for (String line : data) {
				out.append(line + "\n");
			}
			out.append("\n\n");
		}
		for (String instr : main) {
			out.append(instr + "\n");
		}
		for (String p : post) {
			out.append(p + "\n");
		}
		return out.toString();
	}

}
