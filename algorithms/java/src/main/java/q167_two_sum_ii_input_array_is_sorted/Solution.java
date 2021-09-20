package q167_two_sum_ii_input_array_is_sorted;

import common.Util;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int[] indice = new int[2];
        if (numbers == null || numbers.length == 0) return indice;

        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int value = numbers[left] + numbers[right];
            if (value == target) {
                indice[0] = left + 1; indice[1] = right + 1;
                return indice;
            } else if (value > target) {
                right--;
            } else {
                left++;
            }
        }
        return indice;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.twoSum(new int[] {2, 7, 11, 15}, 9));
    }
}
