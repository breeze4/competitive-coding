package leetcode;

import java.util.Stack;

public class MinStack {

    private final Stack<Tuple> stack = new Stack<>();

    public void push(int x) {
        if (stack.isEmpty()) {
            int currMin = x;
            stack.push(new Tuple(x, currMin));
        } else {
            int currMin = stack.peek().min;
            if (x < currMin) {
                stack.push(new Tuple(x, x));
            } else {
                stack.push(new Tuple(x, currMin));
            }
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }

    class Tuple {
        int value;
        int min;

        Tuple(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}
