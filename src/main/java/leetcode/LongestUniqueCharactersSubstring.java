package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestUniqueCharactersSubstring {

    public static void main(String[] args) {
        LongestUniqueCharactersSubstring ls = new LongestUniqueCharactersSubstring();
//        System.out.println("actual: " + ls.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println("expected: " + 3);
//        System.out.println("actual: " + ls.lengthOfLongestSubstring("abcabcdebb"));
//        System.out.println("expected: " + 5);
//        System.out.println("actual: " + ls.lengthOfLongestSubstring("c"));
//        System.out.println("expected: " + 1);
//        System.out.println("actual: " + ls.lengthOfLongestSubstring("ac"));
//        System.out.println("expected: " + 2);
//        System.out.println("actual: " + ls.lengthOfLongestSubstring("dvdf"));
//        System.out.println("expected: " + 3);
//        System.out.println("actual: " + ls.lengthOfLongestSubstring("pwwkew"));
//        System.out.println("expected: " + 3);
//        System.out.println("actual: " + ls.lengthOfLongestSubstring("abba"));
//        System.out.println("expected: " + 2);
        System.out.println("actual: " + ls.lengthOfLongestSubstring("abcbaabcbaacbbaabbcabbabcbaab"));
        System.out.println("expected: " + 3);
//        System.out.println("actual: " + ls.lengthOfLongestSubstring("ohvhjdml"));
//        System.out.println("expected: " + 6);
    }

    public int lengthOfLongestSubstring(String input) {
        if (input == null) {
            return -1;
        } else if (input.length() <= 1) {
            return input.length();
        }
        char[] in = input.toCharArray();
        int length = 0;
        int maxLength = 0;
        Map<Character, Integer> uniqueIndexes = new LinkedHashMap<>();

        int head = 0;
        for (int tail = 0; tail < in.length; tail++) {
            char current = in[tail];
            if (!uniqueIndexes.containsKey(current)) {
                uniqueIndexes.put(current, tail);
                length++;
            } else {
                if (length > maxLength) maxLength = length;

                char oldHead = in[head];
                head = Math.max(uniqueIndexes.get(current) + 1, head);
                uniqueIndexes.remove(oldHead);
                length = tail - head + 1;
                uniqueIndexes.put(current, tail);
            }
        }

        if (length > maxLength) maxLength = length;

        return maxLength;
    }

    public int lengthOfLongestSubstring1(String input) {
        if (input == null) {
            return -1;
        } else if (input.length() <= 1) {
            return input.length();
        }
        char[] in = input.toCharArray();
        int length = 0;
        int maxLength = 0;

        Map<Character, Integer> uniqueIndexes = new LinkedHashMap<>();
        for (int i = 0; i < in.length; i++) {
            char current = in[i];
            if (!uniqueIndexes.containsKey(current)) {
                uniqueIndexes.put(current, i);
                length++;
            } else {

                if (length > maxLength) {
                    // not a unique character and the substring was longer than the last longest
                    maxLength = length;
                }

                int startIndex = uniqueIndexes.get(current);
                for (int j = startIndex; j >= i - length; j--) {
                    if (uniqueIndexes.containsKey(in[j])) {
                        uniqueIndexes.remove(in[j]);
                    }
                }
                length = i - startIndex;
                // replace the existing entry for this letter with the current one
                uniqueIndexes.put(current, i);
            }
        }

        // one last check after the loop finishes
        if (length > maxLength) {
            maxLength = length;
        }

        return maxLength;
    }
}
