package wacc.tree.nodes;

import wacc.tree.nodeSupers.AssignRHSNode;
import wacc.tree.nodeSupers.Node;
import wacc.util.*;
import wacc.util.Error;

public class PairElemNode extends AssignRHSNode {
	
	public enum PairPos {
		FST, SND;
	}
	
	private PairPos pos;
	
	public PairElemNode(PairPos pos) {
		this.pos = pos;
	}
	
    @Override
    public Reg generate() {
        Reg ret = RegHandler.getNextReg();
        IdentExpNode identNode = (IdentExpNode) children.get(0);
        StackLocation identLoc = StackHandler.get(identNode.getIdent());
        ProgramCode.add("LDR " + ret + ", " + identLoc);
        ProgramCode.add("MOV r0, " + ret);
        ProgramCode.add("BL p_check_null_pointer");
        RuntimeErrorCode.addError(Error.NULL_PTR);
        String spLoc = ret.memory();
		if (pos == PairPos.SND) {
            spLoc = ret.memory(4);
        }
        String strInstr = "LDR ";
        Node.visit(children.get(0));
        if (nodeType.getSize() == 1) {
            strInstr = "LDRSB ";
        }
        ProgramCode.add(strInstr + ret + ", " + spLoc);
		return ret;
    }


}
