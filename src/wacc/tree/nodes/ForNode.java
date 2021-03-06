package wacc.tree.nodes;

import wacc.tree.nodeSupers.AssignRHSNode;
import wacc.tree.nodeSupers.Node;
import wacc.tree.nodeSupers.StatNode;
import wacc.util.Arm;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.RegHandler;
import wacc.util.StackHandler;

public class ForNode extends StatNode {

	@Override
	public Reg generate() {
    	scopeHandler.descend();
    	RegHandler.descend();
    	
    	InitialisationNode init = new InitialisationNode("int");
    	init.addChild(children.get(0));
    	AssignRHSNode rhs = (AssignRHSNode) children.get(1);
    	init.addChild(rhs);
    	Reg downBound = init.generate();
    	RegHandler.use();
        int upBound = ((IntNode) children.get(2)).getVal();
    	
        String compLabel = ProgramCode.generateUniqueLabel();
        String repeatLabel = ProgramCode.generateUniqueLabel();
        ProgramCode.add("B " + compLabel);
        
        ProgramCode.setIndent(false);
        ProgramCode.add(repeatLabel + ":");
        ProgramCode.setIndent(true);
        
        children.get(3).generate();
        checkContinue();
        
        String ident = ((IdentNode) children.get(0)).getIdent();
        ProgramCode.add("ADD " + downBound + ", " + downBound + ", " + Arm.imm(1));
		ProgramCode.add("STR " + downBound + ", " + StackHandler.get(ident));
        
        ProgramCode.setIndent(false);
        ProgramCode.add(compLabel + ":");
        ProgramCode.setIndent(true);
        
        ProgramCode.add("CMP " + downBound + ", " + Arm.imm(upBound + 1));
        ProgramCode.add("BLT " + repeatLabel);

        checkBreak();
        
    	RegHandler.free(downBound);
        scopeHandler.ascend();
        RegHandler.ascend();
        return null;
	}

}
