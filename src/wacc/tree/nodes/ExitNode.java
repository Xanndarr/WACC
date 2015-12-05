package wacc.tree.nodes;

import wacc.tree.nodeSupers.Node;
import wacc.tree.nodeSupers.StatNode;
import wacc.util.Arm;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class ExitNode extends StatNode {

	@Override
	public Reg generate() {
		for (Node child : children) {
			child.generate();
		}
		ProgramCode.add("LDR r4, " + Arm.imm(o));
	}

}
