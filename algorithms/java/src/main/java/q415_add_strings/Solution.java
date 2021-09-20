package q415_add_strings;

public class Solution {

    public String addStrings(String num1, String num2) {
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        int i = ch1.length - 1, j = ch2.length - 1;
        int r = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? (ch1[i] - '0') : 0;
            int n2 = j >= 0 ? (ch2[j] - '0') : 0;
            int sum = n1 + n2 + r;
            sb.append(sum % 10);
            r = sum / 10;
            if (i >= 0) i--;
            if (j >= 0) j--;
        }
        if (r > 0) {
            sb.append(r);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addStrings("11", "123"));
        System.out.println(solution.addStrings("456", "77"));
        System.out.println(solution.addStrings("0", "0"));
        System.out.println(solution.addStrings("1", "9"));
    }
}
