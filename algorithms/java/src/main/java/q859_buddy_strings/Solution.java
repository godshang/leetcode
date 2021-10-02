package q859_buddy_strings;

public class Solution {

    public boolean buddyStrings(String s, String goal) {
        if (s.length() < 2 || s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            if (s.length() > 26) {
                return true;
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if (s.indexOf(s.charAt(i), i + 1) > 0) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            int df = -1, ds = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (df == -1) df = i;
                    else if (ds == -1) ds = i;
                    else return false;
                }
            }
            return ds != -1 && s.charAt(df) == goal.charAt(ds) && s.charAt(ds) == goal.charAt(df);
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.buddyStrings("ab", "ba"));
        System.out.println(solution.buddyStrings("ab", "ab"));
        System.out.println(solution.buddyStrings("aa", "aa"));
        System.out.println(solution.buddyStrings("aaaaaaabc", "aaaaaaacb"));
        System.out.println(solution.buddyStrings("", "aa"));
    }
}

