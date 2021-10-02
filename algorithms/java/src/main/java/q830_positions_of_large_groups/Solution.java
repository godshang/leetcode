package q830_positions_of_large_groups;

import common.Util;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int n = s.length();
        int start = 0, end = 0;
        while (end < n) {
            while (end < n && s.charAt(start) == s.charAt(end))
                end++;
            if (end - start >= 3) {
                List<Integer> range = new ArrayList<>();
                range.add(start);
                range.add(end - 1);
                res.add(range);
            }
            start = end;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printList(solution.largeGroupPositions("abbxxxxzzy"));
        Util.printList(solution.largeGroupPositions("abc"));
        Util.printList(solution.largeGroupPositions("abcdddeeeeaabbbcd"));
        Util.printList(solution.largeGroupPositions("aba"));
    }
}
