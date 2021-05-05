package q69_sqrt;

public class Solution {

    public int mySqrt(int x) {
        if (x < 1) return 0;
        int low = 1, high = x;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))
                return mid;
            else if (mid > x / mid)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(9));
        System.out.println(solution.mySqrt(2147395600));
    }
}
