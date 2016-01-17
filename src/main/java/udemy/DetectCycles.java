package udemy;

import org.junit.Assert;

import java.util.Objects;

public class DetectCycles {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
        ListNode six = new ListNode(6);
        five.next = six;
        six.next = three;

        ListNode head = one;

        Assert.assertEquals(true, detectCycleRecursive(head));
        Assert.assertEquals(false, detectCycleRecursive(new ListNode(1)));
        Assert.assertEquals(true, detectCycle(head));
        Assert.assertEquals(false, detectCycle(new ListNode(1)));
    }

    private static boolean detectCycle(ListNode head) {
        if (head == null) return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && slow != null) {
            fast = fast.next;
            fast = fast != null ? fast.next : null;

            slow = slow.next;

            if (Objects.equals(fast, slow) && fast != null) return true;
        }
        return false;
    }

    private static boolean detectCycleRecursive(ListNode head) {
        return detectCycle(head.next, head);
    }

    private static boolean detectCycle(ListNode fast, ListNode slow) {
        if (fast == null || slow == null) return false;
        else if (Objects.equals(fast, slow)) return true;
        else return detectCycle(fast.next != null ? fast.next.next : null, slow.next);
    }
}
