package q203_remove_linked_list_elements;

import common.ListNode;
import common.Util;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head, prev = dummy;
        while (cur != null) {
            if (cur.val == val) prev.next = cur.next;
            else prev = prev.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Util.printList(solution.removeElements(Util.buildList(new int[]{1, 2, 6, 3, 4, 5, 6}), 6));
        Util.printList(solution.removeElements2(Util.buildList(new int[]{1, 1}), 1));
    }
}
