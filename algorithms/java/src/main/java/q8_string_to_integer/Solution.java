package q8_string_to_integer;

public class Solution {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int i = 0;
        Boolean negative = null;
        for (i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ' && negative == null) {
                continue;
            } else if (c == '-' && negative == null) {
                negative = true;
            } else if (c == '+' && negative == null) {
                negative = false;
            } else {
                break;
            }
        }
        str = str.substring(i);
        if (str.length() == 0) {
            return 0;
        }
        if (str.charAt(0) - '0' < 0 || str.charAt(0) - '9' > 9) {
            return 0;
        }

        int result = 0;
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) - '0' < 0 || str.charAt(i) - '9' > 9) {
                break;
            }
            int digit = (str.charAt(i) - '0');
            int newResult = result * 10 + digit;
            if ((newResult - digit) / 10 != result || newResult < result) {
                if (negative != null && negative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            } else {
                result = newResult;
            }
        }
        if (negative != null && negative) {
            result  = 0 - result;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("+-2"));
        System.out.println(solution.myAtoi("2147483800"));
        System.out.println(solution.myAtoi("   +0 123"));
        System.out.println(solution.myAtoi("2147483648"));
        System.out.println(solution.myAtoi("-   234"));
        System.out.println(solution.myAtoi("   -42"));
    }
}
