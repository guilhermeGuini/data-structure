package data.structure.tree.binarytree;

import data.structure.tree.Node;
import data.structure.tree.Order;

public class BinaryTree {

    private final Node root;

    private BinaryTree(Integer value) {
        this.root = new Node(value);
    }

    public static BinaryTree create(Integer value) {
        return new BinaryTree(value);
    }

    public BinaryTree add(Integer value) {
        Node parentNode = findParentNode(root, value);

        if (value > parentNode.getValue()) {
            parentNode.setChildRight(Node.create(value));

        } else {
            parentNode.setChildLeft(Node.create(value));
        }

        return this;
    }

    Node findParentNode(Node node, Integer value) {

        if (isTargetNode(value, node)) {
            return node;
        }

        if (value < node.getValue()) {
            return findParentNode(node.getChildLeft().orElse(null), value);
        } else {
            return findParentNode(node.getChildRight().orElse(null), value);
        }
    }

    private boolean isTargetNode(Integer value, Node node) {
        return (value < node.getValue() && node.getChildLeft().isEmpty()) ||
            (value > node.getValue() && node.getChildRight().isEmpty());
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
        new PrinterBinaryTree().print(root, order);
    }

    public Node getRoot() {
        return root;
    }
}
