package q141_linked_list_cycle;

import common.ListNode;

public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode h1 = new ListNode(3);
        h1.next = new ListNode(2);
        h1.next.next = new ListNode(0);
        h1.next.next.next = new ListNode(-4);
        h1.next.next.next.next = h1.next.next;
        System.out.println(solution.hasCycle(h1));
    }
}
