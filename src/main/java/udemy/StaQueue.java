package udemy;

import org.junit.Assert;

import java.util.Stack;

public class StaQueue<T> {

    public static void main(String[] args) {
        StaQueue<String> sq = new StaQueue<>();
        sq.enqueue("a");
        String a = sq.dequeue();
        Assert.assertEquals("a", a);
        sq.enqueue("b");
        sq.enqueue("c");
        String b = sq.dequeue();
        Assert.assertEquals("b", b);
        String c = sq.dequeue();
        Assert.assertEquals("c", c);
    }

    private final Stack<T> forward = new Stack<>();
    private final Stack<T> reverse = new Stack<>();

    public T dequeue() {
        T current = null;
        while(forward.size() > 1) {
            current = forward.pop();
            reverse.push(current);
        }
        current = forward.pop();
        while(!reverse.isEmpty()) {
            forward.push(reverse.pop());
        }

        return current;
    }

    public void enqueue(T object) {
        forward.push(object);
    }
}
