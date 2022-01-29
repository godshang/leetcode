package q696_count_binary_substrings;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<>();
        int i = 0, n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            int count = 0;
            while (i < n && s.charAt(i) == c) {
                count++;
                i++;
            }
            counts.add(count);
        }
        int res = 0;
        for (i = 1; i < counts.size(); i++) {
            res += Math.min(counts.get(i - 1), counts.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countBinarySubstrings("00110011"));
        System.out.println(solution.countBinarySubstrings("10101"));
    }
}
