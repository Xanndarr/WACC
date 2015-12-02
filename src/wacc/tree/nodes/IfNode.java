package wacc.tree.nodes;

import wacc.tree.Node;

public class IfNode extends Node {
	
	public IfNode(Node condtion, Node body) {
		addChild(condtion);
		addChild(body);
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
		
	}

}
