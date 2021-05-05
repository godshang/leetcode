package q547_friend_circles;

import common.UF;

public class Solution {

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int m = M.length;
        UF uf = new UF(m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
        // 1 0 0 1
        // 0 1 1 0
        // 0 1 1 1
        // 1 0 1 1
        System.out.println(solution.findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
    }
}
