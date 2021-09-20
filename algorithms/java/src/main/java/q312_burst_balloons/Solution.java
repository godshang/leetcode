package q312_burst_balloons;

public class Solution {

    public int maxCoins(int[] nums) {
        int[] vals = new int[nums.length + 2];
        vals[0] = 1;
        vals[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++)
            vals[i + 1] = nums[i];

        int n = vals.length;
        int[][] dp = new int[n][n];
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int res = 0;
                for (int k = i + 1; k < i + len - 1; k++) {
                    int left = dp[i][k];
                    int right = dp[k][i + len - 1];
                    res = Math.max(res, left + vals[i] * vals[k] * vals[i + len - 1] + right);
                }
                dp[i][i + len - 1] = res;
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxCoins(new int[]{3, 1, 5, 8}));
    }
}
