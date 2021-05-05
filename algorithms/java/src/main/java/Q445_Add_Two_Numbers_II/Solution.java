package q445_add_two_numbers_ii;

import common.ListNode;
import common.Util;

import java.util.Stack;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        int sum, carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            sum = (!s1.isEmpty() ? s1.pop() : 0) + (!s2.isEmpty() ? s2.pop() : 0) + carry;
            carry = sum / 10;
            ListNode p = new ListNode(sum % 10);
            p.next = head;
            head = p;
        }
        return head;
    }

    public ListNode addTwoNumbers_Reverse(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode(), p = dummy;
        int sum = 0, carry = 0;
        while (l1 != null || l2 != null) {
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            p = p.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printList(solution.addTwoNumbers(Util.buildList(new int[]{7, 2, 4, 3}), Util.buildList(new int[]{5, 6, 4})));
        Util.printList(solution.addTwoNumbers(Util.buildList(new int[]{5}), Util.buildList(new int[]{5})));
    }
}
