package wacc.tree.nodes;

import wacc.tree.Node;

public class UnaryOpNode extends Node {

    private final String op;

    public UnaryOpNode(String op, Node operand) {
        this.op = op;
        addChild(operand);
    }

    @Override
    public void generate() {

    }
}
