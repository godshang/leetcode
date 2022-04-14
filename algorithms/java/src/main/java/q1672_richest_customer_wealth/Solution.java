package q1672_richest_customer_wealth;

public class Solution {

    public int maximumWealth(int[][] accounts) {
        int m = accounts.length, n = accounts[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += accounts[i][j];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
        System.out.println(solution.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
    }
}
