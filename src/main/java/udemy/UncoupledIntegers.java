package udemy;

import org.junit.Assert;

import java.util.LinkedHashSet;
import java.util.Set;

public class UncoupledIntegers {

    public static void main(String[] args) {
        Assert.assertEquals(1, uncoupledIntegers(new int[]{1, 2, 2}));
        Assert.assertEquals(-1, uncoupledIntegers(new int[]{2, 2}));
        Assert.assertEquals(1, uncoupledIntegers(new int[]{2, 1, 2}));
        Assert.assertEquals(1, uncoupledIntegers(new int[]{2, 2, 1}));
        Assert.assertEquals(5, uncoupledIntegers(new int[]{2, 7, 2, 8, 5, 1, 1, 7, 8}));
        Assert.assertEquals(1, uncoupledIntegersBitwise(new int[]{1, 2, 2}));
        Assert.assertEquals(-1, uncoupledIntegersBitwise(new int[]{2, 2}));
        Assert.assertEquals(1, uncoupledIntegersBitwise(new int[]{2, 1, 2}));
        Assert.assertEquals(1, uncoupledIntegersBitwise(new int[]{2, 2, 1}));
        Assert.assertEquals(5, uncoupledIntegersBitwise(new int[]{2, 7, 2, 8, 5, 1, 1, 7, 8}));

    }

    // O(n) time, O(n) space - basic solution
    public static int uncoupledIntegers(int[] input) {
        if (input == null) return -1;

        Set<Integer> seen = new LinkedHashSet<>(input.length);

        for (int i : input) {
            if (seen.contains(i))
                seen.remove(i);
            else
                seen.add(i);
        }
        return seen.size() == 1 ? seen.iterator().next() : -1;
    }

    public static int uncoupledIntegersBitwise(int[] input) {
        if (input == null) return -1;

        int result = 0;
        for (int i : input) {
            result = i ^ result; // works either way
        }
        return result != 0 ? result : -1;
    }
}
