package wacc.tree.nodes;

import wacc.tree.nodeSupers.AssignRHSNode;
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
        IdentNode identNode = (IdentNode) children.get(0);
        StackLocation identLoc = StackHandler.get(identNode.getIdent());
        ProgramCode.add("LDR " + ret + ", " + identLoc);
        ProgramCode.add("MOV r0, " + ret);
        ProgramCode.add("BL p_check_null_pointer");
        RuntimeErrorCode.checkExistingErrors(Error.NULL_PTR);
		switch (pos) {
			case FST:
                ProgramCode.add("LDR " + ret + ", " + ret.memory());
                break;
            case SND:
                ProgramCode.add("LDR " + ret + ", " + ret.memory(/*SIZE OF FST*/));
				break;
			default:
				break;
		}
        ProgramCode.add("LDR " + ret + ", " + ret.memory());
		return ret;
    }


}
