package common;

import java.util.List;

public class Util {

    // ====== Print Util ======
    
    public static <T> void printArray(T[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void printArray(double[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(" ");
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

    public static void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append("\n");
        for (int i = 0; i < matrix.length; i++) {
            sb.append("\t[");
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]").append("\n");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static <T> void printList(List<List<T>> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append("\n");
        for (int i = 0; i < list.size(); i++) {
            sb.append("\t[");
            for (int j = 0; j < list.get(i).size(); j++) {
                sb.append(list.get(i).get(j)).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("]").append("\n");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
    
    public static void printTree(TreeNode root) {
        BTreePrinter.printNode(root);
    }

    // ====== Linked list Util ======

    public static ListNode buildList(int[] array) {
        ListNode head = new ListNode();
        ListNode p = head;
        for (int i = 0; i < array.length; i++) {
            p.next = new ListNode(array[i]);
            p = p.next;
        }
        return head.next;
    }

    public static void printList(ListNode head) {
        if (head == null) return;
        StringBuilder sb = new StringBuilder();
        if (head != null) {
            sb.append(head.val);
        }
        ListNode n = head.next;
        while (n != null) {
            sb.append("->").append(n.val);
            n = n.next;
        }
        System.out.println(sb.toString());
    }

    public static ListNode findTail(ListNode head) {
        if (head == null) return head;
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    // ====== Tree Util ======

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
