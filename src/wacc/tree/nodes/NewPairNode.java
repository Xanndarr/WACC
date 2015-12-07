package wacc.tree.nodes;

import wacc.tree.nodeSupers.AssignRHSNode;
import wacc.tree.nodeSupers.Node;
import wacc.util.*;

public class NewPairNode extends AssignRHSNode {

    @Override
    public Reg generate() {
        Node.visit(children.get(0));
        int totalSize = nodeType.getSize();
        Node.visit(children.get(1));
        totalSize += nodeType.getSize();
        ProgramCode.add("LDR " + Reg.R0 + ", " + Arm.mem(totalSize));
        ProgramCode.add("BL malloc");
        Reg pairSize = RegHandler.getNextReg();
        ProgramCode.add("MOV " + pairSize + ", r0");

        //fst
        Reg fstRet = children.get(0).generate();
        ProgramCode.add("LDR " + Reg.R0 + ", " + Arm.mem(nodeType.getSize()));
        ProgramCode.add("BL malloc");
        ProgramCode.add("STR " + fstRet + ", " + Reg.R0.memory());
        ProgramCode.add("STR " + Reg.R0 + ", " + pairSize.memory());

        //snd
        Reg sndRet = children.get(1).generate();
        ProgramCode.add("LDR " + Reg.R0 + ", " + Arm.mem(nodeType.getSize()));
        ProgramCode.add("BL malloc");
        ProgramCode.add("STR " + fstRet + ", " + Reg.R0.memory());
        ProgramCode.add("STR " + Reg.R0 + ", " + pairSize.memory(nodeType.getSize()));

        return pairSize;
    }

}
