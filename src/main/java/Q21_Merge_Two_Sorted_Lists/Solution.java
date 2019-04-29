package Q21_Merge_Two_Sorted_Lists;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), current = head;
        while (l1 != null || l2 != null) {
            if (l1 == null || (l2 != null && l1.val >= l2.val)) {
                current.next = l2;
                current = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        Solution solution = new Solution();
        print(solution.mergeTwoLists(l1, l2));
    }

    private static void print(ListNode l) {
        StringBuilder builder = new StringBuilder();
        ListNode n = l;
        if (n != null)
            builder.append(n.val);
        n = n.next;
        while (n != null) {
            builder.append("->").append(n.val);
            n = n.next;
        }
        System.out.println(builder.toString());
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
