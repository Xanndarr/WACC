package wacc.tree.nodeInterfaces;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public abstract class Node {

	protected List<Node> children = new LinkedList<Node>();
	
	public abstract void generate();

	public void addChild(Node child) {
		children.add(child);
	}
	
	public String print(int indent) {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getClass().getName() + "\n");
		for (Node child : children) {
			IntStream.range(0, indent).forEach((i) -> sb.append("\t"));
			if (child != null) {
				sb.append(child.print(indent + 1));
			} else {
				sb.append("null\n");
			}
		}
		return sb.toString();
	}
	
}
