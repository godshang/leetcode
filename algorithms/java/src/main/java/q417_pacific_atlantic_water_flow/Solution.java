package q417_pacific_atlantic_water_flow;

import java.util.*;

public class Solution {

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] heights;
    int m, n;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            bfs(i, 0, pacific);
        }
        for (int j = 1; j < n; j++) {
            bfs(0, j, pacific);
        }
        for (int i = 0; i < m; i++) {
            bfs(i, n - 1, atlantic);
        }
        for (int j = 0; j < n - 1; j++) {
            bfs(m - 1, j, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void bfs(int i, int j, boolean[][] ocean) {
        if (ocean[i][j]) return;
        ocean[i][j] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                if (x >= 0 && y >= 0 && x < m && y < n && heights[x][y] >= heights[cur[0]][cur[1]] && !ocean[x][y]) {
                    ocean[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));
        System.out.println(solution.pacificAtlantic(new int[][]{{2, 1}, {1, 2}}));
    }
}
