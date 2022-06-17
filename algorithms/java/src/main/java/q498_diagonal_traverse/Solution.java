package q498_diagonal_traverse;

import common.Util;

public class Solution {

    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length, cnt = n * m;
        int idx = 0, x = 0, y = 0, flag = 1;
        int[] ans = new int[cnt];
        while (idx < cnt) {
            ans[idx++] = mat[x][y];
            int nx = x, ny = y;
            if (flag == 1) {
                nx = x - 1; ny = y + 1;
            } else {
                nx = x + 1; ny = y - 1;
            }
            if (idx < cnt && (nx < 0 || ny < 0 || nx >= n || ny >= m)) {
                if (flag == 1) {
                    nx = y + 1 < m ? x : x + 1;
                    ny = y + 1 < m ? y + 1 : y;
                } else {
                    nx = x + 1 < n ? x + 1 : x;
                    ny = x + 1 < n ? y : y + 1;
                }
                flag *= -1;
            }
            x = nx; y = ny;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        Util.printArray(solution.findDiagonalOrder(new int[][]{{1, 2}, {3, 4}}));
    }
}
