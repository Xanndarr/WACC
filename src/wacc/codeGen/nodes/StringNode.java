package wacc.codeGen.nodes;

import wacc.tree.Node;

public class StringNode extends Node {

    private final String string;

    public StringNode(String string) {
        this.string = string;
    }

}
