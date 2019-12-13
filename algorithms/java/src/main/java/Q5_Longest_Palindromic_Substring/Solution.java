package Q5_Longest_Palindromic_Substring;

public class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int n = s.length();
        String res = s.substring(0, 1);
        for (int i = 0; i < n; i++) {
            String s1 = searchPalindrome(s, i, i);
            String s2 = searchPalindrome(s, i, i + 1);
            String ss = s1.length() > s2.length() ? s1 : s2;
            res = ss.length() > res.length() ? ss : res;
        }
        return res;
    }

    public String searchPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
