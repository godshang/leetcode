package Q25_Reverse_Nodes_in_k_Group;

import common.ListNode;
import common.Util;

public class Solution {

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
        Util.printList(solution.reverseKGroup(Util.buildList(new int[]{1, 2, 3, 4, 5}), 2));
    }
}
