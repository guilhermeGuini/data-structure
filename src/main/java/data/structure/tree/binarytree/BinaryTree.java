package data.structure.tree.binarytree;

import java.util.Optional;

public class BinaryTree {

	Optional<Node> root;
	
	private BinaryTree(Integer value) {
		valid(value);
		root = Node.createRoot(value);
	}
	
	public static BinaryTree create(Integer value) {
		return new BinaryTree(value);
	}
	
	public BinaryTree add(Integer value) {
		valid(value);
		
		Node parentNode = findParentNode(root, value);
		
		if (value > parentNode.getValue()) {
			parentNode.setChildRight(Node.create(value));
			
		} else {
			parentNode.setChildLeft(Node.create(value));
		}
		
		return this;
	}
	
	private void valid( Integer value) {
		if (value == null) {
			throw new IllegalArgumentException("Value is required");
		}
	}
	
	Node findParentNode(Optional<Node> node, Integer value) {
		
		if (isTargetNode(value, node.get())) {
			return node.get();
		}	
		
		if (value < node.get().getValue()) {
			return findParentNode(node.get().getChildLeft(), value);
		} else {
			return findParentNode(node.get().getChildRight(), value);
		}
	}

	private boolean isTargetNode(Integer value, Node node) {
		return (value < node.getValue() && !node.getChildLeft().isPresent()) ||
			   (value > node.getValue() && !node.getChildRight().isPresent());
	}

	public void showAsc() {
		show(Order.ASC);
	}
	
	public void showDesc() {
		show(Order.DESC);
	}
	
	public void showCool() {
		show(Order.COOL);
	}
	
	private void show(Order order) {
		new PrinterBynaryTree().print(root, order);
	}
	
}