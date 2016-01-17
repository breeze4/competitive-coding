package ch1_arrays_and_strings;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ch1_1 {

    public static void main(String[] args) {
        System.out.println(hasAllUnique("abcde"));
        System.out.println(hasAllUnique("abcdee"));
        System.out.println(hasAllUnique("abbcde"));
        System.out.println(hasAllUnique_Alt1("abcde"));
        System.out.println(hasAllUnique_Alt1("abcdee"));
        System.out.println(hasAllUnique_Alt1("abbcde"));
        System.out.println(hasAllUnique_Alt2("abcde"));
        System.out.println(hasAllUnique_Alt2("abcdee"));
        System.out.println(hasAllUnique_Alt2("abbcde"));
    }

    // O(n) time, O(n) extra memory
    public static boolean hasAllUnique(String str) {
        Set<Character> chars = new LinkedHashSet<>();
        for (Character c : str.toCharArray()) {
            if (chars.contains(c)) {
                return false;
            } else {
                chars.add(c);
            }
        }
        return true;
    }

    // O(n log n), could be done in place except toCharArray makes a copy and
    // strings are immutable in Java
    public static boolean hasAllUnique_Alt1(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            if (i + 1 == chars.length) {
                return true;
            } else {
                char next = chars[i + 1];
                if (curr == next) {
                    return false;
                }
            }
        }
        return true;
    }

    // O(n^2) time, could be done in place except toCharArray makes a copy and
    // strings are immutable in Java
    public static boolean hasAllUnique_Alt2(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1) {
                return true; // break or return true here
            }
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
