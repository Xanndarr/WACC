package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.*;

public class IntNode extends ExpNode {

    private final int n;

    public IntNode(int n) {
        this.n = n;
    }
    
    public int getVal() {
    	return n;
    }
    
    @Override
    public Reg generate() {
        Reg ret = RegHandler.getNextReg();
    	nodeType = Type.INT;
    	ProgramCode.add("LDR " + ret + ", " + Arm.mem(n));
    	return ret;
    }
}
