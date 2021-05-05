package q25_reverse_nodes_in_k_group;

import common.ListNode;
import common.Util;

public class Solution {

    public ListNode reverseKGroup_recursive(ListNode head, int k) {
        if (head == null) return null;
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup_recursive(b, k);
        return newHead;
    }
    
    // [a, b)
    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, current = a;
        while (current != b) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy, end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printList(solution.reverseKGroup_recursive(Util.buildList(new int[]{1, 2, 3, 4, 5}), 2));
    }
}
