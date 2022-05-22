package q154_find_minimum_in_rotated_sorted_array_ii;

public class Solution {

    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right && nums[right] == nums[0]) right--;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right + 1 < n ? nums[right + 1] : nums[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findMin(new int[]{1, 3, 5}));
//        System.out.println(solution.findMin(new int[]{2, 2, 2, 0, 1}));
//        System.out.println(solution.findMin(new int[]{3, 3, 1, 3}));
        System.out.println(solution.findMin(new int[]{1, 3, 3}));
    }
}
