package wacc.tree.nodes;

import java.util.LinkedList;
import java.util.List;

import wacc.tree.Node;

public class FunctionNode extends Node {
	
	private final String name;

	public FunctionNode(String name, Node ... args) {
		this.name = name;
		for (Node arg : args) {
			addChild(arg);
		}
	}

	@Override
	public void generate() {
		// TODO Auto-generated method stub
	}
	
}
