package wacc.tree.nodes;

import wacc.tree.Node;

public class ReadNode extends Node {

    public ReadNode(Node stat) {
        addChild(stat);
    }

    @Override
    public void generate() {

    }
}
