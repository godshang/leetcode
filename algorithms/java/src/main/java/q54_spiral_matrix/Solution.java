package q54_spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1, total = m * n;
        List<Integer> res = new ArrayList<>();
        while (total >= 1) {
            for (int i = left; i <= right && total >= 1; i++) {
                res.add(matrix[top][i]);
                total--;
            }
            top++;
            for (int i = top; i <= bottom && total >= 1; i++) {
                res.add(matrix[i][right]);
                total--;
            }
            right--;
            for (int i = right; i >= left && total >= 1; i--) {
                res.add(matrix[bottom][i]);
                total--;
            }
            bottom--;
            for (int i = bottom; i >= top && total >= 1; i--) {
                res.add(matrix[i][left]);
                total--;
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] m1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(solution.spiralOrder(m1));
        
        int[][] m2 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(solution.spiralOrder(m2));
    }
}
