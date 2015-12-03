package wacc.tree.nodes;

import wacc.tree.Node;

public class UnaryOpNode implements Node {

    private final String op;

    public UnaryOpNode(String op) {
        this.op = op;
    }

    @Override
    public void generate() {

    }
}
