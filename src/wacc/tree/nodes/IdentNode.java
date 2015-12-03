package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.AssignLHSNode;
import wacc.tree.nodeInterfaces.ExpNode;

public class IdentNode implements ExpNode, AssignLHSNode {
	
	private final String ident;
	
	public IdentNode(String ident) {
		this.ident = ident;
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
		
	}

}
