package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.Reg;
import wacc.util.RegHandler;
import wacc.util.Type;

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
		RegHandler.descend();
		Reg fst = RegHandler.getNextReg();
		nodeType = Type.parse(scopeHandler.get(ident));
		RegHandler.ascend();
		return fst;
	}

}
