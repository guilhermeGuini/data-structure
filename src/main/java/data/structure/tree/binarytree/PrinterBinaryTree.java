package data.structure.tree.binarytree;

import data.structure.tree.Node;
import data.structure.tree.Order;
import data.structure.tree.Printable;

/**
 * Tree:
 * 8
 * /   \
 * /     \
 * 4       11
 * /  \    /  \
 * 2    5  9   13
 * /
 * 1   3?
 */
public class PrinterBinaryTree implements Printable<Node> {

    @Override
    public void print(Node node, Order order) {

        System.out.println("#####################################");
        System.out.println("#     BINARY TREE " + order);
        System.out.println("#####################################");

        switch (order) {
            case ASC:
                new PrinterBinaryTreeAsc().print(node, order);
                break;
            case DESC:
                new PrinterBinaryTreeDesc().print(node, order);
                break;
            case COOL:
                new PrinterBinaryTreeCool().print(node, order);
                break;
            default:
                throw new IllegalArgumentException("Invalid order: " + order);
        }
        System.out.println();
    }
}