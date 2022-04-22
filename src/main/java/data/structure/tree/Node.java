package data.structure.tree;

import java.util.Optional;

public abstract class Node {

    protected Node root;

    public void setChildRight(Node node) {
        root.setChildRight(node);
    }

    public void setChildLeft(Node node) {
        root.setChildLeft(node);
    }

    public Optional<Node> getChildRight() {
        return Optional.ofNullable(node.get)
    }

    @Override
    public Optional<Node> getChildLeft() {
            return Optional.empty();
            }

    @Override
    public Integer getValue() {
            return null;
            }
}
