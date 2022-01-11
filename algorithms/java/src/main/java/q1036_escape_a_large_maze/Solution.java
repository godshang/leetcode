package q1036_escape_a_large_maze;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    long BASE = 131L;
    int EDGE = (int) 1e6, MAX = (int) 1e5;
    Set<Long> set = new HashSet<>();
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        for (int[] b : blocked) {
            set.add(b[0] * BASE + b[1]);
        }
        int n = blocked.length;
        MAX = n * (n - 1) / 2;
        return check(source, target) && check(target, source);
    }

    private boolean check(int[] a, int[] b) {
        Set<Long> visited = new HashSet<>();
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(a);
        visited.add(a[0] * BASE + a[1]);
        while (!deque.isEmpty() && visited.size() <= MAX) {
            int[] polled = deque.pollFirst();
            int x = polled[0], y = polled[1];
            if (x == b[0] && y == b[1]) return true;
            for (int[] d : dir) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= EDGE || ny < 0 || ny >= EDGE) continue;
                long hash = nx * BASE + ny;
                if (set.contains(hash)) continue;
                if (visited.contains(hash)) continue;
                deque.addLast(new int[]{nx, ny});
                visited.add(hash);
            }
        }
        return visited.size() > MAX;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isEscapePossible(new int[][]{{0, 1}, {1, 0}}, new int[]{0, 0}, new int[]{0, 2}));
        System.out.println(solution.isEscapePossible(new int[][]{}, new int[]{0, 0}, new int[]{99, 99}));
    }
}
