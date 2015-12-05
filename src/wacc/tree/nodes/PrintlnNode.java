package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.Type;

public class PrintlnNode extends StatNode {

	@Override
	public Reg generate() {
		if (children.get(0) != null) {
			Type t = Type.STRING; //TODO
			Reg ret = children.get(0).generate();
			ProgramCode.add("MOV r0, " + ret);
			String dataLabel = ProgramCode.addPrintData(t);
			if (t == Type.CHAR) {
				ProgramCode.add("BL putchar");
			} else {
				ProgramCode.add("BL p_print_" + t);
				ProgramCode.addPrint(t, dataLabel);
			}
			dataLabel = ProgramCode.addPrintData(Type.NULL);
			ProgramCode.addPrint(Type.NULL, dataLabel);
			ProgramCode.add("BL p_print_ln");
		}
		return null;
	}

}
