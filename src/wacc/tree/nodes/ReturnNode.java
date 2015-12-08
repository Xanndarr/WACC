package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.ProgramCode;
import wacc.util.Reg;

public class ReturnNode extends StatNode {

    @Override
    public Reg generate() {
    		Reg ret = children.get(0).generate();
    		ProgramCode.add("MOV r0, " + ret);
        return null;
    }
}
