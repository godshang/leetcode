package q1629_slowest_key;

public class Solution {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = Integer.MIN_VALUE;
        char res = 0;
        int n = keysPressed.length();
        for (int i = 0; i < n; i++) {
            int cost = i > 0 ? (releaseTimes[i] - releaseTimes[i - 1]) : releaseTimes[i];
            char ch = keysPressed.charAt(i);
            if (cost > max) {
                max = cost;
                res = ch;
            } else if (cost == max && ch - res > 0) {
                res = ch;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.slowestKey(new int[]{9, 29, 49, 50}, "cbcd"));
        System.out.println(solution.slowestKey(new int[]{12, 23, 36, 46, 62}, "spuda"));
    }
}
