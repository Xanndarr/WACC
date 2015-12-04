package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.ExpNode;
import wacc.tree.nodeInterfaces.Node;

public class BoolNode extends ExpNode {

    private final boolean b;

    public BoolNode(boolean b) {
        this.b = b;
    }

    @Override
    public void generate() {

    }
}
