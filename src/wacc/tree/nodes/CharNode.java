package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.Node;
import wacc.tree.nodeInterfaces.TypeNode;

public class CharNode implements TypeNode {

    private final char c;

    public CharNode(char c) {
        this.c = c;
    }

    @Override
    public void generate() {

    }
}
