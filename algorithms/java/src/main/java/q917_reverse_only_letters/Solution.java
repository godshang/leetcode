package q917_reverse_only_letters;

public class Solution {

    public String reverseOnlyLetters(String s) {
        if (s == null || s.length() == 0) return s;
        int n = s.length(), left = 0, right = n - 1;
        char[] chars = s.toCharArray();
        while (left <= right) {
            while (left < n && !Character.isLetter(chars[left])) left++;
            while (right >= 0 && !Character.isLetter(chars[right])) right--;
            if (left <= right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.reverseOnlyLetters("ab-cd"));
//        System.out.println(solution.reverseOnlyLetters("a-bC-dEf-ghIj"));
//        System.out.println(solution.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(solution.reverseOnlyLetters("-"));
    }
}
