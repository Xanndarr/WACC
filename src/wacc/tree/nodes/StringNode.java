package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.Node;
import wacc.tree.nodeInterfaces.TypeNode;

public class StringNode implements TypeNode {

    private final String string;

    public StringNode(String string) {
        this.string = string;
    }

    @Override
    public void generate() {

    }
}
