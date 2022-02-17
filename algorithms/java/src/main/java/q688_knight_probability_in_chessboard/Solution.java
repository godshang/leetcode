package q688_knight_probability_in_chessboard;

public class Solution {

    static int[][] dirs = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = 1;
            }
        }
        for (int p = 1; p <= k; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] d : dirs) {
                        int nx = i + d[0], ny = j + d[1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        dp[i][j][p] += dp[nx][ny][p - 1] / 8;
                    }
                }
            }
        }
        return dp[row][column][k];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.knightProbability(3, 2, 0, 0));
    }
}
