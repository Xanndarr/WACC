package wacc.tree.nodes;

import wacc.tree.nodeSupers.Node;
import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.StackHandler;

public class AssignmentNode extends StatNode {

	@Override
	public Reg generate() {
		//TODO other LHSs
		Node lhs = children.get(0);
		Reg ret = children.get(1).generate();
		
		if (lhs instanceof IdentNode) {
			String ident = ((IdentNode) lhs).getIdent();
			ProgramCode.add("STR " + ret + ", " + StackHandler.get(ident));
		}
		return null;
	}

}
