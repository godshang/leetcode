package q88_merge_sorted_array;

import common.Util;

public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1, j = m - 1, k = n - 1;
        while (i >= 0) {
            if (j >= 0 && k >= 0) {
                nums1[i] = nums1[j] > nums2[k] ? nums1[j--] : nums2[k--];
            } else if (j >= 0) {
                nums1[i] = nums1[j--];
            } else if (k >= 0) {
                nums1[i] = nums2[k--];
            }
            i--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = new int[] { 2, 5, 6 };
        solution.merge(nums1, 3, nums2, 3);
        Util.printArray(nums1);
    }
}
