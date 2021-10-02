package q821_shortest_distance_to_a_character;

import common.Util;

import java.util.Arrays;

public class Solution {

    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] index = new int[n];
        Arrays.fill(index, -1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                index[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) continue;
            for (int j = 0; j < n; j++) {
                if (index[j] == 0) {
                    int dis = Math.abs(i - j);
                    if (index[i] == -1 || dis < index[i]) {
                        index[i] = dis;
                    }
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.shortestToChar("loveleetcode", 'e'));
    }
}
