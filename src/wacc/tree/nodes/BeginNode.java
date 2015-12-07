package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.Reg;
import wacc.util.RegHandler;

public class BeginNode extends StatNode {

	@Override
	public Reg generate() {
		RegHandler.descend();
		return null;
	}

}
