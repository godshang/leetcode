package q709_to_lower_case;

public class Solution {

    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.toLowerCase("Hello"));
        System.out.println(solution.toLowerCase("here"));
        System.out.println(solution.toLowerCase("LOVELY"));
    }
}
