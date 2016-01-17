package leetcode;

import java.util.Arrays;

public class AddTwoNumbers {

    // https://leetcode.com/problems/add-two-numbers/

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode expected1 = new ListNode(7);
        expected1.next = new ListNode(0);
        expected1.next.next = new ListNode(8);
        System.out.println("actual: " + addTwoNumbers(l1, l2));
        System.out.println("expected: " + expected1);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(8);
        ListNode l4 = new ListNode(0);
        ListNode expected2 = new ListNode(1);
        expected2.next = new ListNode(8);
        System.out.println("actual: " + addTwoNumbers(l3, l4));
        System.out.println("expected: " + expected2);

        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(5);
        ListNode expected3 = new ListNode(0);
        expected3.next = new ListNode(1);
        System.out.println("actual: " + addTwoNumbers(l5, l6));
        System.out.println("expected: " + expected3);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode out = null;
        ListNode outCurr = null;
        int carry = 0;

        while (curr1 != null || curr2 != null) {
            int sum = (curr1 != null ? curr1.val : 0) + (curr2 != null ? curr2.val : 0) + carry;
            carry = sum >= 10 ? 1 : 0;
            int remainder = sum > 10 ? sum - 10 :
                    (sum == 10 ? 0 : sum);
            if (out == null) {
                out = new ListNode(remainder);
                outCurr = out;
            } else {
                outCurr.next = new ListNode(remainder);
                outCurr = outCurr.next;
            }

            curr1 = curr1 != null ? curr1.next : null;
            curr2 = curr2 != null ? curr2.next : null;
        }

        if (carry != 0) {
            outCurr.next = new ListNode(carry);
        }

        return out;
    }
}
