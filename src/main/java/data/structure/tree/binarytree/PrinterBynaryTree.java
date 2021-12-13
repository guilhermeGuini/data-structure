package data.structure.tree.binarytree;

import java.util.Optional;

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
public class PrinterBynaryTree implements Printable<Optional<Node>> {

	@Override
	public void print(Optional<Node> node, Order order) {
		
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

	private void printCool(Optional<Node> node, Integer spaces) {
		if (!node.isPresent()) {
			return;
		}
		
		System.out.println(StringUtils.repeat(' ', spaces) + node.get().getValue());
		
		if (node.get().getChildLeft().isPresent()) {
			System.out.println(StringUtils.repeat(' ', spaces - 1) + "/");
		}
		
		printCool(node.get().getChildLeft(), spaces - 2);
		printCool(node.get().getChildRight(), spaces + 2);
	}

	private void printAsc(Optional<Node> node) {
		
		if (!node.isPresent()) {
			return;
		}
		
		printAsc(node.get().getChildLeft());
		System.out.println(node.get().getValue());
		printAsc(node.get().getChildRight());
	}

	private void printDesc(Optional<Node> node) {

		if (!node.isPresent()) {
			return;
		}
		
		printDesc(node.get().getChildRight());
		System.out.println(node.get().getValue());
		printDesc(node.get().getChildLeft());
	}

}
