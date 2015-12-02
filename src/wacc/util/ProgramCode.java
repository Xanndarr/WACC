package wacc.util;

import java.util.LinkedList;
import java.util.List;

public class ProgramCode {
	
	private static ProgramCode instance;
	private static List<String> instructions;
	
	private ProgramCode() {
		instructions = new LinkedList<String>();
	}
	
	public static void add(String instruction) {
		if (instance == null) {
			instance = new ProgramCode();
		}
		instructions.add(instruction);
	}
	
	public static String getCode() {
		StringBuilder out = new StringBuilder();
		for (String instr : instructions) {
			out.append(instr + "/n");
		}
		return out.toString();
	}

}
