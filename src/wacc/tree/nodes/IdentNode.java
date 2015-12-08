package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.Reg;

public class IdentNode extends ExpNode {
	
	private final String ident;
	
	public IdentNode(String ident) {
		this.ident = ident;
	}
	
	public String getIdent() {
		return ident;
	}

	@Override
	public Reg generate() {
		return null;
	}

}
