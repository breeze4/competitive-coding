package udemy;

import org.junit.Assert;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

//        ListNode reversed = reverse(head);
        ListNode reversed = reverseRecursively(head);
        ListNode expectedHead = new ListNode(3);
        expectedHead.next = new ListNode(2);
        expectedHead.next.next = new ListNode(1);

        System.out.println("expected: " + expectedHead);
        System.out.println("actual: " + reversed);
        Assert.assertEquals(expectedHead, reversed);
    }

    public static ListNode reverse(ListNode head) {
        if (head == null) return null;

        ListNode newHead = null;
        ListNode temp = null;
        ListNode oldHead = head;

        while (oldHead != null) {
            temp = oldHead.next;
            oldHead.next = newHead;
            newHead = oldHead;
            oldHead = temp;
        }

        return newHead;
    }

    public static ListNode reverseRecursively(ListNode head) {
        if (head == null) return null;

        ListNode newHead = reverseLink(null, head);

        return newHead;
    }

    private static ListNode reverseLink(ListNode curr, ListNode next) {
        if (next == null) return curr;

        ListNode temp = next.next;
        next.next = curr;

        return reverseLink(next, temp);
    }
}
