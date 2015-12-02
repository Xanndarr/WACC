package wacc.tree.nodes;

import wacc.tree.Node;

public class ProgramNode extends Node {

    public ProgramNode(Node stat, Node...functions) {
        for (Node function : functions) {
            addChild(function);
        }
        addChild(stat);
    }

    @Override
    public void generate() {

    }
}
