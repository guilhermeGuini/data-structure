package data.structure.tree.binarytree;

import data.structure.tree.Order;
import data.structure.tree.Printable;
import org.apache.commons.lang3.StringUtils;

/**
 * 
 *  Tree:
 *               8
 *             /   \
 *            /     \    
 *           4       11 
 *          /  \    /  \
 *         2    5  9   13
 *        / 
 *       1   3?
 *
 */
public class PrinterBynaryTree implements Printable<BinaryTreeNode> {

	@Override
	public void print(BinaryTreeNode node, Order order) {
		
		System.out.println("#####################################");
		System.out.println("#     BINARY TREE "  + order);
		System.out.println("#####################################");
		
		switch (order) {
		case ASC:
			printAsc(node);
			break;

		case DESC:
			printDesc(node);
			break;
			
		case COOL:
			printCool(node, 10);
			break;
		
		default:
			throw new IllegalArgumentException("Invalid order: " + order);
		}
		
		System.out.println();
	}

	private void printCool(BinaryTreeNode node, Integer spaces) {
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

	private void printAsc(BinaryTreeNode node) {
		
		if (node == null) {
			return;
		}
		
		printAsc(node.getChildLeft().orElse(null));
		System.out.println(node.getValue());
		printAsc(node.getChildRight().orElse(null));
	}

	private void printDesc(BinaryTreeNode node) {

		if (node == null) {
			return;
		}
		
		printDesc(node.getChildRight().orElse(null));
		System.out.println(node.getValue());
		printDesc(node.getChildLeft().orElse(null));
	}

}
