package wacc.tree.nodes;

import wacc.tree.Node;

public class WhileNode extends Node {

    public WhileNode(BoolNode cond, Node body) {
        addChild(cond);
        addChild(body);
    }

    @Override
    public void generate() {

    }
}
