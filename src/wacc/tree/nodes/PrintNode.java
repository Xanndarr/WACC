package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.Type;

public class PrintNode extends StatNode {
	
	private final static String PRINT_CODE = "%.*s\0";

	@Override
	public Reg generate() {
		if (children.get(0) != null) {
			Reg ret = children.get(0).generate();
			String dataLabel = ProgramCode.addData(PRINT_CODE, PRINT_CODE.length());
			ProgramCode.add("MOV r0, " + ret);
			ProgramCode.add("BL p_print_string");
			ProgramCode.addPrint(Type.STRING, dataLabel);
		}
		return null;
	}

}
