package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.*;

public class PrintlnNode extends StatNode {

	@Override
	public Reg generate() {
        RegHandler.descend();
		if (children.get(0) != null) {
			Reg ret = children.get(0).generate();
            ProgramCode.add("SUB sp, sp, " + Arm.imm(StackHandler.getOffset()));
			ProgramCode.add("MOV r0, " + ret);
			
			if (nodeType == Type.CHAR) {
				ProgramCode.add("BL putchar");
			} else {
				if (nodeType == Type.ARRAY || nodeType == Type.PAIR) {
					ProgramCode.add("BL p_print_reference");
				} else {
					ProgramCode.add("BL p_print_" + nodeType);
				}
				PrintCode.addPrint(nodeType);
			}
			PrintCode.addPrint(Type.NULL);
			ProgramCode.add("BL p_print_ln");
            ProgramCode.add("ADD sp, sp, " + Arm.imm(StackHandler.getOffset()));
        }
        RegHandler.ascend();
		return null;
	}

}
