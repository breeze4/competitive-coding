package misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Spliterator;
import java.util.StringJoiner;
import java.util.function.Consumer;

public class BinarySearchTree implements Iterable<BSTNode> {
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
            if (root.left == null) {
                root.left = node;
                node.parent = root;
            } else
                insert(root.left, node);
        } else {
            if (root.right == null) {
                root.right = node;
                node.parent = root;
            } else
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
        for (int i = 0; i < offset; i++) {
            sb.append(" ");
        }
        sb.append(curr.key != null ? curr.key.toString() : " ");
        for (int i = 0; i < offset; i++) {
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

    public static List<BSTNode> inorderTraversal(BSTNode root) {
        BSTNode curr = root;
        BSTNode last = null;
        List<BSTNode> out = new ArrayList<>();
        while (curr != null) {
            // go all the way left
            while (curr.left != null && (last == null || last.key.compareTo(curr.left.key) < 0)) {
                curr = curr.left;
            }
            // only "visit" the current node if it hasnt been visited before to prevent adding nodes once as they are
            // traversed and again when they're traversed back via parent pointers
            if (last == null || last.key.compareTo(curr.key) < 0) {
                out.add(curr);
                last = curr;
            }
            // go right if possible, otherwise head back up the tree
            // don't need to check if last is null because before we go right, we will have visited the current node
            if (curr.right != null && last.key.compareTo(curr.right.key) < 0) {
                curr = curr.right;
            } else {
                // when done with iterating, goes back up to the root until null
                curr = curr.parent;
            }
        }
        return out;
    }

    @Override
    public Iterator<BSTNode> iterator() {
        return new InOrderBSTIterator(root);
    }

    @Override
    public void forEach(Consumer<? super BSTNode> action) {
        throw new RuntimeException("not implemented yet");
    }

    @Override
    public Spliterator<BSTNode> spliterator() {
        throw new RuntimeException("not implemented yet");
    }

    class InOrderBSTIterator implements Iterator<BSTNode> {

        private BSTNode curr;
        private BSTNode last = null;

        public InOrderBSTIterator(BSTNode root) {
            this.curr = root;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        private BSTNode moveToNext() {
            BSTNode next = null;
            while (curr != null) {
                // go all the way left
                while (curr.left != null && (last == null || last.key.compareTo(curr.left.key) < 0)) {
                    curr = curr.left;
                }
                // only "visit" the current node if it hasnt been visited before to prevent adding nodes once as they are
                // traversed and again when they're traversed back via parent pointers
                if (last == null || last.key.compareTo(curr.key) < 0) {
                    last = curr;
                    next = curr;
                    break;
                }
                // go right if possible, otherwise head back up the tree
                // don't need to check if last is null because before we go right, we will have visited the current node
                if (curr.right != null && last.key.compareTo(curr.right.key) < 0) {
                    curr = curr.right;
                } else {
                    // when done with iterating, goes back up to the root until null
                    curr = curr.parent;
                }
            }
            return next;
        }

        @Override
        public BSTNode next() {
            return moveToNext();
        }

        @Override
        public void remove() {
            throw new RuntimeException("not implemented yet");
        }

        @Override
        public void forEachRemaining(Consumer<? super BSTNode> action) {
            throw new RuntimeException("not implemented yet");
        }
    }
}
