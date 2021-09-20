package q92_reverse_linked_list_ii;

import common.ListNode;
import common.Util;

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    // 翻转链表的前N个节点
    private ListNode successor = null;

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    // 翻转整个链表
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Util.printList(solution.reverse(Util.buildList(new int[]{1, 2, 3, 4, 5})));
//        Util.printList(solution.reverseN(Util.buildList(new int[]{1, 2, 3, 4, 5}), 3));
        Util.printList(solution.reverseBetween(Util.buildList(new int[]{1, 2, 3, 4, 5}), 2, 4));
    }
}
