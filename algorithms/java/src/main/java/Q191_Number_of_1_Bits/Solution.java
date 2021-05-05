package q191_number_of_1_bits;

public class Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) num++;
            n >>= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(Integer.parseUnsignedInt("00000000000000000000000000001011", 2)));
    }
}
