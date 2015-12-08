package wacc.tree.nodes;

import wacc.tree.nodeSupers.AssignRHSNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class FunctionCallNode extends AssignRHSNode {
	private final String ident;
	
	public FunctionCallNode(String ident) {
		this.ident = ident;
	}

    @Override
    public Reg generate() {
			ProgramCode.add("BL f_" + ident);
    		Reg ret = children.get(0).generate();
    		ProgramCode.add("MOV " + ret + ", r0");
    		return ret;
    }

}
