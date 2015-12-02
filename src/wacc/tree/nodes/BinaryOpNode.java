package wacc.tree.nodes;

import wacc.tree.Node;

public class BinaryOpNode extends Node {
	
	private final String op;
	
	public BinaryOpNode(Node lhs, String op, Node rhs) {
		this.op = op;
		addChild(lhs);
		addChild(rhs);
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
		
	}

}
