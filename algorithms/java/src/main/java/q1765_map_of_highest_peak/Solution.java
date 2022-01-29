package q1765_map_of_highest_peak;

import common.Util;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] height = new int[m][n];
        for (int[] arr : height) {
            Arrays.fill(arr, -1);
        }

        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int[] d : dir) {
                int x = p[0] + d[0], y = p[1] + d[1];
                if (x >= 0 && x <m && y >= 0 && y < n && height[x][y] == -1) {
                    height[x][y] = height[p[0]][p[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }

        return height;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Util.printMatrix(solution.highestPeak(new int[][]{{0, 1}, {0, 0}}));
        Util.printMatrix(solution.highestPeak(new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}}));
    }
}
