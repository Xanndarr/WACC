package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.Node;
import wacc.tree.nodeInterfaces.TypeNode;

public class BoolNode implements TypeNode {

    private final boolean b;

    public BoolNode(boolean b) {
        this.b = b;
    }

    @Override
    public void generate() {

    }
}
