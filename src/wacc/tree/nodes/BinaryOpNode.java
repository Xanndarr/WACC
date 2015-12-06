package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.BinaryOp;
import wacc.util.Reg;
import wacc.util.Type;

public class BinaryOpNode extends ExpNode {
	
	private BinaryOp op = BinaryOp.INVALID_OP;
	
	public BinaryOpNode(BinaryOp op) {
		this.op = op;
	}

	@Override
	public Reg generate() {
		switch (op) {
		case MULT:
		case DIV:
		case MOD:
		case ADD:
		case SUB:
			nodeType = Type.INT;
			break;
		case GT:
		case GTE:
		case LT:
		case LTE:
			nodeType = Type.BOOL;
			break;
		case EQ:
		case NEQ:
			nodeType = Type.BOOL;
			break;
		case AND:
		case OR:
			nodeType = Type.BOOL;
			break;
		default:
			break;
		}
		return null;
	}

}
