package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class ContinueNode extends StatNode {

	@Override
	public Reg generate() {
		//TODO
		ProgramCode.add("B after_loop");
		return null;
	}

}
