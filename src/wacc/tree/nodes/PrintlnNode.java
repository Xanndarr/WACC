package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.PrintCode;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.Type;

public class PrintlnNode extends StatNode {

	@Override
	public Reg generate() {
		if (children.get(0) != null) {
			Reg ret = children.get(0).generate();
			ProgramCode.add("MOV r0, " + ret);
			String dataLabel;
			if (printedTypeLabels.containsKey(nodeType)) {
				dataLabel = printedTypeLabels.get(nodeType);
			} else {
				dataLabel = PrintCode.addPrintData(nodeType);
				printedTypeLabels.put(nodeType, dataLabel);
			}
			if (nodeType == Type.CHAR) {
				ProgramCode.add("BL putchar");
			} else {
				ProgramCode.add("BL p_print_" + nodeType);
				if (!printedTypeLabels.containsKey(nodeType)) {
					PrintCode.addPrint(nodeType, dataLabel);
				}
			}
			if (!printedTypeLabels.containsKey(Type.NULL)) {
				dataLabel = PrintCode.addPrintData(Type.NULL);
				PrintCode.addPrint(Type.NULL, dataLabel);
				printedTypeLabels.put(Type.NULL, dataLabel);
			}
			ProgramCode.add("BL p_print_ln");
		}
		return null;
	}

}
