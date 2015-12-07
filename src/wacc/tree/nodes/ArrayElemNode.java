package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.tree.nodeSupers.Node;
import wacc.util.Arm;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.RegHandler;
import wacc.util.StackHandler;

public class ArrayElemNode extends ExpNode {

	@Override
	public Reg generate() {
		IdentNode identNode = (IdentNode) children.get(0);
		String ident = identNode.getIdent();
		Reg reg = RegHandler.getNextReg();
		
		for (Node child : children.subList(1, children.size())) {
			ProgramCode.add("ADD " + reg + ", sp, " + Arm.imm(StackHandler.get(ident).getOffset()));
			Reg ret = child.generate();
			ProgramCode.add("LDR " + reg + ", " + reg.memory());
			ProgramCode.add("MOV r0, " + ret);
			ProgramCode.add("MOV r1, " + reg);
			ProgramCode.add("BL p_check_array_bounds");
			ProgramCode.add("ADD " + reg + ", " + reg + ", " + Arm.imm(nodeType.getSize()));
			ProgramCode.add("ADD " + reg + ", " + reg + ", " + ret + ", LSL #2");
		}
		
		ProgramCode.add("LDR " + reg + ", " + reg.memory());
		return reg;
	}

}
