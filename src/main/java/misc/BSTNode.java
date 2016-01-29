package misc;

public class BSTNode {
    BSTNode left;
    BSTNode right;
    Integer key;
    BSTNode parent;

    public BSTNode(Integer key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BSTNode bstNode = (BSTNode) o;

        return key.equals(bstNode.key);

    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public String toString() {
        return "BSTNode{" +
                "key=" + key +
                '}';
    }
}
