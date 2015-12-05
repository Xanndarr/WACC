package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.Arm;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class CharNode extends ExpNode {

    private final char c;

    public CharNode(char c) {
        this.c = c;
    }

    @Override
    public Reg generate() {
    	ProgramCode.add("MOV r4, " + Arm.imm("'c'"));
    	return Reg.R4;
    }
}
