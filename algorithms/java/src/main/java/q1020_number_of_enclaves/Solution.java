package q1020_number_of_enclaves;

public class Solution {

    private static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int m, n;
    private int[][] visited;

    public int numEnclaves(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i , n - 1);
        }
        for (int j = 1; j < n - 1; j++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n
                || grid[row][col] == 0 || visited[row][col] == 1) {
            return;
        }
        visited[row][col] = 1;
        for (int[] dir : dirs) {
            dfs(grid, row + dir[0], col + dir[1]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numEnclaves(new int[][]{
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        }));
    }
}
