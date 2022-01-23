package q1332_remove_palindromic_subsequences;

public class Solution {

    public int removePalindromeSub(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return 2;
            }
            i++;
            j--;
        }
        return 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removePalindromeSub("ababa"));
        System.out.println(solution.removePalindromeSub("abb"));
        System.out.println(solution.removePalindromeSub("baabb"));
    }
}

