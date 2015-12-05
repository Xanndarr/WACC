package wacc.tree.nodes;

import wacc.tree.nodeSupers.AssignRHSNode;
import wacc.util.Reg;

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
		return null;
    }
}
