package q852_peak_index_in_a_mountain_array;

public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{3, 4, 5, 1}));
        System.out.println(solution.peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
    }
}
