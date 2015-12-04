package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.AssignRHSNode;

public class PairElemNode extends AssignRHSNode {
	
	public enum PairPos {
		FST, SND;
	}
	
	private PairPos pos;
	
	public PairElemNode(PairPos pos) {
		this.pos = pos;
	}
	
    @Override
    public void generate() {

    }
}
