package q374_guess_number_higher_or_lower;

public class Solution {

    private int pick = 2;

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int x = left + (right - left) / 2;
            int g = guess(x);
            if (g == 0) {
                return x;
            } else if (g < 0) {
                right = x - 1;
            } else if (g > 0) {
                left = x + 1;
            }
        }
        return 0;
    }

    int guess(int num) {
        if (pick < num) return -1;
        else if (pick > num) return 1;
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.guessNumber(2));
    }
}
