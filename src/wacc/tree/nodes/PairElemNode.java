package wacc.tree.nodes;

import wacc.tree.nodeInterfaces.AssignLHSNode;
import wacc.tree.nodeInterfaces.AssignRHSNode;
import wacc.tree.nodeInterfaces.Node;

public class PairElemNode implements AssignLHSNode, AssignRHSNode {
	
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
