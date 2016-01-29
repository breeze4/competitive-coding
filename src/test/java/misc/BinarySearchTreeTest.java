package misc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTreeTest {

    BinarySearchTree tree;
    BSTNode root = new BSTNode(15);
    BSTNode THIRTY = new BSTNode(30);
    BSTNode SEVEN = new BSTNode(7);
    BSTNode THREE = new BSTNode(3);
    BSTNode TEN = new BSTNode(10);
    BSTNode FORTY = new BSTNode(40);
    BSTNode TWENTY_THREE = new BSTNode(23);
    BSTNode TWENTY_FIVE = new BSTNode(25);

    @Before
    public void setUp() {
        tree = new BinarySearchTree(root);
        tree.add(THIRTY);
        tree.add(SEVEN);
        tree.add(THREE);
        tree.add(TEN);
        tree.add(FORTY);
        tree.add(TWENTY_THREE);
        tree.add(TWENTY_FIVE);
    }

    @Test
    public void testInOrderIterator() {
        int expectedHeight = 4;
        int actualHeight = tree.height();
        Assert.assertEquals(expectedHeight, actualHeight);
        System.out.println(tree);

        List<BSTNode> actualInOrderNodes = new ArrayList<>();
        Iterator<BSTNode> treeIterator = tree.iterator();
        while (treeIterator.hasNext()) {
            actualInOrderNodes.add(treeIterator.next());
        }
        List<BSTNode> expectedInOrderNodes = Arrays.asList(THREE, SEVEN, TEN,
                root, TWENTY_THREE, TWENTY_FIVE, THIRTY, FORTY);
        for (int i = 0; i < expectedInOrderNodes.size(); i++) {
            BSTNode expectBstNode = expectedInOrderNodes.get(i);
            BSTNode actualBstNode = actualInOrderNodes.get(i);
            Assert.assertEquals(expectBstNode, actualBstNode);
        }
    }

    @Test
    public void testInOrderTraversal() {
        int expectedHeight = 4;
        int actualHeight = tree.height();
        Assert.assertEquals(expectedHeight, actualHeight);
        System.out.println(tree);

        List<BSTNode> actualInOrderNodes = BinarySearchTree.inorderTraversal(root);
        List<BSTNode> expectedInOrderNodes = Arrays.asList(THREE, SEVEN, TEN,
                root, TWENTY_THREE, TWENTY_FIVE, THIRTY, FORTY);
        for (int i = 0; i < expectedInOrderNodes.size(); i++) {
            BSTNode expectBstNode = expectedInOrderNodes.get(i);
            BSTNode actualBstNode = actualInOrderNodes.get(i);
            Assert.assertEquals(expectBstNode, actualBstNode);
        }
    }
}
