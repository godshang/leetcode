package q143_reorder_list;

import common.ListNode;
import common.Util;

public class Solution {

    public void reorderList(ListNode head) {
        if (head == null) return;

        ListNode middle = middle(head);
        ListNode right = reverse(middle.next);

        middle.next = null;
        merge(head, right);
    }

    private ListNode middle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    private void merge(ListNode left, ListNode right) {
        ListNode leftNext, rightNext;
        while (right != null) {
            leftNext = left.next;
            rightNext = right.next;
            left.next = right;
            right.next = leftNext;
            left = leftNext;
            right = rightNext;
        }
    }

    public static void main(String[] args) {
        ListNode head = Util.buildList(new int[]{1, 2, 3, 4, 5});
        Solution solution = new Solution();
        solution.reorderList(head);
        Util.printList(head);
    }
}
