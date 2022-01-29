package q326_power_of_three;

public class Solution {

    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n >= 3) {
            if (n % 3 != 0) return false;
            n = n / 3;
        }
        if (n == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree(27));
        System.out.println(solution.isPowerOfThree(21));
    }
}
