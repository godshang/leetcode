package q10_regular_expression_matching;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isMatch(String s, String p) {
        if (p == null || p.length() == 0) {
            return s == null || s.length() == 0;
        }

        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 2; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }

        for (int j = 1; j <= p.length(); j++) {
            for (int i = 1; i <= s.length(); i++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public boolean isMatch2(String s, String p) {
        Map<String, Boolean> memo = new HashMap<>();
        return dp(s, p, 0, 0, memo);
    }

    private boolean dp(String s, String p, int i, int j, Map<String, Boolean> memo) {
        if (memo.containsKey(i + "_" + j)) return memo.get(i + "_" + j);
        if (j == p.length()) return i == s.length();

        boolean ans;
        boolean first = (i < s.length()) && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
        if (j <= p.length() - 2 && p.charAt(j + 1) == '*') {
            ans = dp(s, p, i, j + 2, memo) || (first && dp(s, p, i + 1, j, memo));
        } else {
            ans = first && dp(s, p, i + 1, j + 1, memo);
        }
        memo.put(i + "_" + j, ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch2("aa", "a"));
        System.out.println(solution.isMatch2("aa", "a*"));
        System.out.println(solution.isMatch2("aa", ".*"));
        System.out.println(solution.isMatch2("aab", "c*a*b"));
        System.out.println(solution.isMatch2("mississippi", "mis*is*p*."));
    }
}
