package udemy;

import org.junit.Assert;

import java.util.Stack;

public class MinTrackingStack<T extends Comparable<T>> extends Stack<T> {

    public static void main(String[] args) {
        MinTrackingStack<Integer> sk = new MinTrackingStack<>();

        sk.push(5);
        sk.push(4);
        sk.push(2);
        Assert.assertEquals(new Integer(2), sk.getMinimum());
        sk.push(1);
        Assert.assertEquals(new Integer(1), sk.getMinimum());
        sk.push(3);
        Assert.assertEquals(new Integer(1), sk.getMinimum());
        sk.pop();
        sk.pop();
        sk.pop();
        Assert.assertEquals(new Integer(4), sk.getMinimum());
    }

    Stack<T> mins = new Stack<T>();

    @Override
    public T pop() {
        T popped = super.pop();
        if (popped.equals(mins.peek()))
            mins.pop();
        return popped;
    }

    @Override
    public T push(T object) {
        if (mins.isEmpty() || object.compareTo(mins.peek()) < 0) {
            mins.push(object);
        }
        return super.push(object);
    }

    T getMinimum() {
        return mins.isEmpty() ? null : mins.peek();
    }
}
