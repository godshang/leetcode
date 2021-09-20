package q26_remove_duplicates_from_sorted_array;

import common.Util;

public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        System.out.println(solution.removeDuplicates(nums));
        Util.printArray(nums);
    }
}
