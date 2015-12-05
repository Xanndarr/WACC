package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.Type;

public class PrintNode extends StatNode {
	
	@Override
	public Reg generate() {
		if (children.get(0) != null) {
			Type t = Type.CHAR; //TODO
			Reg ret = children.get(0).generate();
			String dataLabel = ProgramCode.addPrintData(t);
			ProgramCode.add("MOV r0, " + ret);
			if (t == Type.CHAR) {
				ProgramCode.add("BL putchar");
			} else {
				ProgramCode.add("BL p_print_" + t);
				ProgramCode.addPrint(t, dataLabel);
			}
		}
		return null;
	}

}
