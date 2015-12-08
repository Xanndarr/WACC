package wacc.tree.nodes;

import wacc.tree.nodeSupers.AssignRHSNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.RegHandler;

public class FunctionCallNode extends AssignRHSNode {
	private final String ident;

	public FunctionCallNode(String ident) {
		this.ident = ident;
	}

	@Override
	public Reg generate() {
		Reg target = RegHandler.getNextReg();
//		if (children != null) {
//			Reg ret = children.get(0).generate();
//		}
		// TOOD ^
		ProgramCode.add("BL f_" + ident);
		Reg funRet = functions.get(ident).generate();
		ProgramCode.add("MOV " + target +", " + funRet);

		return target;
	}

}
