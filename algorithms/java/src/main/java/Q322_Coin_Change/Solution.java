package q322_coin_change;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /* 暴力递归 */
    public int coinChange_1(int[] coins, int amount) {
        return dp_1(coins, amount);
    }

    private int dp_1(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subproblem = dp_1(coins, amount - coin);
            if (subproblem == -1) continue; // 子问题无解，跳过
            res = Math.min(res, subproblem + 1);
        }
        return res;
    }

    /* 带备忘录的递归解法 */
    public int coinChange_2(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dp_2(memo, coins, amount);
    }

    private int dp_2(Map<Integer, Integer> memo, int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (memo.containsKey(amount)) return memo.get(amount);
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subproblem = dp_1(coins, amount - coin);
            if (subproblem == -1) continue; // 子问题无解，跳过
            res = Math.min(res, subproblem + 1);
        }
        memo.put(amount, res);
        return res;
    }

    /* 动态规划 */
    public int coinChange_3(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange_3(new int[]{1, 2, 5}, 11));
    }
}
