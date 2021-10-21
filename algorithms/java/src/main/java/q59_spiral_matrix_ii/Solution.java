package q59_spiral_matrix_ii;

import common.Util;

public class Solution {

    enum Direction {
        RIGHT, DOWN, LEFT, UP;
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        Direction direction = Direction.RIGHT;
        int direct = 0;
        int i = 0, j = 0;
        int left = 0, right = n - 1, top = 0, down = n - 1;
        for (int num = 1; num <= n * n; num++) {
            matrix[i][j] = num;
            if (direction == Direction.RIGHT) {
                j++;
                if (j > right) {
                    j = right;
                    i++;
                    direction = Direction.DOWN;
                    top++;
                }
            } else if (direction == Direction.DOWN) {
                i++;
                if (i > down) {
                    i = down;
                    j--;
                    direction = Direction.LEFT;
                    right--;
                }
            } else if (direction == Direction.LEFT) {
                j--;
                if (j < left) {
                    j = left;
                    i--;
                    direction = Direction.UP;
                    down--;
                }
            } else if (direction == Direction.UP) {
                i--;
                if (i < top) {
                    i = top;
                    j++;
                    direction = Direction.RIGHT;
                    left++;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printMatrix(solution.generateMatrix(4));
    }
}
