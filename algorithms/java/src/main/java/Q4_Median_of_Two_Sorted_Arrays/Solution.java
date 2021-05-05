package q4_median_of_two_sorted_arrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length, len = len1 + len2;
        if (len % 2 == 1) {
            return findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, len / 2 + 1);
        } else {
            return (findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, len / 2)
                    + findKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, len / 2 + 1)) / 2.0;
        }
    }

    private double findKth(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {

        int len1 = e1 - s1 + 1;
        int len2 = e2 - s2 + 1;

        if (len1 > len2) {
            return findKth(nums2, s2, e2, nums1, s1, e1, k);
        }
        if (len1 == 0) {
            return nums2[s2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }

        int p1 = Math.min(k / 2, len1), p2 = k - p1;
        if (nums1[s1 + p1 - 1] < nums2[s2 + p2 - 1]) {
            return findKth(nums1, s1 + p1, e1, nums2, s2, e2, k - p1);
        } else if (nums1[s1 + p1 - 1] > nums2[s2 + p2 - 1]) {
            return findKth(nums1, s1, e1, nums2, s2 + p2, e2, k - p2);
        } else {
            return nums1[s1 + p1 - 1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
    }
}
