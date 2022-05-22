package q668_kth_smallest_number_in_multiplication_table;

public class Solution {

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right) {
            int x = left + (right - left) / 2;
            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(n, x / i);
            }

            if (count >= k) {
                right = x;
            } else {
                left = x + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findKthNumber(3, 3, 5));
        System.out.println(solution.findKthNumber(2, 3, 6));
    }
}
