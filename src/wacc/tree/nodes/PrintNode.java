package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.Type;

public class PrintNode extends StatNode {
	
	@Override
	public Reg generate() {
		if (children.get(0) != null) {
			Reg ret = children.get(0).generate();
			String dataLabel = ProgramCode.addPrintData(nodeType);
			ProgramCode.add("MOV r0, " + ret);
			if (nodeType == Type.CHAR) {
				ProgramCode.add("BL putchar");
			} else {
				ProgramCode.add("BL p_print_" + nodeType);
				ProgramCode.addPrint(nodeType, dataLabel);
			}
		}
		return null;
	}

}
