package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.Type;

public class PrintNode extends StatNode {
	
	@Override
	public Reg generate() {
		if (children.get(0) != null) {
			Type t = Type.INT; //TODO
			Reg ret = children.get(0).generate();
			String dataLabel = ProgramCode.addPrintData(t);
			ProgramCode.add("MOV r0, " + ret);
			ProgramCode.add("BL p_print_" + t);
			ProgramCode.addPrint(t, dataLabel);
		}
		return null;
	}

}
