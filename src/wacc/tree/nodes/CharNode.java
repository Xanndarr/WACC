package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.ExpNode;
import wacc.tree.nodeInterfaces.Node;

public class CharNode implements ExpNode {

    private final char c;

    public CharNode(char c) {
        this.c = c;
    }

    @Override
    public void generate() {

    }
}
