package leetcode;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Permutations {

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        List<List<Integer>> permutations = solution.permute(new int[]{1, 2, 3});
        List<List<Integer>> expected = asList(asList(1, 2, 3), asList(1, 3, 2), asList(2, 1, 3),
                asList(2, 3, 1), asList(3, 1, 2), asList(3, 2, 1));
        for (int i = 0; i < permutations.size(); i++) {
            List<Integer> exp = expected.get(i);
            List<Integer> act = permutations.get(i);
            Assert.assertArrayEquals(exp.toArray(), act.toArray());
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i : nums) {
            sb.append(i);
        }
        List<String> permutations = permute(sb.toString());
        Collections.sort(permutations);
        List<List<Integer>> result = new ArrayList<>();
        for (String s : permutations)
            result.add(convertStringToIntList(s));
        return result;
    }

    private List<Integer> convertStringToIntList(String s) {
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            String fragment = s.substring(i, i + 1);
            out.add(Integer.parseInt(fragment));
        }
        return out;
    }

    public List<String> permute(String nums) {
        if (nums.length() == 1) return Arrays.asList(nums);
        else {
            int lastIndex = nums.length() - 1;
            String last = nums.substring(lastIndex, nums.length());
            String rest = nums.substring(0, lastIndex);
            List<String> results = merge(permute(rest), last);
            return results;
        }
    }

    private List<String> merge(List<String> nums, String last) {
        List<String> results = new ArrayList<>();
        for (String s : nums) {
            for (int i = 0; i <= s.length(); i++) {
                String permutation = new StringBuffer(s).insert(i, last).toString();
                results.add(permutation);
            }
        }
        return results;
    }

}
