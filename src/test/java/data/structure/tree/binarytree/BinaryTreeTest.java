package data.structure.tree.binarytree;

import data.structure.tree.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {

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
    @Test
    public void givenTreeWhenFindParentNodeForValueShouldFoundTargetNode() {
        BinaryTree tree = createTree();

        Node targetNode = tree.findParentNode(tree.getRoot(), 3);
        assertEquals(2, targetNode.getValue().intValue());
    }

    @Test
    public void showAsc() {
        createTree().showAsc();
    }

    @Test
    public void showDesc() {
        createTree().showDesc();
    }

    @Test
    public void showCool() {
        createTree().showCool();
    }

    public BinaryTree createTree() {
        return BinaryTree.create(8).add(4)
            .add(2)
            .add(5)
            .add(1)
            .add(11)
            .add(13)
            .add(9);
    }

}