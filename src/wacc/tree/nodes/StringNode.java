package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.Reg;

public class StringNode extends ExpNode {

    private final String string;

    public StringNode(String string) {
        this.string = string;
    }

    @Override
    public Reg generate() {

    }
}
