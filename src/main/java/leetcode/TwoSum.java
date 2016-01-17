package leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TwoSum {

    // https://leetcode.com/problems/two-sum/

    public static void main(String[] args) {
        System.out.println("actual: " + Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println("expected: " + Arrays.toString(new int[]{2, 3}));
        System.out.println("actual: " + Arrays.toString(twoSum(new int[]{1, 3, 2, 4}, 5)));
        System.out.println("expected: " + Arrays.toString(new int[]{1, 4}));
        System.out.println("actual: " + Arrays.toString(twoSum(new int[]{1, 3, 2, 3}, 6)));
        System.out.println("expected: " + Arrays.toString(new int[]{2, 4}));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valToIndex = new LinkedHashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = target - current;
            if (valToIndex.containsKey(complement)) {
                return new int[]{valToIndex.get(complement), i + 1};
            }
            valToIndex.put(current, i + 1);
        }
        return new int[]{};
    }
}
