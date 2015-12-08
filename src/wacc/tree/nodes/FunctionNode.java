package wacc.tree.nodes;

import java.util.LinkedList;
import java.util.List;

import wacc.tree.nodeSupers.Node;
import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.RegHandler;

public class FunctionNode extends StatNode {
	
	private final String name;
	private final String type;
	
	private final static List<String> printedFuns = new LinkedList<String>();

	public FunctionNode(String name, String type) {
		this.name = name;
		this.type = type;
	}
	

	@Override
	public Reg generate() {
		//scopeHandler.descendFun();
		scopeHandler.descend();
		
		if (!functions.containsKey(name)) {
			functions.put(name, this);
			scopeHandler.add(name, type);			
		}
		
		if (!printedFuns.contains(name) && !visiting) {
			ProgramCode.enterFunction();
			ProgramCode.setPostIndent(false);
			ProgramCode.addPost("f_" + name + ":");
			ProgramCode.setPostIndent(true);
			
			Reg ret = RegHandler.getNextReg();
			ProgramCode.addPost("PUSH {lr}");
			System.out.println(children.size());
			for (Node node : children) {
				System.out.println(node);
				node.generate();
			}
			ProgramCode.addPost("POP {pc}");
			ProgramCode.addPost("POP {pc}");
	        ProgramCode.addPost(".ltorg");
			ProgramCode.leaveFunction();
			
			ProgramCode.setPostIndent(false);
			printedFuns.add(name);
		}
			
		scopeHandler.ascend();
		//scopeHandler.ascendFun();
		return Reg.R0;
	}
	
}
