package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.Reg;
import wacc.util.Type;

public class PairNode extends ExpNode {

    @Override
    public Reg generate() {
        nodeType = Type.PAIR;
        return null;
    }
}
