package q1189_maximum_number_of_balloons;

import java.util.Arrays;

public class Solution {

    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[5];
        for (char ch : text.toCharArray()) {
            switch (ch) {
                case 'b': cnt[0]++; break;
                case 'a': cnt[1]++; break;
                case 'l': cnt[2]++; break;
                case 'o': cnt[3]++; break;
                case 'n': cnt[4]++; break;
            }
        }
        cnt[2] /= 2; cnt[3] /= 2;
        return Arrays.stream(cnt).min().getAsInt();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxNumberOfBalloons("nlaebolko"));
        System.out.println(solution.maxNumberOfBalloons("loonbalxballpoon"));
    }
}
