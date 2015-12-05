package wacc.codeGen;

import wacc.tree.nodeSupers.Node;

public class Tree {
	
	private Node head = null;
	
	public Tree(Node head) {
		this.head = head;
	}
	
	public String print() {
		return head.print(1);
	}
	
	public void generate() {
		head.generate();
	}

}
