package q409_longest_palindrome;

public class Solution {

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }
        
        int ans = 0;
        for (int x : cnt) {
            ans += x - (x & 1); 
        }
        
        return ans < s.length() ? ans + 1 : ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
    }
}
