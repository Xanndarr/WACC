package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.*;

public class StringNode extends ExpNode {

    private final String string;

    public StringNode(String string) {
        this.string = string;
    }

    @Override
    public Reg generate() {
        Reg ret = RegHandler.peekNextReg();
    	nodeType = Type.STRING;
    	String var = ProgramCode.addData(string);
    	ProgramCode.add("LDR " + ret + ", " + Arm.mem(var));
    	return ret;
    }
}
