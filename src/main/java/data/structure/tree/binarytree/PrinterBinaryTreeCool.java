package data.structure.tree.binarytree;

import data.structure.tree.Node;
import data.structure.tree.Order;
import data.structure.tree.Printable;
import org.apache.commons.lang3.StringUtils;

public class PrinterBinaryTreeCool implements Printable<Node> {

    @Override
    public void print(Node node, Order order) {
        printCool(node, 10);
    }

    private void printCool(Node node, Integer spaces) {
        if (node == null) {
            return;
        }

        System.out.println(StringUtils.repeat(' ', spaces) + node.getValue());

        if (node.getChildLeft().isPresent()) {
            System.out.println(StringUtils.repeat(' ', spaces - 1) + "/");
        }

        printCool(node.getChildLeft().orElse(null), spaces - 2);
        printCool(node.getChildRight().orElse(null), spaces + 2);
    }
}
