package q868_binary_gap;

public class Solution {

    public int binaryGap(int n) {
        int ans = 0, last = -1;
        for (int i = 0; n != 0; i++) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.binaryGap(22));
        System.out.println(solution.binaryGap(8));
        System.out.println(solution.binaryGap(5));
    }
}
