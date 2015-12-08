package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.*;
import wacc.util.Error;

public class FreeNode extends StatNode {

	@Override
	public Reg generate() {
        String ident = ((IdentNode) children.get(0)).getIdent();
        Reg freeAdd = RegHandler.getNextReg();
        ProgramCode.add("LDR " + freeAdd + ", "  + StackHandler.get(ident));
        ProgramCode.add("MOV " + Reg.R0  + ", " + freeAdd);
		ProgramCode.add("BL p_free_pair");
        RuntimeErrorCode.addError(Error.NULL_REF);
        StackHandler.remove(ident);
        return null;
    }

}
