package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.Reg;

public class IntNode extends ExpNode {

    private final int n;

    public IntNode(int n) {
        this.n = n;
    }

    @Override
    public Reg generate() {

    }
}
