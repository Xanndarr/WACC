package wacc.tree.nodes;

import wacc.tree.nodeSupers.AssignRHSNode;
import wacc.tree.nodeSupers.Node;
import wacc.util.Arm;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.RegHandler;
import wacc.util.Type;

public class ArrayNode extends AssignRHSNode {

	@Override
	public Reg generate() {
		RegHandler.descend();
		Type elemType = Type.NULL;
		if (!children.isEmpty()) {
			Node.visit(children.get(0));
			elemType = nodeType;
		}
		int mallocSize = (elemType.getSize() * children.size()) + Type.INT.getSize();
		
		ProgramCode.add("LDR r0, " + Arm.mem(mallocSize));
		ProgramCode.add("BL malloc");
		Reg fst = RegHandler.getNextReg();
		ProgramCode.add("MOV " + fst + ", r0");
		
		int sp = Type.INT.getSize();
		
		for (Node child : children) {
			Reg ret = child.generate();
			if (elemType.getSize() == 1) {
				ProgramCode.add("STRB " + ret + ", [" + fst + ", " + Arm.imm(sp) + "]");
			} else {
				ProgramCode.add("STR " + ret + ", [" + fst + ", " + Arm.imm(sp) + "]");
			}
			sp += nodeType.getSize();
		}
		
		IntNode arraySize = new IntNode(children.size());
		Reg arrSizeRet = arraySize.generate();
		
		ProgramCode.add("STR " + arrSizeRet + ", [" + fst + "]");
		
		RegHandler.ascend();
		return fst;
	}

}
