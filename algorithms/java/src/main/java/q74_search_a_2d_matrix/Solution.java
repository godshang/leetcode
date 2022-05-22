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

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = mid / n, y = mid % n;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                low = mid + 1;
            } else if (matrix[x][y] > target) {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.searchMatrix2(new int[][]{{1}}, 2));
        System.out.println(solution.searchMatrix2(new int[][]{
                {1, 3, 5, 6},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 60));
    }
}
