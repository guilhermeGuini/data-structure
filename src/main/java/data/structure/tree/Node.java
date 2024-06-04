package data.structure.tree;

import java.util.Optional;

public class Node {

    protected Node root;
    protected Node left;
    protected Node right;
    protected Integer value;

    public Node(Integer value) {
        this.value = value;
    }

    public static Node create(Integer value) {
        return new Node(value);
    }

    public void setRoot(Node node) {
        this.root = node;
    }

    public void setChildRight(Node node) {
        this.right = node;
    }

    public void setChildLeft(Node node) {
        this.left = node;
    }

    public Optional<Node> getChildRight() {
        return Optional.ofNullable(right);
    }

    public Optional<Node> getChildLeft() {
        return Optional.ofNullable(left);
    }

    public Integer getValue() {
        return value;
    }
}
