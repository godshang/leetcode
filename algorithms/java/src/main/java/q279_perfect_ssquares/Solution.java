package q279_perfect_ssquares;

import java.util.Arrays;

public class Solution {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int maxSquareIndex = (int) Math.sqrt(n) + 1;
        int[] squares = new int[maxSquareIndex];
        for (int i = 1; i < maxSquareIndex; i++) {
            squares[i] = i * i;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < maxSquareIndex; j++) {
                if (i < squares[j])
                    break;
                dp[i] = Math.min(dp[i], dp[i - squares[j]] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }
}
