package q297_serialize_and_deserialize_binary_tree;

import common.BTreePrinter;
import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();
        String data = codec.serialize(root);
        System.out.println(data);
        BTreePrinter.printNode(codec.deserialize(data));
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return "[" + dfs(root) + "]";
    }

    private String dfs(TreeNode root) {
        if (root == null) return "null";
        return root.val + "," + dfs(root.left) + "," + dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.startsWith("[")) data = data.substring(1);
        if (data.endsWith("]")) data = data.substring(0, data.length() - 1);
        List<String> list = Arrays.asList(data.split(","));
        return dfs(new ArrayList<>(list));
    }

    private TreeNode dfs(List<String> list) {
        if (list == null || list.isEmpty()) return null;
        String val = list.get(0);
        list.remove(0);
        if (val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = dfs(list);
        node.right = dfs(list);
        return node;
    }
}
