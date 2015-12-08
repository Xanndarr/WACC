package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.*;

public class PrintNode extends StatNode {
	
	@Override
	public Reg generate() {
		if (children.get(0) != null) {
			Reg ret = children.get(0).generate();
			ProgramCode.add("SUB sp, sp, " + Arm.imm(StackHandler.getOffset()));
			ProgramCode.add("MOV r0, " + ret);
			
			if (nodeType == Type.CHAR) {
				ProgramCode.add("BL putchar");
			} else {
				ProgramCode.add("BL p_print_" + nodeType);
				PrintCode.addPrint(nodeType);
			}
			ProgramCode.add("ADD sp, sp, " + Arm.imm(StackHandler.getOffset()));
		}
		return null;
	}

}
