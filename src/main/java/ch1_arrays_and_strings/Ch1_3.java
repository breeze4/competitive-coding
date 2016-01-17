package ch1_arrays_and_strings;

import java.util.Arrays;

public class Ch1_3 {

    public static void main(String[] args) {
        System.out.println(isPermutation("abc", "cba"));
        System.out.println(isPermutation("abc", "cbaa"));
        System.out.println(isPermutation("abc", "ccba"));
        System.out.println(isPermutation("abcc", "ccba"));
    }

    public static boolean isPermutation(String original, String permutation) {
        if (original == null || permutation == null || original.length() != permutation.length()) {
            return false;
        }
        char[] origChars = original.toCharArray();
        char[] permChars = permutation.toCharArray();
        Arrays.sort(origChars);
        Arrays.sort(permChars);
        return new String(origChars).equals(new String(permChars));
    }
}
