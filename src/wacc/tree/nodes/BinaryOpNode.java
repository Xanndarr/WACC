package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.ExpNode;
import wacc.util.BinaryOp;

public class BinaryOpNode implements ExpNode {
	
	private final BinaryOp op;
	
	public BinaryOpNode(BinaryOp op) {
		this.op = op;
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
		
	}

}
