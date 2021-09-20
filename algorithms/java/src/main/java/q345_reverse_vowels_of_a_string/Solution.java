package q345_reverse_vowels_of_a_string;

public class Solution {

    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            while (left < s.length() && !isVowel(chars[left])) left++;
            while (right > 0 && !isVowel(chars[right])) right--;
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

    private boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.reverseVowels("hello"));
//        System.out.println(solution.reverseVowels("leetcode"));
        System.out.println(solution.reverseVowels(" "));
    }
}
