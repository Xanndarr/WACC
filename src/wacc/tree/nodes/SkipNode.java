package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.StatNode;
import wacc.util.Arm;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class SkipNode extends StatNode {

	@Override
	public void generate() {
		ProgramCode.add("LDR " + Reg.R0 + ", " + Arm.imm(0));
	}

}
