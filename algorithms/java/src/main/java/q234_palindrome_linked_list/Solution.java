package q234_palindrome_linked_list;

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

    public boolean isPalindrome_2(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next;
        
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome_2(Util.buildList(new int[]{1})));
        System.out.println(solution.isPalindrome_2(Util.buildList(new int[]{1, 2})));
        System.out.println(solution.isPalindrome_2(Util.buildList(new int[]{1, 2, 2, 1})));
        System.out.println(solution.isPalindrome_2(Util.buildList(new int[]{1, 1, 2, 1})));
    }
}
