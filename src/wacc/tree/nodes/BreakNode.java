package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class BreakNode extends StatNode {
	
	private String label;

	@Override
	public Reg generate() {
		label = ProgramCode.generateUniqueLabel();
		ProgramCode.add("B " + label);
		hasBreak = true;
		lastBreak = this;
		return null;
	}

	public void createBranch() {
		ProgramCode.add(label + ":");
	}

}
