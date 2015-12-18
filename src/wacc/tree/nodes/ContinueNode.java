package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class ContinueNode extends StatNode {
	
	private String label;

	@Override
	public Reg generate() {
		label = ProgramCode.generateUniqueLabel();
		return null;
	}
	
	public String getLabel() {
		return label;
	}

}
