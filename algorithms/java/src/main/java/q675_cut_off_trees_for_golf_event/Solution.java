package q675_cut_off_trees_for_golf_event;

import java.util.*;

public class Solution {

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    List<List<Integer>> forest;
    int m, n;

    public int cutOffTree(List<List<Integer>> forest) {
        this.forest = forest;
        this.m = forest.size();
        this.n = forest.get(0).size();

        List<int[]> trees = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    trees.add(new int[]{i, j});
                }
            }
        }
        Collections.sort(trees, (a, b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));

        int sx = 0, sy = 0;
        int ans = 0;
        for (int i = 0; i < trees.size(); i++) {
            int steps = bfs(sx, sy, trees.get(i)[0], trees.get(i)[1]);
            if (steps == -1) {
                return -1;
            }
            ans += steps;
            sx = trees.get(i)[0];
            sy = trees.get(i)[1];
        }
        return ans;
    }

    private int bfs(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return 0;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int[] cell = queue.poll();
                int cx = cell[0], cy = cell[1];
                for (int j = 0; j < 4; j++) {
                    int nx = cx + dirs[j][0], ny = cy + dirs[j][1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                        if (!visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                            if (nx == tx && ny == ty) {
                                return step;
                            }
                            queue.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> forest = new ArrayList<>();
        forest.add(Arrays.asList(4, 2, 3));
        forest.add(Arrays.asList(0, 0, 1));
        forest.add(Arrays.asList(7, 6, 5));
        System.out.println(solution.cutOffTree(forest));
    }
}
