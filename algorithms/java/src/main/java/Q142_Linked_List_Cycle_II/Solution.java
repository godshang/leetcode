package q142_linked_list_cycle_ii;

import common.ListNode;
import common.Util;

public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        ListNode head = Util.buildList(new int[]{3, 2, 0, -4});
        ListNode tail = Util.findTail(head);
        tail.next = head.next; // cycle

        Solution solution = new Solution();
        ListNode node = solution.detectCycle(head);
        System.out.println(node.val);
    }
}
