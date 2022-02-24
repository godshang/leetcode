package q1706_where_will_the_ball_fall;

import common.Util;

public class Solution {

    int[][] grid;
    int m, n;

    public int[] findBall(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = doFindBall(i);
        }
        return ans;
    }

    private int doFindBall(int col) {
        int row = 0;
        while (row < m) {
            int ne = col + grid[row][col];
            if (ne < 0 || ne >= n) return -1;
            if (grid[row][col] != grid[row][ne]) return -1;
            row++;
            col = ne;
        }
        return col;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.findBall(new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}}));
        Util.printArray(solution.findBall(new int[][]{{1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}, {1, 1, 1, 1, 1, 1}, {-1, -1, -1, -1, -1, -1}}));
    }
}
