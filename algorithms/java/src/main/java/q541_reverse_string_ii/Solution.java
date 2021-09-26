package q541_reverse_string_ii;

public class Solution {

    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] array = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(array, i, Math.min(i + k, n) - 1);
        }
        return new String(array);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseStr("abcdefg", 2));
        System.out.println(solution.reverseStr("abcd", 2));
    }
}
