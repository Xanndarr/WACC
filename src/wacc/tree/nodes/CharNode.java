package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.*;

public class CharNode extends ExpNode {

    private final char c;

    public CharNode(char c) {
        this.c = c;
    }

    @Override
    public Reg generate() {
        Reg ret = RegHandler.peekNextReg();
    	nodeType = Type.CHAR;
    	ProgramCode.add("MOV " + ret + ", " + Arm.imm("'" + c + "'"));
    	return ret;
    }
}
