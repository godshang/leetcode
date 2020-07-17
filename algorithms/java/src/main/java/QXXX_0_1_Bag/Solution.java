package QXXX_0_1_Bag;

public class Solution {

    public int bag(int W, int[] wt, int[] val) {
        int N = wt.length;
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w - wt[i - 1]] + val[i - 1], dp[i - 1][w]);
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bag(4, new int[]{2, 1, 3}, new int[]{4, 2, 3}));
    }
}
