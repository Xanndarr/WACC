package wacc.tree.nodes;

import java.util.LinkedList;
import java.util.List;

import wacc.tree.nodeSupers.Node;
import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class FunctionNode extends StatNode {
	
	private final String name;
	private final String type;
	private static List<String> printedFunctionLabels = new LinkedList<String>();

	public FunctionNode(String name, String type) {
		this.name = name;
		this.type = type;
	}
	

	@Override
	public Reg generate() {
		//scopeHandler.descendFun();
		//scopeHandler.descend();
		
		scopeHandler.add(name, type);
		if (!functions.containsKey(name)) {
			functions.put(name, this);
		} else {
			addFunc(name, children);
		}
		
		
		//scopeHandler.ascend();
		//scopeHandler.ascendFun();
		return null;
	}
	
	private static void addFunction(String name, List<Node> children) {
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
	
	public static void addFunc(String name, List<Node> children) {
		if (!printedFunctionLabels.contains(name)) {
			addFunction(name, children);
            printedFunctionLabels.add(name);
		}
	}
	
}
