package q1089_duplicate_zeros;

import common.Util;

public class Solution {

    public void duplicateZeros(int[] arr) {
        int n = arr.length, i = 0, j = n - 1, k = n - 1;
        while (i < j) {
            if (arr[i++] == 0) j--;
        }

        if (i == j) arr[k--] = arr[j--];

        while (j >= 0) {
            if (arr[j] == 0) arr[k--] = 0;
            arr[k--] = arr[j--];
        }
        return;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 0, 2, 3, 4, 0, 5, 0};
        solution.duplicateZeros(arr);
        Util.printArray(arr);
    }
}
