package q81_search_in_rotated_sorted_array_ii;

public class Solution {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return nums[0] == target;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{2,5,6,0,0,1,2}, 0));
        System.out.println(solution.search(new int[]{2,5,6,0,0,1,2}, 3));
    }
}
