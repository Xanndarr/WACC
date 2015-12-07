package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.*;

public class BoolNode extends ExpNode {

    private final boolean b;

    public BoolNode(boolean b) {
        this.b = b;
    }

    @Override
    public Reg generate() {
        Reg ret = RegHandler.getNextReg(false);
    	nodeType = Type.BOOL;
    	ProgramCode.add("MOV " + ret + ", " + Arm.imm(b ? 1 : 0));
    	return ret;
    }
}
