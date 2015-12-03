package wacc.tree.nodes;

import wacc.tree.Node;
import wacc.util.Type;

public class InitialisationNode implements Node {
	
	private final String ident;
	private final Type type;
	
	public InitialisationNode(String ident, Type type) {
		this.ident = ident;
		this.type = type;
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
		
	}

}
