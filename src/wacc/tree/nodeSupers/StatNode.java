package wacc.tree.nodeSupers;

import wacc.tree.nodes.BreakNode;
import wacc.tree.nodes.ContinueNode;
import wacc.util.ProgramCode;

public abstract class StatNode extends Node {

	protected static boolean hasContinue = false;
	protected static ContinueNode lastContinue;
	protected static boolean hasBreak = false;
	protected static BreakNode lastBreak;

	public void checkContinue() {
		if (hasContinue) {
			ProgramCode.setIndent(false);
			lastContinue.createBranch();
			ProgramCode.setIndent(true);
		}
		hasContinue = false;
		lastContinue = null;
	}

	public void checkBreak() {
		if (hasBreak) {
			ProgramCode.setIndent(false);
			lastBreak.createBranch();
			ProgramCode.setIndent(true);
		}
		hasBreak = false;
		lastBreak = null;
	}

}
