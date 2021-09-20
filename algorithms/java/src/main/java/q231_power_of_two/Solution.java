package q231_power_of_two;

public class Solution {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfTwo2(1));
        System.out.println(solution.isPowerOfTwo2(16));
        System.out.println(solution.isPowerOfTwo2(218));
    }
}
