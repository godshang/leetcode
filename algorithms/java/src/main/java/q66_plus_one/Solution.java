package q66_plus_one;

import common.Util;

public class Solution {

    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length];
        int sum = 0;
        int one = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + one;
            result[i] = sum % 10;
            one = sum / 10;
        }
        if (one > 0) {
            int[] tmp = new int[result.length + 1];
            tmp[0] = one;
            System.arraycopy(result, 0, tmp, 1, result.length);
            return tmp;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.plusOne(new int[] {1, 2, 3}));
    }
}
