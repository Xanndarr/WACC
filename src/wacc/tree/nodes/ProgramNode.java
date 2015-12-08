package wacc.tree.nodes;

import wacc.tree.nodeSupers.Node;
import wacc.util.Arm;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class ProgramNode extends Node {

    @Override
    public Reg generate() {
        ProgramCode.add(".text\n");
        ProgramCode.add(".global main");
        ProgramCode.add("main:");

        ProgramCode.setIndent(true);

        ProgramCode.add("PUSH " + Reg.R14.stack());
        for (Node child : children) {
        	if (child instanceof FunctionNode) {
        		Node.visit(child);
        	} else {
                child.generate();
        	}
        }
		ProgramCode.add("LDR " + Reg.R0 + ", " + Arm.mem(0));
        ProgramCode.add("POP " + Reg.R15.stack());
        ProgramCode.add(".ltorg");

        ProgramCode.setIndent(false);
        return null;
    }
}

