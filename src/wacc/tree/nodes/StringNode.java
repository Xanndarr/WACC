package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.Arm;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class StringNode extends ExpNode {

    private final String string;

    public StringNode(String string) {
        this.string = string;
    }

    @Override
    public Reg generate() {
    	String var = ProgramCode.addData(string, string.length());
    	ProgramCode.add("MOV r4, " + Arm.mem(var));
    	return Reg.R4;
    }
}
