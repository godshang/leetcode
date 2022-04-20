package q388_longest_absolute_file_path;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthLongestPath(String input) {
        String ans = null;
        Map<Integer, String> levelMap = new HashMap<>();
        String[] array = input.split("\n");
        for (String s : array) {
            int level = countTab(s);
            String cur = s.replaceAll("\t", "");
            String prev = levelMap.getOrDefault(level - 1, null);
            String path = prev == null ? cur : prev + "/" + cur;
            if (!cur.contains(".")) { // is directory
                levelMap.put(level, path);
            } else if (ans == null || path.length() > ans.length()) {
                ans = path;
            }
        }
        return ans == null ? 0 : ans.length();
    }

    private int countTab(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '\t') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}
