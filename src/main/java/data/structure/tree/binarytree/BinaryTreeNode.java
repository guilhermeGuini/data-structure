package data.structure.tree.binarytree;

import data.structure.tree.Node;

import java.util.Optional;

public class BinaryTreeNode implements Node {



//	private final Integer value;
//
//	private Node childLeft;
//	private Node childRight;
//
//	private BinaryTreeNode(Integer value) {
//		this.value = value;
//	}
//
//	public static Node create(Integer value) {
//		return new BinaryTreeNode(value);
//	}
//
//	@Override
//	public void setChildRight(Node node) {
//		this.childRight = node;
//	}
//
//	@Override
//	public void setChildLeft(Node node) {
//		this.childLeft = node;
//	}
//
//	public Optional<Node> getChildLeft() {
//		return Optional.ofNullable(childLeft);
//	}
//
//	public Optional<Node> getChildRight() {
//		return Optional.ofNullable(childRight);
//	}
//
//	public Integer getValue() {
//		return value;
//	}
//
//	public boolean isLeaf() {
//		return getChildLeft().isEmpty() && getChildRight().isEmpty();
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((value == null) ? 0 : value.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (obj == null || obj.getClass() != getClass()) {
//			return false;
//		}
//
//		return this.value.equals(((BinaryTreeNode)obj).getValue());
//	}
//
//	@Override
//	public String toString() {
//		return "Node [value=" + value + ", childLeft=" + childLeft + ", childRight=" + childRight + "]";
//	}

}
