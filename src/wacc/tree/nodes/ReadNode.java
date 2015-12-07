package wacc.tree.nodes;

import wacc.tree.nodeSupers.StatNode;
import wacc.util.Arm;
import wacc.util.ProgramCode;
import wacc.util.ReadCode;
import wacc.util.Reg;

public class ReadNode extends StatNode {

    @Override
    public Reg generate() {
    	if (children.get(0) != null) {
    		Reg ret = children.get(0).generate();
    		ProgramCode.add("ADD " + ret + ", sp, " + Arm.imm(0));
    		ProgramCode.add("MOV r0, " + ret);
    		String dataLabel;
    		if (printedReadLabels.containsKey(nodeType)) {
    			dataLabel = printedReadLabels.get(nodeType);
    		} else {
    			dataLabel = ReadCode.addReadData(nodeType);
    		}
    		
    		ProgramCode.add("BL p_read_" + nodeType);
    		if (!printedReadLabels.containsKey(nodeType)) {
    			ReadCode.addRead(nodeType, dataLabel);
    			printedReadLabels.put(nodeType, dataLabel);
    		}
    	}
        return null;
    }
}
