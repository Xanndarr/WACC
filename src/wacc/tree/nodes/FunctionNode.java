package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.Reg;

public class FunctionNode extends StatNode {
	
	private final String name;

	public FunctionNode(String name) {
		this.name = name;
	}

	@Override
	public Reg generate() {
		scopeHandler.descendFun();
		scopeHandler.descend();
		
		scopeHandler.ascend();
		scopeHandler.ascendFun();
		return null;
	}
	
}
