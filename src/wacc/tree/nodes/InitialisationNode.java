package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.*;

public class InitialisationNode extends StatNode {
	
	private final Type type;
	private final String sType;
	
	public InitialisationNode(String sType) {
		this.type = Type.parse(sType);
		this.sType = sType;
	}

	@Override
	public Reg generate() {
		//TODO all the other assign_rhs
		RegHandler.descend();
		IdentNode identNode = (IdentNode) children.get(0);
		String ident = identNode.getIdent();
		scopeHandler.add(ident, sType);
		
		int spLoc = StackHandler.getOffset() + type.getSize();
		StackHandler.add(ident, new StackLocation(spLoc), type.getSize());
		int tempSpLoc = spLoc;
		while (spLoc > 1024) {
			ProgramCode.add("SUB sp, sp, #1024");
			spLoc -= 1024;
		}
		ProgramCode.add("SUB sp, sp, " + Arm.imm(spLoc));
		Reg ret = children.get(1).generate();
		String strInstr = "STR ";
		if (type.getSize() == 1) {
			strInstr = "STRB ";
		}
		ProgramCode.add(strInstr + ret + ", [sp]");
		while (tempSpLoc > 1024) {
			ProgramCode.add("ADD sp, sp, #1024");
			tempSpLoc -= 1024;
		}
		ProgramCode.add("ADD sp, sp, " + Arm.imm(tempSpLoc));
		
		RegHandler.ascend();
		return null;
	}

}
