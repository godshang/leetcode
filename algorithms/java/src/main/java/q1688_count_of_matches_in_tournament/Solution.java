package q1688_count_of_matches_in_tournament;

public class Solution {

    public int numberOfMatches(int n) {
        int res = 0;
        while (n > 1) {
            res += n / 2;
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n / 2 + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfMatches(7));
        System.out.println(solution.numberOfMatches(14));
    }
}
