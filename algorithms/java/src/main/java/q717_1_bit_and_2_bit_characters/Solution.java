package q717_1_bit_and_2_bit_characters;

public class Solution {

    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
        while (i < n - 1) {
            i += bits[i] + 1;
        }
        return i == n - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(solution.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
}
