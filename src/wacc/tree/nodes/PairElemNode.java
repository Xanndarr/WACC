package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.AssignLHSNode;

public class PairElemNode extends AssignLHSNode {
	
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
