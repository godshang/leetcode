package q61_rotate_list;

import common.ListNode;
import common.Util;

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;

        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) len++;

        k = k % len;
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printList(solution.rotateRight(Util.buildList(new int[]{1, 2, 3, 4, 5}), 10));
    }
}
