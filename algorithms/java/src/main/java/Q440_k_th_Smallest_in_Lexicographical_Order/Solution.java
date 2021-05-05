package q440_k_th_smallest_in_lexicographical_order;

public class Solution {

    public int findKthNumber(int n, int k) {
        int p = 1;
        int prefix = 1;
        while (p < k) {
            int count = getCount(prefix, n);
            if (p + count > k) {
                prefix *= 10;
                p++;
            } else if (p + count <= k) {
                prefix++;
                p += count;
            }
        }
        return prefix;
    }

    private int getCount(int prefix, int n) {
        int count = 0;
        long cur = prefix, next = prefix + 1;
        while (cur <= n) {
            count += Math.min(next, n + 1) - cur;
            cur *= 10;
            next *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthNumber(681692778, 351251360));
    }
}
