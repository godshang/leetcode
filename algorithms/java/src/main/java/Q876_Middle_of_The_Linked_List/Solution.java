package q876_middle_of_the_linked_list;

import common.ListNode;
import common.Util;

public class Solution {

    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printList(solution.middleNode(Util.buildList(new int[]{1, 2, 3, 4, 5})));
        Util.printList(solution.middleNode(Util.buildList(new int[]{1, 2, 3, 4, 5, 6})));
    }
}
