package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.Reg;
import wacc.util.UnaryOp;

public class UnaryOpNode extends ExpNode {

    private UnaryOp op = UnaryOp.INVALID_OP;

    public UnaryOpNode() {
        this.op = op;
    }

    @Override
    public Reg generate() {

    }
}
