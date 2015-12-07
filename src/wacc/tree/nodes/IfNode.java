package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class IfNode extends StatNode {

	@Override
	public Reg generate() {
		scopeHandler.descend();
		
		Reg condRet = children.get(0).generate();
		ProgramCode.add("CMP " + condRet + ", #0");
		String elseLabel = ProgramCode.generateUniqueLabel();
		String endLabel = ProgramCode.generateUniqueLabel();

		ProgramCode.add("BEQ " + elseLabel);
		children.get(1).generate();
		ProgramCode.add("B " + endLabel);

		ProgramCode.setIndent(false);
		ProgramCode.add(elseLabel + ":");
		ProgramCode.setIndent(true);

		children.get(2).generate();

		ProgramCode.setIndent(false);
		ProgramCode.add(endLabel + ":");
		ProgramCode.setIndent(true);

		scopeHandler.ascend();
		return null;
	}

}
