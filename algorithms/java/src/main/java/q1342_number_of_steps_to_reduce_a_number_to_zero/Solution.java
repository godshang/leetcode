package q1342_number_of_steps_to_reduce_a_number_to_zero;

public class Solution {

    public int numberOfSteps(int num) {
        int ans = 0;
        while (num > 0) {
            num = (num & 0x01) == 1 ? (num - 1) : (num / 2);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSteps(14));
    }
}
