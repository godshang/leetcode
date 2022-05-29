package q1385_find_the_distance_value_between_two_arrays;

import java.util.Arrays;

public class Solution {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            int target = arr1[i];
            int p = lower_bound(arr2, target);
            boolean ok = true;
            if (p < arr2.length) {
                ok &= Math.abs(arr2[p] - target) > d;
            }
            if (p - 1 >= 0) {
                ok &= Math.abs(arr2[p - 1] - target) > d;
            }
            if (ok) ans++;
        }
        return ans;
    }

    private int lower_bound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.findTheDistanceValue(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2));
//        System.out.println(solution.findTheDistanceValue(new int[]{1, 4, 2, 3}, new int[]{-4, -3, 6, 10, 20, 30}, 3));
        System.out.println(solution.findTheDistanceValue(new int[]{2, 1, 100, 3}, new int[]{-5, -2, 10, -3, 7}, 6));
    }
}
