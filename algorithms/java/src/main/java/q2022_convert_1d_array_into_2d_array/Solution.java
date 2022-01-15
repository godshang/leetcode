package q2022_convert_1d_array_into_2d_array;

import common.Util;

public class Solution {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original == null || original.length != m * n)
            return new int[][]{};
        int[][] res = new int[m][n];
        int row = 0, col = 0;
        for (int i = 0; i < original.length; i++) {
            res[row][col] = original[i];
            col++;
            if (col == n) {
                row++;
                col = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printMatrix(solution.construct2DArray(new int[]{1, 2, 3, 4}, 2, 2));
        Util.printMatrix(solution.construct2DArray(new int[]{1, 2, 3}, 1, 3));
        Util.printMatrix(solution.construct2DArray(new int[]{1, 2}, 1, 1));
        Util.printMatrix(solution.construct2DArray(new int[]{3}, 1, 2));
    }
}
