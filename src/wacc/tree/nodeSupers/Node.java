package wacc.tree.nodeSupers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import wacc.util.Error;
import wacc.util.ProgramCode;
import wacc.util.Reg;
import wacc.util.Type;

public abstract class Node {

	protected List<Node> children = new LinkedList<Node>();
	protected static Type nodeType = null;
	protected static final Map<Type, String> printedTypeLabels = new HashMap<Type, String>();
	protected static final Map<Type, String> printedReadLabels = new HashMap<Type, String>();
	protected static final List<Error> printedErrorLabels = new LinkedList<Error>();
	
	public abstract Reg generate();

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
	
	public static void visit(Node n) {
		ProgramCode.obscure();
		n.generate();
		ProgramCode.restore();
	}
	
}
