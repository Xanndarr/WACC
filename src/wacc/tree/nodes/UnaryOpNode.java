package wacc.tree.nodes;

import wacc.tree.Node;

public class UnaryOpNode implements ExpNode {

    private final String op;

    public UnaryOpNode(String op) {
        this.op = op;
    }

    @Override
    public void generate() {

    }
}
