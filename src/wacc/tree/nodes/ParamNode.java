package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.Node;
import wacc.util.Type;

public class ParamNode extends Node {
	
	private Type type;
	private String ident;
	
	public ParamNode(Type type, String ident) {
		this.type = type;
		this.ident = ident;
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
		
	}

}
