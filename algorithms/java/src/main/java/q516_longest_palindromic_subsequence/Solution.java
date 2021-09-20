package q516_longest_palindromic_subsequence;

public class Solution {

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int N = s.length();
        int[][] dp = new int[N][N];
        // base case
        for (int i = 0; i < N; i++)
            dp[i][i] = 1;

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][N - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
    }
}
