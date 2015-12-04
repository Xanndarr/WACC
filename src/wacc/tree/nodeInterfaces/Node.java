package wacc.tree.nodeInterfaces;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public abstract class Node {

	List<Node> children = new LinkedList<Node>();
	
	public abstract void generate();

	public void addChild(Node child) {
		children.add(child);
	}
	
	public String print(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName() + "\n");
		for (Node child : children) {
			for (int i = 1; i <= indent; i++) {
				sb.append("\t");
			}
			if (child != null) {
				sb.append(child.print(indent + 1));
			} else {
				sb.append("skip");
			}
		}
		return sb.toString();
	}
	
}
