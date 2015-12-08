package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.*;

public class ReadNode extends StatNode {

    @Override
    public Reg generate() {
    	if (children.get(0) != null) {
            String ident = ((IdentNode) children.get(0)).getIdent();
            Type t = Type.parse(scopeHandler.get(ident));
    		Reg ret = RegHandler.getNextReg();
    		ProgramCode.add("ADD " + ret + ", sp, " + Arm.imm(-StackHandler.get(ident).getOffset()));
    		ProgramCode.add("MOV r0, " + ret);

//            int spLoc = StackHandler.getOffset();
//            ProgramCode.add("SUB sp, sp, " + Arm.imm(spLoc));
    		ReadCode.addRead(t);
    		ProgramCode.add("BL p_read_" + t);
//            ProgramCode.add("ADD sp, sp, " + Arm.imm(spLoc));
    	}
        return null;
    }
}
