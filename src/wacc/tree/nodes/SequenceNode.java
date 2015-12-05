package wacc.tree.nodes;

import wacc.tree.nodeSupers.Node;
import wacc.tree.nodeSupers.StatNode;
import wacc.util.Reg;

public class SequenceNode extends StatNode {

    @Override
    public Reg generate() {
    	for (Node child : children) {
    		child.generate();
    	}
        return null;
    }

}
