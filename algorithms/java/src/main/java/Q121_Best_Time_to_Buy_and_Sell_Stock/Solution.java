package Q121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int dp_i_0 = 0, dp_i_1= Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[] {7,1,5,3,6,4}));
    }
}