package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.StatNode;
import wacc.util.Type;

public class AssignmentNode implements StatNode {

	private final String ident;
	private final Type type;
	
	public AssignmentNode(Type type) {
		this.ident = ident;
		this.type = type;
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
	}

}
