package q1220_count_vowels_permutation;

import java.util.Arrays;

public class Solution {

    public int countVowelPermutation(int n) {
        int MOD = (int) 1e9 + 7;
        long[][] dp = new long[n][5];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n - 1; i++) {
            // 每个元音 'a' 后面都只能跟着 'e'
            dp[i + 1][1] += dp[i][0];
            // 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
            dp[i + 1][0] += dp[i][1];
            dp[i + 1][2] += dp[i][1];
            // 每个元音 'i' 后面 不能 再跟着另一个 'i'
            dp[i + 1][0] += dp[i][2];
            dp[i + 1][1] += dp[i][2];
            dp[i + 1][3] += dp[i][2];
            dp[i + 1][4] += dp[i][2];
            // 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
            dp[i + 1][2] += dp[i][3];
            dp[i + 1][4] += dp[i][3];
            // 每个元音 'u' 后面只能跟着 'a'
            dp[i + 1][0] += dp[i][4];
            for (int j = 0; j < 5; j++) {
                dp[i + 1][j] %= MOD;
            }
        }
        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += dp[n - 1][i];
        }
        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countVowelPermutation(1));
        System.out.println(solution.countVowelPermutation(2));
        System.out.println(solution.countVowelPermutation(5));
    }
}
