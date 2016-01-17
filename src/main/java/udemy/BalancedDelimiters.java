package udemy;

import org.junit.Assert;

import java.util.Stack;

public class BalancedDelimiters {

    public static void main(String[] args) {
        Assert.assertTrue(isOpener("{".charAt(0)));
        Assert.assertTrue(isOpener("[".charAt(0)));
        Assert.assertTrue(isOpener("(".charAt(0)));
        Assert.assertTrue(isMatching(")".charAt(0), "(".charAt(0)));
        Assert.assertTrue(isMatching("]".charAt(0), "[".charAt(0)));
        Assert.assertTrue(isMatching("}".charAt(0), "{".charAt(0)));
        System.out.println("testing problem");
        Assert.assertTrue(isBalanced("[]({[]}){()}"));
        Assert.assertFalse(isBalanced("([)]"));
        Assert.assertFalse(isBalanced(")]"));
    }

    public static boolean isBalanced(String str) {
        if (str == null) return true;

        char[] input = str.toCharArray();
        char latest;
        Stack<Character> stack = new Stack<>();

        boolean isBalanced = true;
        int i = 0;
        while (isBalanced && i < input.length) {
            latest = input[i];

            if (isOpener(latest)) {
                stack.push(latest);
            } else if (!stack.isEmpty()) {
                char previous = stack.pop();
                isBalanced = isMatching(latest, previous);
            } else {
                isBalanced = false;
            }
            i++;
        }

        return isBalanced;
    }

    private static boolean isOpener(char delimiter) {
        return delimiter == "{".charAt(0) || delimiter == "[".charAt(0) || delimiter == "(".charAt(0);
    }

    private static boolean isMatching(char delim1, char delim2) {
        return delim2 == "{".charAt(0) && delim1 == "}".charAt(0)
                || delim2 == "[".charAt(0) && delim1 == "]".charAt(0)
                || delim2 == "(".charAt(0) && delim1 == ")".charAt(0);
    }
}
