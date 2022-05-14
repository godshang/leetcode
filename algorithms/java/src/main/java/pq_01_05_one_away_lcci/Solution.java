package pq_01_05_one_away_lcci;

public class Solution {

    public boolean oneEditAway(String first, String second) {
        int n = first.length(), m = second.length();
        if (Math.abs(n - m) > 1) return false;
        if (n > m) return oneEditAway(second, first);
        int i = 0, j = 0, cnt = 0;
        while (i < n && j < m && cnt <= 1) {
            if (first.charAt(i) == second.charAt(j)) {
                i++; j++;
            } else {
                if (n == m) {
                    i++; j++; cnt++;
                } else {
                    j++; cnt++;
                }
            }
        }
        return cnt <= 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.oneEditAway("pale", "ple"));
        System.out.println(solution.oneEditAway("pales", "pal"));
    }
}
