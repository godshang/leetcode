package q1996_the_number_of_weak_characters_in_the_game;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? (o1[1] - o2[1]) : (o2[0] - o1[0]);
            }
        });
        int maxDef = 0;
        int ans = 0;
        for (int[] p : properties) {
            if (p[1] < maxDef) {
                ans++;
            } else {
                maxDef = p[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfWeakCharacters(new int[][]{{5, 5}, {6, 3}, {3, 6}}));
        System.out.println(solution.numberOfWeakCharacters(new int[][]{{2, 2}, {3, 3}}));
    }
}
