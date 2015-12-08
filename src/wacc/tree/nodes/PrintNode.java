package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.*;

public class PrintNode extends StatNode {
	
	@Override
	public Reg generate() {
        RegHandler.descend();
		if (children.get(0) != null) {
			Reg ret = children.get(0).generate();
			int spLoc;
			int temp = spLoc = StackHandler.getOffset();
			while (spLoc > 1024) {
				ProgramCode.add("SUB sp, sp, #1024");
				spLoc -= 1024;
			}
			ProgramCode.add("SUB sp, sp, " + Arm.imm(spLoc));
			ProgramCode.add("MOV r0, " + ret);
			
			if (nodeType == Type.CHAR) {
				ProgramCode.add("BL putchar");
			} else {
				if (nodeType == Type.ARRAY || nodeType == Type.NULL) {
					ProgramCode.add("BL p_print_reference");
				} else {
					ProgramCode.add("BL p_print_" + nodeType);
				}
				PrintCode.addPrint(nodeType);
			}
			while (temp > 1024) {
				ProgramCode.add("ADD sp, sp, #1024");
				temp -= 1024;
			}
            ProgramCode.add("ADD sp, sp, " + Arm.imm(temp));
		}
        RegHandler.ascend();
		return null;
	}

}
