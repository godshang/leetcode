package q51_n_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        List<char[]> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] ch = new char[n];
            Arrays.fill(ch, '.');
            board.add(ch);
        }
        backtrack(0, board);
        return result;
    }

    private void backtrack(int row, List<char[]> board) {
        if (row == board.size()) {
            result.add(board.stream().map(e -> new String(e)).collect(Collectors.toList()));
            return;
        }
        int n = board.get(row).length;
        for (int col = 0; col < n; col++) {
            if (!isValid(row, col, board)) continue;
            board.get(row)[col] = 'Q';
            backtrack(row + 1, board);
            board.get(row)[col] = '.';
        }
    }

    private boolean isValid(int row, int col, List<char[]> board) {
        int n = board.size();
        for (int i = 0; i < n; i++) {
            if (board.get(i)[col] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i)[j] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i)[j] == 'Q')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
    }
}
