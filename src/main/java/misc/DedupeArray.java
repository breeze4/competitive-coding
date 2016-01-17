package misc;

import java.util.LinkedHashSet;
import java.util.Set;

public class DedupeArray {

    public static void main(String[] args) {

    }

    public static void dedupe(int[] nums) {
        if(nums == null || nums.length <= 1) return;

        Set<Integer> numSet = new LinkedHashSet<>();
        for(int i : nums) {
            numSet.add(i);
        }
    }
}
