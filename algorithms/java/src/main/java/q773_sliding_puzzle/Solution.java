package q773_sliding_puzzle;

import java.util.*;

public class Solution {

    public int slidingPuzzle(int[][] board) {
        int m = board.length, n = board[0].length;

        char[] start = new char[m * n], end = new char[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start[i * n + j] = (char) (board[i][j] + '0');
                end[i * n + j] = (char) (i * n + j + 1 + '0');
            }
        }
        end[m * n - 1] = '0';
        String from = new String(start);
        String to = new String(end);

        List<List<Integer>> neighbor = neighbor(board);

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(from);
        visited.add(from);

        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                if (cur.equals(to))
                    return step;

                int idx = 0;
                for (; cur.charAt(idx) != '0'; idx++) ;
                
                for (int adj : neighbor.get(idx)) {
                    char[] array = cur.toCharArray();
                    char tmp = array[idx];
                    array[idx] = array[adj];
                    array[adj] = tmp;
                    String newBoard = new String(array);

                    if (!visited.contains(newBoard)) {
                        queue.offer(newBoard);
                        visited.add(newBoard);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private List<List<Integer>> neighbor(int[][] board) {
        List<List<Integer>> neighbor = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> list = new ArrayList<>();
                // up
                if (i - 1 >= 0) list.add((i - 1) * n + j);
                // down
                if (i + 1 < m) list.add((i + 1) * n + j);
                // left
                if (j - 1 >= 0) list.add(i * n + (j - 1));
                // right
                if (j + 1 < n) list.add(i * n + (j + 1));
                neighbor.add(list);
            }
        }
        return neighbor;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}));
//        System.out.println(solution.slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}}));
        System.out.println(solution.slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}}));
    }
}
