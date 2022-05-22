package q260_single_number_iii;

import common.Util;

public class Solution {

    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }
        int k = -1;
        for (int i = 31; i >= 0 && k == -1; i--) {
            if (((xorsum >> i) & 1) == 1) {
                k = i;
            }
        }
        int[] ans = new int[2];
        for (int num : nums) {
            if (((num >> k) & 1) == 1) ans[0] ^= num;
            else ans[1] ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.singleNumber(new int[]{1, 2, 1, 3, 2, 5}));
        Util.printArray(solution.singleNumber(new int[]{-1, 0}));
        Util.printArray(solution.singleNumber(new int[]{0, 1}));
    }
}
