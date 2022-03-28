package q693_binary_number_with_alternating_bits;

public class Solution {

    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toString(n, 2);
        char[] chs = binary.toCharArray();
        int len = chs.length;
        char c = chs[0];
        for (int i = 1; i < len; i++) {
            if (chs[i] == c) return false;
            else c = chs[i];
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasAlternatingBits(5));
        System.out.println(solution.hasAlternatingBits(7));
        System.out.println(solution.hasAlternatingBits(11));
    }
}
