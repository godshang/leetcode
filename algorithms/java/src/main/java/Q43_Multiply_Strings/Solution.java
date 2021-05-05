package q43_multiply_strings;


public class Solution {

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        int idx = 0;
        while (idx < res.length && res[idx] == 0)
            idx++;
        StringBuffer sb = new StringBuffer();
        for (; idx < res.length; idx++) {
            sb.append(res[idx]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.multiply("2", "3"));
//        System.out.println(solution.multiply("123", "456"));
        System.out.println(solution.multiply("0", "0"));
    }
}
