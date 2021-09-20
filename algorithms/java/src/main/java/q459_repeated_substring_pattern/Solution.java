package q459_repeated_substring_pattern;

public class Solution {

    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.repeatedSubstringPattern("abab"));
        System.out.println(solution.repeatedSubstringPattern("aba"));
        System.out.println(solution.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(solution.repeatedSubstringPattern("aaaa"));
    }
}
