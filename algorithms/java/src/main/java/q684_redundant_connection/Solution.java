package q684_redundant_connection;

import common.UF;
import common.Util;

public class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) return null;
        int n = edges.length;
        int[] res = new int[2];
        UF uf = new UF(n + 1);
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            if (!uf.union(edge[0], edge[1])) {
                res[0] = edge[0];
                res[1] = edge[1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        Util.printArray(solution.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}));
    }
}
