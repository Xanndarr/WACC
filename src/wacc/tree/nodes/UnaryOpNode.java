package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.ExpNode;
import wacc.util.UnaryOp;

public class UnaryOpNode implements ExpNode {

    private final UnaryOp op;

    public UnaryOpNode(UnaryOp op) {
        this.op = op;
    }

    @Override
    public void generate() {

    }
}
