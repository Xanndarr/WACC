package wacc.tree.nodes;

import wacc.tree.nodeSupers.AssignRHSNode;
import wacc.util.*;
import wacc.util.Error;

public class PairElemNode extends AssignRHSNode {
	
	public enum PairPos {
		FST, SND;
	}
	
	private PairPos pos;
	
	public PairElemNode(PairPos pos) {
		this.pos = pos;
	}
	
    @Override
    public Reg generate() {
        Reg ret = RegHandler.getNextReg();
        IdentNode identNode = (IdentNode) children.get(0);
        StackLocation identLoc = StackHandler.get(identNode.getIdent());
        ProgramCode.add("LDR " + ret + ", " + identLoc);
        ProgramCode.add("MOV r0, " + ret);
        ProgramCode.add("BL p_check_null_pointer");
        boolean existsError = printedErrorLabels.contains(Error.NULL_PTR);
        checkExistingFunctions(existsError, Error.NULL_PTR);
		switch (pos) {
			case FST:
                ProgramCode.add("LDR " + ret + ", " + ret.memory());
                break;
            case SND:
                ProgramCode.add("LDR " + ret + ", " + ret.memory(/*SIZE OF FST*/));
				break;
			default:
				break;
		}
        ProgramCode.add("LDR " + ret + ", " + ret.memory());
		return ret;
    }

    private void checkExistingFunctions(boolean existsError, Error e) {
        String dataLabel;
        if (!existsError) {
            dataLabel = RuntimeErrorCode.addErrorData(e);
            RuntimeErrorCode.addError(e, dataLabel);
            printedErrorLabels.add(e);
            if (!printedTypeLabels.containsKey(Type.STRING)) {
                dataLabel = PrintCode.addPrintData(Type.STRING);
                printedTypeLabels.put(Type.STRING, dataLabel);
                PrintCode.addPrint(Type.STRING, dataLabel);
            }
        }
    }


}
