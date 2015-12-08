package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.FunctionCode;
import wacc.util.Reg;

public class FunctionNode extends StatNode {
	
	private final String name;
	private final String type;

	public FunctionNode(String name, String type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public Reg generate() {
		//scopeHandler.descendFun();
		//scopeHandler.descend();
		
		scopeHandler.add(name, type);
		FunctionCode.addFunction(name, children);
		
		//scopeHandler.ascend();
		//scopeHandler.ascendFun();
		return null;
	}
	
}
