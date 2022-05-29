package q467_unique_substrings_in_wraparound_string;

import java.util.Arrays;

public class Solution {

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0, n = p.length();
        for (int i = 0; i < n; i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                k++;
            } else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
        }
        return Arrays.stream(dp).sum();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubstringInWraproundString("a"));
        System.out.println(solution.findSubstringInWraproundString("cac"));
        System.out.println(solution.findSubstringInWraproundString("zab"));
    }
}
