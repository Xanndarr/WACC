package wacc.util;

import java.util.LinkedList;
import java.util.List;

public class ProgramCode {
	
	private static ProgramCode instance;
	private static List<String> data;
	private static List<String> instructions;
	private static boolean indent = false;
	private static boolean hasData = false;
	
	private ProgramCode() {
		data = new LinkedList<String>();
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
	
	public static String addData(String s, int size) {
		hasData = true;
		int datPos = data.size();
		data.add("msg_" + datPos + ":");
		data.add("\t.word " + size);
		data.add("\t.ascii \"" + s + "\"");
		return "msg_" + datPos;
	}

	public static void setIndent(boolean newIndent) {
		indent = newIndent;
	}
	
	public static String getCode() {
		if (instructions == null) {
			return "null";
		}
		StringBuilder out = new StringBuilder();
		if (hasData) {
			out.append(".data\n\n");
			for (String line : data) {
				out.append(line + "\n");
			}
		}
		for (String instr : instructions) {
			out.append(instr + "\n");
		}
		return out.toString();
	}

}
