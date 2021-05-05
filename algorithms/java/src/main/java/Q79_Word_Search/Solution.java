package q79_word_search;

public class Solution {

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean result = dfs(board, i, j, word, 0, visited);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int idx, boolean[][] visited) {
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }
        if (idx == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean result = false;
        for (int[] direction : directions) {
            int x = i + direction[0], y = j + direction[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if (!visited[x][y]) {
                    boolean flag = dfs(board, x, y, word, idx + 1, visited);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(solution.exist(board, "ABCCED"));
        System.out.println(solution.exist(board, "SEE"));
        System.out.println(solution.exist(board, "ABCB"));
    }
}
