package Q19_Remove_Nth_Node_From_End_of_List;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode h = new ListNode(1);
        ListNode n = h;
//        n.next = new ListNode(2); n = n.next;
//        n.next = new ListNode(3); n = n.next;
//        n.next = new ListNode(4); n = n.next;
//        n.next = new ListNode(5); n = n.next;

        printList(h);
        ListNode r = solution.removeNthFromEnd(h, 1);
        printList(r);
    }

    private static void printList(ListNode n) {
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.val).append("->");
            n = n.next;
        }
        if (sb.length() > 2) {
            System.out.println(sb.substring(0, sb.length() - 2));
        } else {
            System.out.println(sb.toString());
        }
    }
}
