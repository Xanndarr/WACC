package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.*;

public class PairNode extends ExpNode {

    @Override
    public Reg generate() {
        Reg ret = RegHandler.getNextReg();
        nodeType = Type.NULL;
        return ret;
    }
}
