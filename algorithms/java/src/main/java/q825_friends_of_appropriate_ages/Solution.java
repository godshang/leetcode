package q825_friends_of_appropriate_ages;

import java.util.Arrays;

public class Solution {

    public int numFriendRequests(int[] ages) {
        int res = 0;
        int n = ages.length;
        Arrays.sort(ages);
        int left = 0, right = 0;
        for (int age : ages) {
            if (age < 15) continue;
            while (ages[left] <= 0.5 * age + 7) left++;
            while (right + 1 < n && ages[right + 1] <= age) right++;
            res += right - left;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numFriendRequests(new int[]{16, 16}));
        System.out.println(solution.numFriendRequests(new int[]{16, 17, 18}));
        System.out.println(solution.numFriendRequests(new int[]{20, 30, 100, 110, 120}));
    }
}
