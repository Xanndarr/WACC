package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.Arm;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.StackHandler;
import wacc.util.StackLocation;
import wacc.util.Type;

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
		IdentNode identNode = (IdentNode) children.get(0);
		String ident = identNode.getIdent();
		scopeHandler.add(ident, sType);
		
		int spLoc = StackHandler.getOffset() + type.getSize();
		
		ProgramCode.add("SUB sp, sp, " + Arm.imm(spLoc));
		Reg ret = children.get(1).generate();
		String strInstr = "STR ";
		if (type.getSize() == 1) {
			strInstr = "STRB ";
		}
		ProgramCode.add(strInstr + ret + ", [sp]");
		ProgramCode.add("ADD sp, sp, " + Arm.imm(spLoc));
		
		StackHandler.add(ident, new StackLocation(spLoc), type.getSize());
		return null;
	}

}
