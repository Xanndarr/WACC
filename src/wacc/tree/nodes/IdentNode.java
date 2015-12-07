package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.Reg;
import wacc.util.Type;

public class IdentNode extends ExpNode {
	
	private final String ident;
	private Type type = Type.NULL;
	
	public IdentNode(String ident) {
		this.ident = ident;
	}
	
	public String getIdent() {
		return ident;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}

	@Override
	public Reg generate() {
		return null;
	}

}
