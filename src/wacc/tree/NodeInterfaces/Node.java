package wacc.tree.NodeInterfaces;

import java.util.LinkedList;
import java.util.List;

public interface Node {

	List<Node> children = new LinkedList<Node>();

	static void addChild(Node child) {
		children.add(child);
	}
	
	public abstract void generate();
	
}
