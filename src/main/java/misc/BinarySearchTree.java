package misc;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringJoiner;

public class BinarySearchTree {
    private BSTNode root;

    public BinarySearchTree(BSTNode root) {
        this.root = root;
    }

    public BSTNode get(int key) {
        return search(root, key);
    }

    private BSTNode search(BSTNode node, int key) {
        if (node == null)
            return null;
        else {
            if (node.key == key) return node;
            else if (key < node.key) return search(node.left, key);
            else return search(node.right, key);
        }
    }

    public void add(BSTNode node) {
        if (node == null) {
            throw new IllegalArgumentException("cannot add a null node");
        }
        insert(root, node);
    }

    private void insert(BSTNode root, BSTNode node) {
        if (node.key <= root.key) {
            if (root.left == null)
                root.left = node;
            else
                insert(root.left, node);
        } else {
            if (root.right == null)
                root.right = node;
            else
                insert(root.right, node);
        }
    }

    @Override
    public String toString() {
        List<String> levelStrings = breadthFirstTraversal(root);
        StringJoiner sj = new StringJoiner("\n");
        levelStrings.forEach(levelStr -> sj.add(levelStr));
        return sj.toString();
    }

    private static final BSTNode SPACER = new BSTNode(null);

    private List<String> breadthFirstTraversal(BSTNode root) {
        if (root == null)
            throw new IllegalArgumentException("cannot print a null tree");

        int height = calculateTreeHeight(root);
        List<String> result = new ArrayList<>(height);
        StringBuilder sb = new StringBuilder();
        Queue<BSTNode> nodes = new LinkedList<BSTNode>();
        nodes.offer(root);

        int depth = 0;
        int nextLevel = 1;
        int nodeCount = 0;
        while (depth < height) {
            BSTNode curr = nodes.poll();
            if (curr.left != null) nodes.offer(curr.left);
            else nodes.offer(SPACER);
            if (curr.right != null) nodes.offer(curr.right);
            else nodes.offer(SPACER);

            String nodeStr = generateNodeString(curr, height, depth);
            sb.append(nodeStr);
            nodeCount++;
            if (nodeCount == nextLevel) {
                result.add(depth, sb.toString());
                depth++;
                nextLevel = (nextLevel + 1) * 2 - 1;
                sb.delete(0, sb.length());
            }
        }

        return result;
    }

    private String generateNodeString(BSTNode curr, int height, int depth) {
        StringBuilder sb = new StringBuilder();
        int offset = geoSum(height - depth);
        for(int i = 0; i < offset; i++) {
            sb.append(" ");
        }
        sb.append(curr.key != null ? curr.key.toString() : " ");
        for(int i = 0; i < offset; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private int geoSum(int n) {
        return n * (n + 1) / 2;
    }

    public int height() {
        return calculateTreeHeight(root);
    }

    private int calculateTreeHeight(BSTNode root) {
        return calculateHeight(root, 0);
    }

    private int calculateHeight(BSTNode root, int depth) {
        if (root == null) return 0;

        int leftHeight = calculateHeight(root.left, depth);
        int rightHeight = calculateHeight(root.right, depth);

        if (leftHeight > rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;
    }
}
