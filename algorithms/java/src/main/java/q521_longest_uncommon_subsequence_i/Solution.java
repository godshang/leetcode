package q521_longest_uncommon_subsequence_i;

public class Solution {

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        else if (a.length() == b.length()) return a.length();
        else return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLUSlength("aba", "cdc"));
        System.out.println(solution.findLUSlength("aaa", "bbb"));
        System.out.println(solution.findLUSlength("aaa", "aaa"));
    }
}
