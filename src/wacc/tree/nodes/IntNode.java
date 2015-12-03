package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.Node;
import wacc.tree.nodeInterfaces.TypeNode;

public class IntNode implements TypeNode {

    private final int n;

    public IntNode(int n) {
        this.n = n;
    }

    @Override
    public void generate() {

    }
}
