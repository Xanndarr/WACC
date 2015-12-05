package wacc.tree.nodes;

import wacc.tree.nodeSupers.Node;
import wacc.util.Reg;
import wacc.util.Type;

public class TypeNode extends Node {
	
	private Type type = Type.NULL;
	
	public TypeNode() {
		this.type = type;
	}

	@Override
	public Reg generate() {
		return null;
	}
	
}
