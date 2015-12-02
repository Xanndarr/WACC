package wacc.tree.nodes;

import wacc.tree.Node;

public class IdentNode extends Node {
	
	private final String ident;
	
	public IdentNode(String ident) {
		this.ident = ident;
	}

}
