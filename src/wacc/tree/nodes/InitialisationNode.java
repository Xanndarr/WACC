package wacc.tree.nodes;

import wacc.tree.Node;
import wacc.util.Type;

public class InitialisationNode extends Node {
	
	private final String ident;
	private final Type type;
	
	public InitialisationNode(String ident, Type type, Node value) {
		this.ident = ident;
		this.type = type;
		addChild(value);
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
		
	}

}
