package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.Error;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.RuntimeErrorCode;

public class FreeNode extends StatNode {

	@Override
	public Reg generate() {
		ProgramCode.add("BL p_free_pair");
        RuntimeErrorCode.addError(Error.NULL_REF);
        return null;
    }

}
