package q384_shuffle_an_array;

import common.Util;

import java.util.Random;

public class Solution {

    private int[] array;
    private int[] origin;

    Random random = new Random();

    public Solution(int[] nums) {
        array = nums;
        origin = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        array = origin;
        origin = origin.clone();
        return array;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swap(i, randomRange(i, array.length));
        }
        return array;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int randomRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        Util.printArray(solution.shuffle());
        solution.reset();
        Util.printArray(solution.array);
        Util.printArray(solution.shuffle());
    }
}
