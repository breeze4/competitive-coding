package leetcode;

import java.time.Instant;
import java.util.Timer;

public class LongestPalindrome {


    // https://leetcode.com/problems/longest-palindromic-substring/

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
//        System.out.println("actual: " + lp.longestPalindrome("aba"));
//        System.out.println("expected: " + "aba");
//        System.out.println("actual: " + lp.longestPalindrome("abac"));
//        System.out.println("expected: " + "aba");
//        System.out.println("actual: " + lp.longestPalindrome("adccdedada"));
//        System.out.println("expected: " + "dccd");
//        System.out.println("actual: " + lp.longestPalindrome("aabxybba"));
//        System.out.println("expected: " + "bb");
//        System.out.println("actual: " + lp.longestPalindrome("abcba"));
//        System.out.println("expected: " + "abcba");
        System.out.println("actual: " + lp.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println("expected: " + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

    }

    public String longestPalindrome(String str) {
        char[] in = str.toCharArray();
        int maxLength = 0;
        int maxHead = 0;

        for (int i = 0; i < in.length; i++) {
            int resultLength = findLongestPalindromeStartingWith(in, i);
            if (resultLength > maxLength) {
                maxLength = resultLength;
                maxHead = i;
            }
        }

        return str.substring(maxHead, maxHead + maxLength);
    }

    private int findLongestPalindromeStartingWith(char[] in, int start) {
        int maxLength = 0;
        int head = start;
        int tail = in.length - 1;

        int nextTail = tail;
        boolean palindrome = false;

        while (head <= tail) {
            if (head + 1 == tail && palindrome && in[head] == in[tail]) { // even number of digits
                maxLength = nextTail - start + 1;
                return maxLength;
            } else if(head == tail && palindrome) { // odd number of digits
                maxLength = nextTail - start + 1;
                return maxLength;
            }
            else if ((head + 1 == tail || head == tail) && !palindrome) {
                return -1;
            } else if (in[head] == in[tail]) {
                head++;
                tail--;
                palindrome = true;
            } else {
                head = start;
                tail = nextTail - 1;
                nextTail = tail;
            }
        }
        return -1;
    }
}
