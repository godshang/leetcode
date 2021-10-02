package q796_rotate_string;

public class Solution {

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rotateString("abcde", "cdeab"));
        System.out.println(solution.rotateString("abcde", "abced"));
    }
}
