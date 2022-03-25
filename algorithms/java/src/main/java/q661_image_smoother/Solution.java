package q661_image_smoother;

import common.Util;

public class Solution {

    static int[][] dirs = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 1, sum = img[i][j];
                for (int[] dir : dirs) {
                    int nx = i + dir[0], ny = j + dir[1];
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                    count++;
                    sum += img[nx][ny];
                }
                ans[i][j] = sum / count;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] ans = solution.imageSmoother(new int[][]{
//                {1, 2, 3, 4, 5},
//                {6, 7, 8, 9, 10},
//                {11, 12, 13, 14, 15},
//                {16, 17, 18, 19, 20},
//                {21, 22, 23, 24, 25}
//        });
//        int[][] ans = solution.imageSmoother(new int[][]{
//                {1, 1, 1},
//                {1, 0, 1},
//                {1, 1, 1}
//        });
        int[][] ans = solution.imageSmoother(new int[][]{
                {100, 200, 100},
                {200, 50, 200},
                {100, 200, 100}
        });
        Util.printMatrix(ans);
    }
}
