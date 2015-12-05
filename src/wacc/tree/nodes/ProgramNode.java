package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.Node;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class ProgramNode extends Node {

    @Override
    public void generate() {
        ProgramCode.add(".text");
        ProgramCode.add("\n");
        ProgramCode.add(".global main");
        ProgramCode.add("main:");
        ProgramCode.add("\tPUSH " + Reg.R14.stack());
    }
}

