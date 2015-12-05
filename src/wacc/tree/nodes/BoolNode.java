package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.Reg;

public class BoolNode extends ExpNode {

    private final boolean b;

    public BoolNode(boolean b) {
        this.b = b;
    }

    @Override
    public Reg generate() {

    }
}
