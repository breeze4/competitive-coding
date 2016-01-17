package misc;

import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class WordRank {

    public static void main(String[] args) {
        Assert.assertEquals(1, rankWord("A"));
        Assert.assertEquals(1, rankWord("AB"));
        Assert.assertEquals(2, rankWord("BA"));
        Assert.assertEquals(1, rankWord("ACT"));
        Assert.assertEquals(2, rankWord("ATC"));
        Assert.assertEquals(3, rankWord("CAT"));
        Assert.assertEquals(4, rankWord("CTA"));
        Assert.assertEquals(5, rankWord("TAC"));
        Assert.assertEquals(6, rankWord("TCA"));
        Assert.assertEquals(309, rankWord("MOTHER"));
    }

    private static int rankWord(String cat) {
        Set<Character> seen = new LinkedHashSet<>();
        boolean counted = false;
        int searchIdx = 0;
        int sortedIdx = 0;
        char[] words = cat.toCharArray();
        int L = words.length;
        char[] sorted = Arrays.copyOf(words, L);
        Arrays.sort(sorted);

        int count = 0;
        while (!counted) {
            if (searchIdx == L) {
                count++;
                counted = true;
                break;
            }

            Character search = words[searchIdx];
            Character testWord = sorted[sortedIdx];
            if (testWord < search && !seen.contains(testWord)) {
                count += factorial(L - 1 - searchIdx);
                sortedIdx++;
            } else if (testWord < search) {
                sortedIdx++;
            } else {
                seen.add(search);
                searchIdx++;
                sortedIdx = 0;
            }
        }

        return count;
    }

    public static int factorial(int n) {
        int factorial = 1;
        int counter = n;
        while (counter > 0) {
            factorial *= counter--;
        }
        return factorial;
    }
}
