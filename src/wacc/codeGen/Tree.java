package wacc.codeGen;

import wacc.tree.nodeInterfaces.Node;
import wacc.tree.nodes.ProgramNode;

public class Tree {
	
	private Node head = null;
	
	public Tree(ProgramNode head) {
		this.head = head;
	}

}
