package udemy;

import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class TargetTwoSum {

    public static void main(String[] args) {
        Assert.assertEquals(true, sumExists_Set(7, new int[]{3, 2, 1, 5, 7}));
        Assert.assertEquals(true, sumExists_Set(0, new int[]{3, 2, -3, 4}));
        Assert.assertEquals(false, sumExists_Set(5, new int[]{}));
        Assert.assertEquals(false, sumExists_Set(0, new int[]{0}));
        Assert.assertEquals(true, sumExists_Pointers(7, new int[]{3, 2, 1, 5, 7}));
        Assert.assertEquals(true, sumExists_Pointers(0, new int[]{3, 2, -3, 4}));
        Assert.assertEquals(false, sumExists_Pointers(5, new int[]{}));
        Assert.assertEquals(false, sumExists_Pointers(0, new int[]{0}));

    }

    // O(n) time, O(n) space
    public static boolean sumExists_Set(int target, int[] nums) {
        if (nums == null || nums.length <= 1) return false;

        Set<Integer> numSet = new LinkedHashSet<>();
        for (int x : nums) {
            int comp = target - x;
            if (numSet.contains(comp)) return true;
            else numSet.add(x);
        }

        return false;
    }

    // O(n log n + n) time -> O(n log n), O(1) space
    public static boolean sumExists_Pointers(int target, int[] nums) {
        if (nums == null) return false;

        Arrays.sort(nums);

        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            if (nums[head] + nums[tail] < target) head++;
            else if (nums[head] + nums[tail] > target) tail--;
            else return true;
        }
        return false;
    }
}
