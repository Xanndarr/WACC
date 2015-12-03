package wacc.tree.nodes;

import wacc.tree.Node;

public class StringNode implements Node {

    private final String string;

    public StringNode(String string) {
        this.string = string;
    }

    @Override
    public void generate() {

    }
}
