package data.structure.tree.binarytree;

import java.util.Optional;

public class Node {

	private Integer value;
	private Optional<Node> childLeft = Optional.empty();
	private Optional<Node> childRight = Optional.empty();
	private boolean isRoot;

	private Node(Integer value, boolean isRoot) {
		this.value = value;
		this.isRoot = isRoot;
	}
	
	public static Optional<Node> create(Integer value) {
		return Optional.of(new Node(value, false));
	}
	
	public static Optional<Node> createRoot(Integer value) {
		return Optional.of(new Node(value, true));
	}
	
	public void setChildRight(Optional<Node> node) {
		this.childRight = node;
	}
	
	public void setChildLeft(Optional<Node> node) {
		this.childLeft = node;
	}
	
	public Optional<Node> getChildLeft() {
		return childLeft;
	}
	
	public Optional<Node> getChildRight() {
		return childRight;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public boolean isLeaf() {
		return !childLeft.isPresent() && !childRight.isPresent();
	}
	
	public boolean isRoot() {
		return isRoot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != getClass()) {
			return false;
		}
		
		return this.value.equals(((Node)obj).getValue());
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", childLeft=" + childLeft + ", childRight=" + childRight + "]";
	}
}
