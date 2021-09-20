package q371_sum_of_two_integers;

public class Solution {

    public int getSum(int a, int b) {
        while (a != 0) {
            int newA = (a & b) << 1;
            int newB = a ^ b;
            a = newA;
            b = newB;
        }
        return a | b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSum(1, 2));
        System.out.println(solution.getSum(-2, 3));
    }
}
