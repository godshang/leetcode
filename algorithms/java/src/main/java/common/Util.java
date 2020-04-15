package common;

public class Util {

    public static ListNode buildList(int[] array) {
        ListNode head = new ListNode();
        ListNode p = head;
        for (int i = 0; i < array.length; i++) {
            p.next = new ListNode(array[i]);
            p = p.next;
        }
        return head.next;
    }

    public static void printList(ListNode node) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder();
        if (node != null) {
            sb.append(node.val);
        }
        ListNode n = node.next;
        while (n != null) {
            sb.append("->").append(n.val);
            n = n.next;
        }
        System.out.println(sb.toString());
    }

    public static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static TreeNode buildTree(Integer[] nums) {
        return buildTree(nums, 0);
    }

    private static TreeNode buildTree(Integer[] nums, int i) {
        if (i >= nums.length) return null;
        if (nums[i] == null) return null;
        TreeNode root = new TreeNode(nums[i]);
        root.left = buildTree(nums, 2 * i + 1);
        root.right = buildTree(nums, 2 * i + 2);
        return root;
    }
}
