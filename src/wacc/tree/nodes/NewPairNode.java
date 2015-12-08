package wacc.tree.nodes;

import wacc.tree.nodeSupers.AssignRHSNode;
import wacc.tree.nodeSupers.Node;
import wacc.util.*;

public class NewPairNode extends AssignRHSNode {

    @Override
    public Reg generate() {
        RegHandler.descend();
        ProgramCode.add("LDR " + Reg.R0 + ", " + Arm.mem(8));
        ProgramCode.add("BL malloc");
        Reg pairSize = RegHandler.getNextReg();
        ProgramCode.add("MOV " + pairSize + ", r0");

        //fst
        Reg fstRet = children.get(0).generate();
        String strInstr = "STR ";
        if (nodeType.getSize() == 1) {
            strInstr = "STRB ";
        }
        ProgramCode.add("LDR " + Reg.R0 + ", " + Arm.mem(nodeType.getSize()));
        ProgramCode.add("BL malloc");
        ProgramCode.add(strInstr + fstRet + ", " + Reg.R0.memory());
        ProgramCode.add("STR " + Reg.R0 + ", " + pairSize.memory());

        //snd
        strInstr = "STR ";
        if (nodeType.getSize() == 1) {
            strInstr = "STRB ";
        }
        Reg sndRet = children.get(1).generate();
        ProgramCode.add("LDR " + Reg.R0 + ", " + Arm.mem(nodeType.getSize()));
        ProgramCode.add("BL malloc");
        ProgramCode.add(strInstr + sndRet + ", " + Reg.R0.memory());
        ProgramCode.add("STR " + Reg.R0 + ", " + pairSize.memory(4));
        RegHandler.ascend();
        return pairSize;
    }

}
