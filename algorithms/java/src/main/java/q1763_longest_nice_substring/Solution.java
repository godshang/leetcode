package q1763_longest_nice_substring;

public class Solution {

    public String longestNiceSubstring(String s) {
        int n = s.length();
        int idx = -1, len = 0;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (c >= 'a' && c <= 'z') {
                    a |= (1 << (c - 'a'));
                } else {
                    b |= (1 << (c - 'A'));
                }
                if (a == b && j - i + 1 > len) {
                    idx = i;
                    len = j - i + 1;
                }
            }
        }
        return idx == -1 ? "" : s.substring(idx, idx + len);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestNiceSubstring("YazaAay"));
        System.out.println(solution.longestNiceSubstring("Bb"));
    }
}
