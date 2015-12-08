package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.RegHandler;
import wacc.util.StackHandler;
import wacc.util.Type;

public class IdentExpNode extends ExpNode {
	
	private final String ident;
	
	public IdentExpNode(String ident) {
		this.ident = ident;
	}

	@Override
	public Reg generate() {
		Reg ret = RegHandler.getNextReg();
		nodeType = Type.parse(scopeHandler.get(ident));
		String ldrInstr = "LDR ";
		if (nodeType.getSize() == 1) {
			ldrInstr = "LDRSB ";
		}
		ProgramCode.add(ldrInstr + ret + ", " + StackHandler.get(ident));
		return ret;
	}

}
