package q449_serialize_and_deserialize_bst;

import common.BTreePrinter;
import common.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BTreePrinter.printNode(root);

        Codec codec = new Codec();
        String data = codec.serialize(root);
        System.out.println(data);
        BTreePrinter.printNode(codec.deserialize(data));
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] array = data.split(",");
        return dfs(array, 0, array.length - 1);
    }

    private TreeNode dfs(String[] array, int low, int high) {
        if (low > high) return null;
        TreeNode root = new TreeNode(Integer.parseInt(array[low]));
        int index = high + 1;
        for (int i = low + 1; i <= high; i++) {
            if (Integer.parseInt(array[i]) > root.val) {
                index = i;
                break;
            }
        }
        root.left = dfs(array, low + 1, index - 1);
        root.right = dfs(array, index, high);
        return root;
    }
}
