package q685_redundant_connection_ii;

import common.UF;
import common.Util;

public class Solution {


    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) return null;
        int len = edges.length;

        int[] inDegree = new int[len + 1];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }

        for (int i = len - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 2) {
                if (!judgeCircle(edges, len, i)) {
                    return edges[i];
                }
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (inDegree[edges[i][1]] == 1) {
                if (!judgeCircle(edges, len, i)) {
                    return edges[i];
                }
            }
        }
        return null;
    }

    private boolean judgeCircle(int[][] edges, int len, int removedEdgeIndex) {
        UF uf = new UF(len + 1);
        for (int i = 0; i < len; i++) {
            if (i == removedEdgeIndex) continue;
            if (!uf.union(edges[i][0], edges[i][1])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        Util.printArray(solution.findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}}));
    }
}
