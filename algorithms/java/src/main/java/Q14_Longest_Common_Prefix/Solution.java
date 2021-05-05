package q14_longest_common_prefix;

public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int i = 0;

        OUTER:
        while (true) {
            char c = 0;
            for (int j = 0; j < strs.length; j++) {
                if (strs[j] == null || strs[j].length() == 0) {
                    break OUTER;
                }
                if (i >= strs[j].length()) {
                    break OUTER;
                }
                if (c == 0) {
                    c = strs[j].charAt(i);
                } else if (c != strs[j].charAt(i)) {
                    break OUTER;
                }
            }

            i++;
        }

        return i == 0 ? "" : strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(solution.longestCommonPrefix(new String[] {"dog","racecar","car"}));
        System.out.println(solution.longestCommonPrefix(new String[] {"a"}));
    }
}
