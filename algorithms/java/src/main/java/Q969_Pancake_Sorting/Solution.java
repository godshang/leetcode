package q969_pancake_sorting;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<Integer> res = new ArrayList<>();

    public List<Integer> pancakeSort(int[] A) {
        sort(A, A.length);
        return res;
    }

    private void sort(int[] A, int n) {
        if (n == 1) return;
        int max = 0, maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
                maxIndex = i;
            }
        }
        reverse(A, 0, maxIndex);
        res.add(maxIndex + 1);
        reverse(A, 0, n - 1);
        res.add(n);

        sort(A, n - 1);
    }

    private void reverse(int[] A, int start, int end) {
        while (start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.pancakeSort(new int[]{3, 2, 4, 1}));
    }
}
