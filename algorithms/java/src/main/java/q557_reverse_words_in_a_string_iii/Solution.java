package q557_reverse_words_in_a_string_iii;

public class Solution {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        while (right < s.length()) {
            while (right < s.length() && s.charAt(right) != ' ') right++;
            reverse(chars, left, right - 1);
            left = right + 1;
            right = left;
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }
}
