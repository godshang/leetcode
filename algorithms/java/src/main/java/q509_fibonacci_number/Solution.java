package q509_fibonacci_number;

import java.util.Arrays;

public class Solution {

    /* 暴力递归 */
    public int fib_1(int N) {
        if (N == 1 || N == 2) return 1;
        return fib_1(N - 1) + fib_1(N - 2);
    }

    /* 带备忘录的递归解法 */
    public int fib_2(int N) {
        if (N < 1) return 0;
        int[] memo = new int[N + 1];
        Arrays.fill(memo, 0);
        return fib_2_helper(memo, N);
    }

    private int fib_2_helper(int[] memo, int N) {
        if (N == 1 || N == 2) return 1;
        if (memo[N] != 0) return memo[N];
        memo[N] = fib_2_helper(memo, N - 1) + fib_2_helper(memo, N - 2);
        return memo[N];
    }

    /* 动态规划 */
    private int fib_3(int N) {
        if (N < 1) return 0;
        if (N == 1 || N == 2) return 1;
        int[] dp = new int[N + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 10; i++) {
            assert solution.fib_1(i) == solution.fib_3(i);
        }
    }
}
