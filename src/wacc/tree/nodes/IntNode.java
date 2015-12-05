package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.Arm;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class IntNode extends ExpNode {

    private final int n;

    public IntNode(int n) {
        this.n = n;
    }

    @Override
    public Reg generate() {
    	ProgramCode.add("LDR r4, " + Arm.imm(n));
    	return Reg.R4;
    }
}
