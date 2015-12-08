package wacc.util;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class ProgramCode {
	
	private static ProgramCode instance;
	private static int dataItems = 0;
	
	private static List<String> data;
	private static List<String> main;
	private static List<String> post;
	
	private static List<String> dataBak;
	private static List<String> mainBak;
	private static List<String> postBak;
	
	private static boolean indent = false;
	private static boolean postIndent = false;
	private static int label = 0;
	
	private ProgramCode() {
		data = new LinkedList<String>();
		main = new LinkedList<String>();
		post = new LinkedList<String>();
	}
	
	public static void add(String instruction) {
		if (indent) {
			main.add("\t" + instruction);
		} else {
			main.add(instruction);
		}
	}
	
	public static String addData(String s) {
		data.add("msg_" + dataItems + ":");
		if (s.contains("\\0")) {
            if (s.contains("\\n")) {
                data.add("\t.word " + (s.length() - "\\".length() * 2));
            } else {
                data.add("\t.word " + (s.length() - "\\".length()));
            }
        } else {
			data.add("\t.word " + s.length());
		}
		data.add("\t.ascii \"" + s + "\"");
		return "msg_" + dataItems++;
	}
	
	public static void addPost(String instruction) {
		if (postIndent) {
			post.add("\t" + instruction);
		} else {
			post.add(instruction);
		}
	}

	public static void setIndent(boolean newIndent) {
		indent = newIndent;
	}
	
	public static String generateUniqueLabel() {
		return "L" + label++;
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

	public static void setPostIndent(boolean bool) {
		postIndent = bool;
	}

	public static void createInstance() {
		if (instance == null) {
			instance = new ProgramCode();
		}
	}
	
	public static void obscure() {
		dataBak = data;
		mainBak = main;
		postBak = post;
		data = new LinkedList<String>();
		main = new LinkedList<String>();
		post = new LinkedList<String>();
	}
	
	public static void restore() {
		data = dataBak;
		main = mainBak;
		post = postBak;
	}

}
