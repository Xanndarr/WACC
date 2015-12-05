package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.Reg;

public class IdentNode extends ExpNode {
	
	private final String ident;
	
	public IdentNode(String ident) {
		this.ident = ident;
	}

	@Override
	public Reg generate() {
		// TODO Auto-generated method stub
		
	}

}
