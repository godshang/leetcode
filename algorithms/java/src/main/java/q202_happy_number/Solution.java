package q202_happy_number;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        while (inLoop.add(n)) {
            int sum = digitSquareSum(n);
            System.out.println(sum);
            if (sum == 1) return true;
            n = sum;
        }
        return false;
    }

    public boolean isHappy_v2(int n) {
        int slow = n, fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);
        if (slow == 1) return true;
        return false;
    }

    private int digitSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy_v2(2));
    }
}
