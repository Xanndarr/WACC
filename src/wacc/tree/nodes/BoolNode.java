package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.Arm;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.Type;

public class BoolNode extends ExpNode {

    private final boolean b;

    public BoolNode(boolean b) {
        this.b = b;
    }

    @Override
    public Reg generate() {
    	nodeType = Type.BOOL;
    	ProgramCode.add("MOV r4, " + Arm.imm(b ? 1 : 0));
    	return Reg.R4;
    }
}
