package q328_odd_even_linked_list;

import common.ListNode;
import common.Util;

public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, evenHead = head.next, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printList(solution.oddEvenList(Util.buildList(new int[]{1, 2, 3, 4, 5})));
    }
}
