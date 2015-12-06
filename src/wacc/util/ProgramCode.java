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
		if (s.contains("\\")) {
			data.add("\t.word " + (s.length() - "\\".length()));
		} else {
			data.add("\t.word " + s.length());
		}
		data.add("\t.ascii \"" + s + "\"");
		return "msg_" + dataItems++;
	}
	
	private static void addPost(String instruction) {
		if (postIndent) {
			post.add("\t" + instruction);
		} else {
			post.add(instruction);
		}
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
			out.append("\n");
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
