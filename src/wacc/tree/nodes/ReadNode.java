package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.*;

public class ReadNode extends StatNode {

    @Override
    public Reg generate() {
    	if (children.get(0) != null) {
            Type t = Type.parse(scopeHandler.get(((IdentNode) children.get(0)).getIdent()));
    		Reg ret = RegHandler.getNextReg();
    		ProgramCode.add("ADD " + ret + ", sp, " + Arm.imm(0));
    		ProgramCode.add("MOV r0, " + ret);

    		ReadCode.addRead(t);
    		ProgramCode.add("BL p_read_" + t);
    	}
        return null;
    }
}
