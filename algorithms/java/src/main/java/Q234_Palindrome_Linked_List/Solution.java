package Q234_Palindrome_Linked_List;

import common.ListNode;
import common.Util;

public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode newHead = reverse(head);

        while (head != null) {
            if (head.val != newHead.val)
                return false;
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(), cur = head, prev = null;
        while (cur != null) {
            ListNode p = new ListNode(cur.val);
            dummy.next = p;
            p.next = prev;
            prev = p;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(Util.buildList(new int[]{1})));
        System.out.println(solution.isPalindrome(Util.buildList(new int[]{1, 2})));
        System.out.println(solution.isPalindrome(Util.buildList(new int[]{1, 2, 2, 1})));
        System.out.println(solution.isPalindrome(Util.buildList(new int[]{1, 1, 2, 1})));
    }
}
