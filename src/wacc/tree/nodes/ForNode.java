package wacc.tree.nodes;

import wacc.tree.nodeSupers.AssignRHSNode;
import wacc.tree.nodeSupers.StatNode;
import wacc.util.Arm;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.RegHandler;
import wacc.util.StackHandler;

public class ForNode extends StatNode {

	@Override
	public Reg generate() {
		//TODO
    	scopeHandler.descend();
    	
    	InitialisationNode init = new InitialisationNode("int");
    	init.addChild(children.get(0));
    	AssignRHSNode rhs = (AssignRHSNode) children.get(1);
    	init.addChild(rhs);
    	Reg downBound = init.generate();
    	RegHandler.use();
        Reg upBound = children.get(2).generate();
    	
        String compLabel = ProgramCode.generateUniqueLabel();
        String repeatLabel = ProgramCode.generateUniqueLabel();
        ProgramCode.add("B " + compLabel);
        
        ProgramCode.setIndent(false);
        ProgramCode.add(repeatLabel + ":");
        ProgramCode.setIndent(true);
        
		String ident = ((IdentNode) children.get(0)).getIdent();
        ProgramCode.add("ADD " + downBound + ", " + downBound + ", " + Arm.imm(1));
		ProgramCode.add("STR " + downBound + ", " + StackHandler.get(ident));
        
        children.get(3).generate();
        
        ProgramCode.setIndent(false);
        ProgramCode.add(compLabel + ":");
        ProgramCode.setIndent(true);
        
        ProgramCode.add("CMP " + downBound + ", " + upBound);
        ProgramCode.add("BGT " + repeatLabel);
        
    	RegHandler.free(downBound);
        scopeHandler.ascend();
        return null;
	}

}
