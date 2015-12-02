package wacc.tree;

import java.util.LinkedList;
import java.util.List;

public abstract class Node {

	private final List<Node> children = new LinkedList<Node>();
	private final Node parent = null;
	
	public void addChild(Node child) {
		children.add(child);
	}
	
	public Node parent() {
		return parent;
	}
	
	public List<Node> children() {
		return children;
	}
	
}
