package data.structure.tree.binarytree;

import data.structure.tree.Node;
import data.structure.tree.Order;
import data.structure.tree.Printable;

public class PrinterBinaryTreeDesc implements Printable<Node> {

    @Override
    public void print(Node node, Order order) {
        if (node == null) {
            return;
        }

        print(node.getChildRight().orElse(null), order);
        System.out.println(node.getValue());
        print(node.getChildLeft().orElse(null), order);
    }
}
