package leetcode;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GenerateValidParentheses {

    public static void main(String[] args) {

        GenerateValidParentheses g = new GenerateValidParentheses();

        Set<String> expected = new LinkedHashSet<>();
        expected.add("((()))");
        expected.add("(()())");
        expected.add("(())()");
        expected.add("()(())");
        expected.add("()()()");

        Set<String> actual = new LinkedHashSet<>(g.generateParenthesis(3));

        Assert.assertEquals(expected.size(), actual.size());
        Assert.assertTrue(expected.containsAll(actual));
        Assert.assertTrue(actual.containsAll(expected));
    }

    public List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        genParens(out, "", 0, 0, n);
        return out;
    }

    private void genParens(List<String> out, String src, int open, int close, int pairs) {
        if (src.length() == pairs * 2)
            out.add(src);

        if (open < pairs)
            genParens(out, src + "(", open + 1, close, pairs);
        if (close < open)
            genParens(out, src + ")", open, close + 1, pairs);
    }
}
