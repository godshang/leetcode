package q162_find_peak_element;

public class Solution {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (left == right) {
                return left;
            } else if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
        }
        return left;
    }

    public int findPeakElement2(int[] nums) {
        int n = nums.length, l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPeakElement2(new int[]{1, 2, 3, 2, 1}));
    }
}
