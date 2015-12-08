package wacc.util;

import java.util.List;

import wacc.tree.nodeSupers.Node;

public class FunctionCode {
	
	public static void addFunction(String name, List<Node> children) {
		ProgramCode.enterFunction();
		ProgramCode.setIndent(false);
		ProgramCode.add("f_" + name + ":");
		ProgramCode.setIndent(true);
		ProgramCode.add("PUSH {lr}");
		for (Node node : children) {
			node.generate();
		}
		ProgramCode.add("POP {pc}");
		ProgramCode.add("POP {pc}");
        ProgramCode.add(".ltorg");
		ProgramCode.leaveFunction();
	}

}
