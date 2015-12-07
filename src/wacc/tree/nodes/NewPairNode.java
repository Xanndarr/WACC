package wacc.tree.nodes;

import wacc.tree.nodeSupers.AssignRHSNode;
import wacc.util.*;

public class NewPairNode extends AssignRHSNode {

    @Override
    public Reg generate() {
        children.get(1).generate();
        Type sndType = nodeType;
        //Changed initialisation to store total size of pair in r0
        ProgramCode.add("BL malloc");

        Reg pairSize = RegHandler.getNextReg();
        //fst
        ProgramCode.add("MOV " + pairSize + ", r0");
        children.get(0).generate();
        Type fstType = nodeType;
        Reg fstRet = RegHandler.getNextReg()
        ProgramCode.add("LDR " + fstRet + Arm.imm(nodeType.getSize()));
        ProgramCode.add("BL malloc");
        ProgramCode.add("STR " + fstRet + ", " + Reg.R0.memory());
        ProgramCode.add("STR " + Reg.R0.memory() + ", " + pairSize.memory());


    }

}
