package wacc.tree.nodes;

import wacc.tree.Node;

public class FreeNode extends Node {
	
	public FreeNode(Node exp) {
		addChild(exp);
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
	}

}
