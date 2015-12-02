package wacc.tree.nodes;

import wacc.tree.Node;

public class ExitNode extends Node {
	
	public ExitNode(Node exp) {
		addChild(exp);
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
		
	}

}
