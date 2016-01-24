package misc;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void testTreeConstruction() {
        BSTNode root = new BSTNode(15);
        BinarySearchTree tree = new BinarySearchTree(root);
        tree.add(new BSTNode(30));
        tree.add(new BSTNode(7));
        tree.add(new BSTNode(3));
        tree.add(new BSTNode(10));
        tree.add(new BSTNode(40));
        tree.add(new BSTNode(23));
        tree.add(new BSTNode(25));

        int expectedHeight = 4;
        int actualHeight = tree.height();
        Assert.assertEquals(expectedHeight, actualHeight);
        System.out.println(tree);
    }
}
