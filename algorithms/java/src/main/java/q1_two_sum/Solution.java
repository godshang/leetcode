package q1_two_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] pos = new int[2];
        if (nums == null || nums.length == 0) {
            return pos;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0, l = nums.length; i < l; i++) {
            if (map.containsKey(target - nums[i])) {
                pos[1] = i;
                pos[0] = map.get(target - nums[i]);
            } else {
                map.put(nums[i], i);
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        int[] ret = solution.twoSum(nums, target);
        for (int i = 0, l = ret.length; i < l; i++) {
            System.out.println(ret[i]);
        }
    }
}
