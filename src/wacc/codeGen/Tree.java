package wacc.codeGen;

import wacc.tree.nodeSupers.Node;
import wacc.util.ProgramCode;
import wacc.util.RegHandler;
import wacc.util.StackHandler;

public class Tree {
	
	private Node head = null;
	
	public Tree(Node head) {
		this.head = head;
	}
	
	public String print() {
		return head.print(1);
	}
	
	public void generate() {
        ProgramCode.createInstance();
        StackHandler.createInstance();
        RegHandler.createInstance();
		head.generate();
	}

}
