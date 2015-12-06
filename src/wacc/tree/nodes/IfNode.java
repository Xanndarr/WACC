package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class IfNode extends StatNode {

	@Override
	public Reg generate() {
		Reg condRet = children.get(0).generate();
		ProgramCode.add("CMP " + condRet + ", #0");
		String thenLabel = ProgramCode.generateUniqueLabel();
		String elseLabel = ProgramCode.generateUniqueLabel();
		ProgramCode.add("BEQ " + thenLabel);
		ProgramCode.add("B " + elseLabel);
		
		ProgramCode.setIndent(false);
		ProgramCode.add(thenLabel + ":");
		ProgramCode.setIndent(true);
		children.get(1).generate();

		ProgramCode.setIndent(false);
		ProgramCode.add(elseLabel + ":");
		ProgramCode.setIndent(true);
		children.get(2).generate();
		
		return null;
	}

}
