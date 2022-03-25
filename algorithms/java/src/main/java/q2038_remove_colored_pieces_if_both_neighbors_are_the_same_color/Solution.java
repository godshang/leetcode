package q2038_remove_colored_pieces_if_both_neighbors_are_the_same_color;

public class Solution {

    public boolean winnerOfGame(String colors) {
        int n = colors.length();
        int a = 0, b = 0;
        for (int i = 1; i < n - 1; i++) {
            if (colors.charAt(i - 1) == 'A' && colors.charAt(i) == 'A' && colors.charAt(i + 1) == 'A') a++;
            if (colors.charAt(i - 1) == 'B' && colors.charAt(i) == 'B' && colors.charAt(i + 1) == 'B') b++;
        }
        return a > b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.winnerOfGame("AAABABB"));
        System.out.println(solution.winnerOfGame("AA"));
    }
}
