package wacc.util;

import java.util.LinkedList;
import java.util.List;

public class ProgramCode {
	
	private static ProgramCode instance;
	private static List<String> instructions;
	private static boolean indent = false;
	
	private ProgramCode() {
		instructions = new LinkedList<String>();
	}
	
	public static void add(String instruction) {
		if (instance == null) {
			instance = new ProgramCode();
		}
		if (indent) {
			instructions.add("\t" + instruction);
		} else {
			instructions.add(instruction);
		}
	}

	public static void setIndent(boolean newIndent) {
		indent = newIndent;
	}
	
	public static String getCode() {
		if (instructions == null) {
			return "null";
		}
		StringBuilder out = new StringBuilder();
		for (String instr : instructions) {
			out.append(instr + "\n");
		}
		return out.toString();
	}

}
