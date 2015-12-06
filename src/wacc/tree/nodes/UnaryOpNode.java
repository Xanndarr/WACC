package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.Reg;
import wacc.util.Type;
import wacc.util.UnaryOp;

public class UnaryOpNode extends ExpNode {

    private UnaryOp op = UnaryOp.INVALID_OP;

    public UnaryOpNode(UnaryOp op) {
        this.op = op;
    }

    @Override
    public Reg generate() {
    	switch (op) {
		case NOT:
			nodeType = Type.BOOL;
			break;
		case CHR:
			nodeType = Type.CHAR;
			break;
		case ORD:
		case SUB:
		case LEN:
			nodeType = Type.INT;
			break;
		default:
			break;
		}
        return null;
    }
}
