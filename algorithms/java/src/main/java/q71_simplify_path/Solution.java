package q71_simplify_path;

import java.util.LinkedList;

public class Solution {

    public String simplifyPath(String path) {
        LinkedList<String> list = new LinkedList<>();
        int n = path.length();
        int i = 1;
        while (i < n) {
            if (path.charAt(i) == '/') {
                i++;
                continue;
            }
            int j = i + 1;
            while (j < n && path.charAt(j) != '/') j++;
            String item = path.substring(i, j);
            if (item.equals("..")) {
                list.pollLast();
            } else if (!item.equals(".")) {
                list.addLast(item);
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty()) {
            sb.append("/" + list.pollFirst());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home//foo/"));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
    }
}
