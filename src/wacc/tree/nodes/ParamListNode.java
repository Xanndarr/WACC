package wacc.tree.nodes;

import wacc.tree.nodeSupers.Node;
import wacc.util.Reg;

public class ParamListNode extends Node {

	@Override
	public Reg generate() {
		for (Node child : children) {
			child.generate();
		}
		return null;
	}

}
