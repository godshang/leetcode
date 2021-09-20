package q344_reverse_string;

public class Solution {

    public void reverseString(char[] s) {
        if (s == null) return;
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] s = {'h','e','l','l','o'};
        solution.reverseString(s);
        System.out.println(new String(s));
    }
}
