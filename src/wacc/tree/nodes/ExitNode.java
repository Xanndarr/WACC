package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class ExitNode extends StatNode {

	@Override
	public Reg generate() {
		if (children.get(0) != null) {
			Reg ret = children.get(0).generate();
			ProgramCode.add("MOV r0, " + ret);
			ProgramCode.add("BL exit");
		}
		return null;
	}

}
