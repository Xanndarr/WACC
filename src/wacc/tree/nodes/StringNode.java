package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.ExpNode;
import wacc.tree.nodeInterfaces.Node;

public class StringNode extends ExpNode {

    private final String string;

    public StringNode(String string) {
        this.string = string;
    }

    @Override
    public void generate() {

    }
}
