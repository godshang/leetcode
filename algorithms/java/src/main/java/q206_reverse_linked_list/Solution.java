package q206_reverse_linked_list;

import common.ListNode;
import common.Util;

public class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = Util.buildList(new int[]{1, 2, 3, 4, 5});
        Util.printList(solution.reverseListRecursive(head));
    }
}
