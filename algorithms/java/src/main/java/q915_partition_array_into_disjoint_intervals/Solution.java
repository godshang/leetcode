package q915_partition_array_into_disjoint_intervals;

public class Solution {

    public int partitionDisjoint(int[] nums) {
        int index = 0, max = nums[0], leftMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = max;
                index = i;
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
        System.out.println(solution.partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}));
        System.out.println(solution.partitionDisjoint(new int[]{1, 1}));
    }
}
