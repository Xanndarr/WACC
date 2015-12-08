package wacc.tree.nodes;

import wacc.tree.nodeSupers.ExpNode;
import wacc.tree.nodeSupers.Node;
import wacc.util.Arm;
import wacc.util.Error;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.RegHandler;
import wacc.util.RuntimeErrorCode;
import wacc.util.StackHandler;
import wacc.util.Type;

public class ArrayElemNode extends ExpNode {

	@Override
	public Reg generate() {
		IdentNode identNode = (IdentNode) children.get(0);
		String ident = identNode.getIdent();
		Reg reg = RegHandler.getNextReg();
		
		RegHandler.setPeek(true);
		for (Node child : children.subList(1, children.size())) {
			ProgramCode.add("ADD " + reg + ", sp, " + Arm.imm(-StackHandler.get(ident).getOffset()));
			Reg ret = child.generate();
			ProgramCode.add("LDR " + reg + ", " + reg.memory());
			ProgramCode.add("SUB " + reg + ", " + Arm.imm(Type.INT.getSize()));
			ProgramCode.add("MOV r0, " + ret);
			ProgramCode.add("MOV r1, " + reg);
			int spLoc = StackHandler.getOffset();
			ProgramCode.add("SUB sp, sp, " + Arm.imm(spLoc));
			ProgramCode.add("BL p_check_array_bounds");
			RuntimeErrorCode.addError(Error.ARR_OOB);
			ProgramCode.add("ADD sp, sp, " + Arm.imm(spLoc));
			ProgramCode.add("ADD " + reg + ", " + reg + ", " + Arm.imm(-nodeType.getSize()));
			ProgramCode.add("SUB " + reg + ", " + reg + ", " + ret + ", LSL #2");
		}
		RegHandler.setPeek(false);
		
		ProgramCode.add("LDR " + reg + ", " + reg.memory());
		return reg;
	}

}
