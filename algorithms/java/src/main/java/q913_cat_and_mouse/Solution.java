package q913_cat_and_mouse;

public class Solution {

    static int N = 55;
    static int[][][] f = new int[2 * N * N][N][N];
    int[][] g;
    int n;

    public int catMouseGame(int[][] graph) {
        g = graph;
        n = graph.length;
        for (int k = 0; k < 2 * n * n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    f[k][i][j] = -1;
                }
            }
        }
        return dfs(0, 1, 2);
    }

    private int dfs(int k, int a, int b) {
        int ans = f[k][a][b];
        if (a == 0) ans = 1;
        else if (a == b) ans = 2;
        else if (k >= 2 * n * n) ans = 0;
        else if (ans == -1) {
            boolean win = false, draw = false;
            if (k % 2 == 0) { // mouse move
                for (int ne : g[a]) {
                    int ret = dfs(k + 1, ne, b);
                    if (ret == 1) win = true;
                    else if (ret == 0) draw = true;
                    if (win) break;
                }
                if (win) ans = 1;
                else if (draw) ans = 0;
                else ans = 2;
            } else { // cat move
                for (int ne : g[b]) {
                    if (ne == 0) continue;
                    int ret = dfs(k + 1, a, ne);
                    if (ret == 2) win = true;
                    else if (ret == 0) draw = true;
                    if (win) break;
                }
                if (win) ans = 2;
                else if (draw) ans = 0;
                else ans = 1;
            }
        }
        f[k][a][b] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.catMouseGame(new int[][]{{2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}}));
//        System.out.println(solution.catMouseGame(new int[][]{{1, 3}, {0}, {3}, {0, 2}}));
        System.out.println(solution.catMouseGame(new int[][]{{3, 4}, {3, 5}, {3, 6}, {0, 1, 2}, {0, 5, 6}, {1, 4}, {2, 4}}));
    }
}
