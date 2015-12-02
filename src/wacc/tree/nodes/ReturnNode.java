package wacc.tree.nodes;

import wacc.tree.Node;

public class ReturnNode extends Node {

    public ReturnNode(Node stat) {
        addChild(stat);
    }

    @Override
    public void generate() {

    }
}
