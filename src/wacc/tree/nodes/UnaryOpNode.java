package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.ExpNode;
import wacc.util.UnaryOp;

public class UnaryOpNode implements ExpNode {

    private UnaryOp op = UnaryOp.INVALID_OP;

    public UnaryOpNode() {
        this.op = op;
    }

    @Override
    public void generate() {

    }
}
