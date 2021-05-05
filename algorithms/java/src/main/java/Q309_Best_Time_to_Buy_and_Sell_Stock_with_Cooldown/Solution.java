package q309_best_time_to_buy_and_sell_stock_with_cooldown;

public class Solution {

    /**
     * 状态转移方程：
     * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     * <p>
     * base case:
     * dp[-1][k][0] = 0
     * 解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
     * dp[-1][k][1] = -infinity
     * 解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
     * dp[i][0][0] = 0
     * 解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
     * dp[i][0][1] = -infinity
     * 解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 2 == -2) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            } else if (i - 2 == -1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);

            // dp[0][0] = Math.max(dp[-1][0], dp[-1][1] + prices[0]) = 0
            // dp[0][1] = Math.max(dp[-1][1], dp[-2][0] - prices[0]) = Math.max(-infinity, 0 - prices[i]) = -prices[0];
            // dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]) = 0
            // dp[1][1] = Math.max(dp[0][1], dp[-1][0] - prices[1]) = Math.max(-prices[0], 0 - prices[i]) = -prices[i];
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
