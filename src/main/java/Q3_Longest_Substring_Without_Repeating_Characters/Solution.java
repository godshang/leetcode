package Q3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), -1);
        }

        int max = 0, pre = -1;
        for (int i = 0; i < s.length(); i++) {
            pre = Math.max(pre, map.get(s.charAt(i)));
            max = Math.max(max, i - pre);
            map.put(s.charAt(i), i);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}
