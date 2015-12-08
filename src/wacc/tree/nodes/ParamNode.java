package wacc.tree.nodes;

import wacc.tree.nodeSupers.Node;
import wacc.util.Reg;
import wacc.util.Type;

public class ParamNode extends Node {

	private String ident;
	private Type type;
	private String sType;
	
	public ParamNode(String ident, String type) {
		this.ident = ident;
		this.sType = type;
		this.type = Type.parse(type);
	}

	@Override
	public Reg generate() {
		scopeHandler.add(ident, sType);
		nodeType = type;
		return null;
	}

}
