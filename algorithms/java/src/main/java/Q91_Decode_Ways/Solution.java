package q91_decode_ways;

public class Solution {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0' && !(s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2')) {
                return 0;
            }
            if (s.charAt(i - 1) == '0' && (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2')) {
                dp[i] = dp[i - 2];
            } else if (s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '9' && s.charAt(i - 2) == '1') {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else if (s.charAt(i - 1) <= '6' && s.charAt(i - 2) == '2') {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("2611055971756562"));
    }
}
