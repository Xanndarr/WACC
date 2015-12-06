package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.BinaryOp;
import wacc.util.Reg;

public class BinaryOpNode extends ExpNode {
	
	private BinaryOp op = BinaryOp.INVALID_OP;
	
	public BinaryOpNode(BinaryOp op) {
		this.op = op;
	}

	@Override
	public Reg generate() {
		return null;
	}

}
