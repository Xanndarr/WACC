package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.Reg;
import wacc.util.Type;

public class InitialisationNode extends StatNode {
	
	private final Type type;
	
	public InitialisationNode(Type type) {
		this.type = type;
	}

	@Override
	public Reg generate() {
		// TODO Auto-generated method stub
		
	}

}
