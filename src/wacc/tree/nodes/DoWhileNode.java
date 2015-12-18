package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.Arm;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class DoWhileNode extends StatNode {

	@Override
	public Reg generate() {
		scopeHandler.descend();
    	
        String compLabel = ProgramCode.generateUniqueLabel();
        String repeatLabel = ProgramCode.generateUniqueLabel();

        ProgramCode.setIndent(false);
        ProgramCode.add(repeatLabel + ":");
        ProgramCode.setIndent(true);

        children.get(0).generate();

        ProgramCode.setIndent(false);
        ProgramCode.add(compLabel + ":");
        ProgramCode.setIndent(true);

        Reg condRet = children.get(1).generate();
        ProgramCode.add("CMP " + condRet + ", " + Arm.imm(1));
        ProgramCode.add("BEQ " + repeatLabel);
        
        checkBreak();

        scopeHandler.ascend();
        return null;
	}

}
