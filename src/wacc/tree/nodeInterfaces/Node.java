package wacc.tree.nodeInterfaces;

import java.util.LinkedList;
import java.util.List;

public interface Node {

	List<Node> children = new LinkedList<Node>();

	default void addChild(Node child) {
		children.add(child);
	}
	
	public abstract void generate();
	
}
