package q5_longest_palindromic_substring;

public class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int n = s.length();
        String res = s.substring(0, 1);
        for (int i = 0; i < n; i++) {
            String s1 = searchPalindrome(s, i, i);
            String s2 = searchPalindrome(s, i, i + 1);
            String ss = s1.length() > s2.length() ? s1 : s2;
            res = ss.length() > res.length() ? ss : res;
        }
        return res;
    }

    public String searchPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public String longestPalindrome_2(String s) {
        if (s == null || s.length() < 2) return s;

        int n = s.length();
        int[][] dp = new int[n][n];

        String ans = "";
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + 1 < n; i++) {
                int j = i + l;
                if (j >= n) 
                    break;
                if (l == 0)
                    dp[i][j] = 1;
                else if (l == 1)
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? 1 : 0;
                else
                    dp[i][j] = (dp[i + 1][j - 1] == 1 && s.charAt(i) == s.charAt(j)) ? 1 : 0;

                if (dp[i][j] == 1 && l + 1 > ans.length())
                    ans = s.substring(i, j + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome_2("babad"));
    }
}
