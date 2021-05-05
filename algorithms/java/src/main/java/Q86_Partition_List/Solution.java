package q86_partition_list;

import common.ListNode;
import common.Util;

public class Solution {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode before = new ListNode(), p = before, after = new ListNode(), q = after;
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        q.next = null;
        p.next = after.next;
        return before.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printList(solution.partition(Util.buildList(new int[]{1, 4, 3, 2, 5, 2}), 3));
    }
}
