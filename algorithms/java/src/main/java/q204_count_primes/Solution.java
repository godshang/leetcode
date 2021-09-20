package q204_count_primes;

public class Solution {

    public int countPrimes(int n) {
        boolean[] flag = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!flag[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    flag[i * j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(10));
    }
}
