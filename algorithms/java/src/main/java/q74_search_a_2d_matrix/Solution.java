package q74_search_a_2d_matrix;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = 0;
        while (i * n + j < m * n) {
            if (matrix[i][n - 1] < target) {
                i++;
                j = 0;
            } else {
                if (matrix[i][j] < target) {
                    j++;
                } else if (matrix[i][j] == target) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(new int[][]{
                {1,3,5,6},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 60));
    }
}
